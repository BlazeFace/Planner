import java.text.ParseException;
import java.util.Hashtable;
public class TESTS {
    public static void testConflict(){
        Scheduler a = new Scheduler();
        try{
            TimeSlot h = new TimeSlot("Sat Jun 02 12:00:00 IST 2010",(int)(10*Math.random()), 1, "a");
            TimeSlot t = new TimeSlot("Sat Jun 01 12:59:00 IST 2010",(int)(10*Math.random()), 1, "a");
            a.addSlot(h);
            a.addSlot(t);
            TimeSlot l = new TimeSlot("Sat Jun 01 12:00:00 IST 2010",(int)(10*Math.random()), .4, "a");
            System.out.println(h.getDate().getTime());
            System.out.println(t.getDate().getTime());
            System.out.println(l.getDate().getTime());
            System.out.println(a.conflicts(l));
        }
        catch (ParseException e){
            System.out.println("Error: Illegal Date Format");
        }

    }
    public static void main(String[] args) throws ParseException {
        Hashtable a = new Hashtable();
        TimeSlot h = new TimeSlot();
        a.put(h.getDesc(), h);
        if(a.containsKey(h.getDesc())){
            System.out.println(a.get(h.getDesc()));}
        else System.out.println("Fail");
        testConflict();
        }
    }

