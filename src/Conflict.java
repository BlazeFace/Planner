/**
 * Created by nate on 4/17/17.
 */
public class Conflict {
    private boolean conf;
    private TimeSlot t;
    public Conflict(boolean conf, TimeSlot t){
        this.conf = conf;
        this.t = t;
    }
    public boolean getConflict(){return conf;}

    public TimeSlot getT() {return t;}

    public String toString(){
        return "Conflict was "+getConflict()+" at "+getT().toString();
    }
}
