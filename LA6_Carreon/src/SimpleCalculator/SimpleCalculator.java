package SimpleCalculator;

import LeapYearChecker.LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    private JTextField tfNumber1;
    private JPanel pMain;
    private JTextField tfNumber2;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JLabel lbResult;

    SimpleCalculator(){
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int first = Integer.parseInt(tfNumber1.getText().trim());
                    int second = Integer.parseInt(tfNumber2.getText().trim());
                    int result = 0;

                    if (cbOperations.getSelectedIndex() == 0) {
                        result = first + second;
                    } else if (cbOperations.getSelectedIndex() == 1) {
                        result = first - second;
                    } else if (cbOperations.getSelectedIndex() == 2) {
                        result = first * second;
                    } else if (cbOperations.getSelectedIndex() == 3) {
                        if(second == 0){
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        result = first / second;
                    } else {
                        result = 0;
                    }

                    lbResult.setText(String.valueOf(result));
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }catch (ArithmeticException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setTitle("Simple Calculator");
        calculator.setContentPane(calculator.pMain);
        calculator.setSize(500, 200);
        calculator.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }
}
