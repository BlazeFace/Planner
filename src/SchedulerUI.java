import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SchedulerUI extends JFrame {
    private String a[] = {"Mon","Tues"};
    private String b[] = {"Jan","Feb"};
    private String c[] = {"2016","2017"};
    public SchedulerUI() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(new JLabel("Enter Date"));
        cp.add(new JComboBox<>(a));
        cp.add(new JComboBox<>(b));
        cp.add(new JTextField("00:00:00"));
        cp.add(new JComboBox<>(c));
        cp.add(new JButton());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dates");  // "super" JFrame sets title
        setSize(300, 150);   // "super" JFrame sets initial size
        setVisible(true);    // "super" JFrame shows
    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchedulerUI();  // Let the constructor do the job
            }
        });
    }
}
