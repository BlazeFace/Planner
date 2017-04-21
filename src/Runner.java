import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class Runner {
    public static void main(String[] args) {
        String[] b = new String[3];
        Scheduler a = new Scheduler();
        b[0] = "Sat Jun 01 12:53:10 IST 2020";
        for (int i = 1; i < b.length; i++) {
            b[i] = "Sat Jun 01 12:53:10 IST 201" + i;
        }
        try {
            for (String str : b) {
                TimeSlot h = new TimeSlot(str, (int) (10 * Math.random()), Math.random(), "Ayy");
                a.addSlot(h);
            }
            TimeSlot h = new TimeSlot("Sat Jun 09 12:24:10 IST 2014", (int) (10 * Math.random()), 1, "a");
            a.addSlot(h);
            Sort.selection(a, true);
            System.out.print(a + "\n");
            System.out.println(a.conflicts(h) + ":)");
        } catch (ParseException e) {
            System.out.println("Error: Illegal Date Format");
        }


        System.out.println(a.find("a"));
    }
}
