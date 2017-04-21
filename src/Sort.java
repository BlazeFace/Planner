import java.sql.Time;
import java.util.ArrayList;

/**
 * Sorts Dates
 */
public class Sort {
    private static double xd =.051;
    public static void draw (double[] val){
        double max = Double.MIN_VALUE;
        for(int i = 0; i < val.length; i++) if(max < val[i]) max = val[i];
        StdDraw.setPenColor(StdDraw.BLACK);
        for(int i = 0; i < val.length; i++){
            StdDraw.filledRectangle((double) (2 * i + 1) / val.length / 2, val[i] / max * 0.5, 0.5 / val.length * 0.9, val[i]/max * 0.5);
        }
    }
    public static void aniselection(double[] vals){
       // draw(vals);
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i < vals.length - 1; i++)
        {
            StdDraw.disableDoubleBuffering();
            int num = i;
            for (int j = i + 1; j < vals.length; j++){
                if (vals[j] < vals[num]){  //Checks for lowest value
                    num = j;
                }
            }
            double min = vals[num];
            vals[num] = vals[i];  //assigns value to final sub array
            vals[i] = min;
            StdDraw.enableDoubleBuffering();
            StdDraw.clear();
            draw(vals);
            StdDraw.show();


        }
       // draw(vals);

    }
    public static void selection(Scheduler val){
    ArrayList<TimeSlot> vals = val.get();
        for (int i = 0; i < vals.size() - 1; i++) {

            int num = i;
            for (int j = i + 1; j < vals.size(); j++) {
                if (vals.get(j).getDate().before(vals.get(num).getDate())) {  //Checks for lowest value
                    num = j;
                }
            }
            TimeSlot min = vals.get(num);
            //assigns value to final sub array
            vals.set(num,vals.get(i));
            vals.set(i, min);

        }
    }
    public static void selection(Scheduler val, boolean pri){
        if(pri) {
            ArrayList<TimeSlot> vals = val.get();
            for (int i = 0; i < vals.size() - 1; i++) {
                int num = i;
                for (int j = i + 1; j < vals.size(); j++) {
                    if (vals.get(j).getPriority() < vals.get(num).getPriority()) {  //Checks for lowest value
                        num = j;
                    }
                }
                TimeSlot min = vals.get(num);
                //assigns value to final sub array
                vals.set(num,vals.get(i));
                vals.set(i, min);


            }
        }
    }
    public static void main(String[] args){
        double[] kickerNumbers = new double[1000];
        for(int i = 0; i < kickerNumbers.length; i++) {
            kickerNumbers[i] = (int)(Math.random()*100);
        }
       // System.out.println(isSorted(kickerNumbers));
        System.out.println(kickerNumbers[0]);
        aniselection(kickerNumbers);
        System.out.println(kickerNumbers[0]);
      //  System.out.println(isSorted(kickerNumbers));

    }
}
