import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 * Array of Time Slots
 */

public class Scheduler implements Iterable<TimeSlot> {
    private int aSize = 0;
    private Hashtable<String, TimeSlot> find = new Hashtable<>();
    private ArrayList<TimeSlot> dates = new ArrayList<TimeSlot>();

    public Scheduler(Hashtable<String, TimeSlot> fin, ArrayList<TimeSlot> dates) {
        this.find = fin;
        this.dates = dates;
    }

    public Scheduler() {
    }

    public ArrayList<TimeSlot> get() {
        return this.dates;
    }

    private void putSlot(TimeSlot a) {
        dates.add(a);
        Sort.selection(this);
        find.put(a.getDesc(), a);
    }

    public void addSlot(TimeSlot a) {
        if (this.conflicts(a).getConflict()) {
            if (this.conflicts(a).getT().getPriority() > a.getPriority()) {
                dates.remove(this.conflicts(a).getT());
                this.putSlot(a);
                return;
            } else throw new IllegalArgumentException("Conflict with date");
        }
        aSize++;
        dates.add(a);
        Sort.selection(this);
        find.put(a.getDesc(), a);
    }

    public Date getDate(int index) {
        return dates.get(index).getDate();
    }

    public String toString() {
        ArrayList<TimeSlot> g = this.get();
        StringBuilder l = new StringBuilder("");
        for (int i = 0; i < g.size(); i++) {
            l.append(g.get(i).toString() + "\n");
        }
        return l.toString();
    }

    public TimeSlot find(String d) {
        if (find.containsKey(d)) {
            return find.get(d);
        } else throw new IllegalArgumentException("Key Not Found");
    }

    public Conflict conflicts(TimeSlot t) {
        double tLength = (t.getLength() * 60 * 60 * 1000);
        double nextTime = t.getDate().getTime() + tLength;
        for (TimeSlot f : dates) {
            double fLength = (f.getLength() * 60 * 60 * 1000);
            double firstTime = f.getDate().getTime() + fLength;
            if (nextTime - tLength == firstTime - fLength) {
                return new Conflict(true, f);
            }
            if (firstTime > nextTime - tLength && firstTime < nextTime || firstTime - fLength > nextTime - tLength && firstTime - fLength < nextTime) {
                return new Conflict(true, f);
            }
        }
        return new Conflict(false, null);
    }

    public Conflict conflicts(Scheduler t){
        Scheduler b = new Scheduler(this.find, this.dates);
            for (TimeSlot g : t){
                if(b.conflicts(g).getConflict()){
                    return new Conflict(true, g);
                }
            }

        return new Conflict(false, t.get(0));
    }


//STARTS ITERATOR


    class ArrayIterator implements Iterator<TimeSlot> {
        int current = 0;  // the current element we are looking at

        // return whether or not there are more elements in the array that
        // have not been iterated over.
        public boolean hasNext() {
            if (current < Scheduler.this.dates.size()) {
                return true;
            } else return false;
        }

        // return the next element of the iteration and move the current
        // index to the element after that.
        public TimeSlot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return dates.get(current++);
        }
    }

    // Return the value at a given index
    public TimeSlot get(int index) {
        return dates.get(index);
    }

    // Set the value at a given index
    public void set(int index, TimeSlot value) {
        dates.set(index, value);
    }

    // Return the length of the array
    public int length() {
        return dates.size();
    }

    // Return an iterator over the elements in the array. This is generally not
    // called directly, but is called by Java when used in a "simple" for loop.
    public Iterator<TimeSlot> iterator() {
        return new ArrayIterator();
    }
}
