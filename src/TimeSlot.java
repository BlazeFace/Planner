import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Holds date priority and a description
 */

public class TimeSlot implements Comparable<TimeSlot> {
    private SimpleDateFormat a = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
    private int pri;
    private String desc;
    private double length;
    private Date date = new Date();

    public TimeSlot() throws ParseException {
        this.date = a.parse("Sat Jun 01 12:53:10 IST 2010");
        this.pri = 1;
        this.desc = "TEMP";
    }

    public TimeSlot(String entry, int priority, double length, String desc) throws ParseException {
        this.date = a.parse(entry);
        this.pri = priority;
        this.desc = desc;
        this.length = length;
    }

    public TimeSlot(String entry) throws ParseException {
        this.date = a.parse(entry);
        this.pri = 1;
        this.desc = " ";
        this.length = .5;
    }

    public int getPriority() {
        return this.pri;
    }

    public String getDesc() {
        return this.desc;
    }

    public Date getDate() {
        return this.date;
    }

    public int compareTo(TimeSlot t) {
        Date c = this.getDate();
        if (c.equals(t.getDate())) {
            return 0;
        }
        if (c.before(t.getDate())) {
            return -1;
        } else {
            return 1;
        }
    }

    public String toString() {
        return this.getDate() + "|" + this.getPriority() + "|" + this.getDesc();
    }

    public double getLength() {
        return this.length;
    }
}

