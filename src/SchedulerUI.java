import javax.swing.*;
public class SchedulerUI {
    public static void main(String[] a) {
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JDialog days = new JOptionPane().createDialog(null,"Herro");
        String[] day = {"Mon","Tues","Wed"};
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(days);//showInputDialog(null, "What is your favorite pizza?", "Favorite Pizza", JOptionPane.QUESTION_MESSAGE, null, day, day[0]));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("x value: " + xField.getText());
            System.out.println("y value: " + yField.getText());
        }
    }
}
