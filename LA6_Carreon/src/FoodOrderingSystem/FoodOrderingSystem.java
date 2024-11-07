package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JPanel pMain;
    private JButton btnOrder;
    private final int[] prices = {100, 80, 65, 55, 50, 40};
    private final JRadioButton[] discountGroup = {rbNone, rb5, rb10, rb15};
    private final double[] discountValue = {0.0, .05, .1, .15};
    private final JCheckBox[] foodGroup = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};

    FoodOrderingSystem(){
        rbNone.setSelected(true);
        btnOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double totalPrice = 0;
                boolean foodSelected = false;

                for(int i = 0; i < 6; i++){
                    if(foodGroup[i].isSelected()){
                        totalPrice += prices[i];
                        foodSelected = true;
                    }
                }

                if(!foodSelected){
                    JOptionPane.showMessageDialog(null, "Please select at least one food");
                    return;
                }

                    for(int i = 0; i < 4; i++){
                        if(discountGroup[i].isSelected()){
                            double d = totalPrice * discountValue[i];
                            totalPrice -= d;
                            String formattedPrice = String.format("%.2f", totalPrice);
                            JOptionPane.showMessageDialog(null, "The total price is Php" + formattedPrice);
                            break;
                        }

                }
                    for(JCheckBox c: foodGroup){
                        c.setSelected(false);
                    }
                    rbNone.setSelected(true);
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderingSystem order = new FoodOrderingSystem();
        order.setTitle("Food Ordering System");
        order.setContentPane(order.pMain);
        order.setSize(350, 350);
        order.setDefaultCloseOperation(EXIT_ON_CLOSE);
        order.setVisible(true);
    }
}
