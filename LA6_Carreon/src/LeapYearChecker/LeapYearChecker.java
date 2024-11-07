package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame{
    private JTextField yearTextField;
    private JPanel pMain;
    private JButton checkYearButton;

    LeapYearChecker(){
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = Integer.parseInt(yearTextField.getText().trim());

                if(year% 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    JOptionPane.showMessageDialog(null, "Leap year");
                }else{
                    JOptionPane.showMessageDialog(null, "Not a leap year");
                }
            }
        });
    }

    public static void main(String[] args) {
        LeapYearChecker leap = new LeapYearChecker();
        leap.setTitle("Leap Year Checker");
        leap.setContentPane(leap.pMain);
        leap.setSize(300, 150);
        leap.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leap.setVisible(true);
    }
}
