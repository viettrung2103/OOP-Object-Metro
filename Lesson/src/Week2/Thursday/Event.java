package Week2.Thursday;

public class Event implements Comparable<Event> {
    private long time;
    private String type;

    private String eventName;

    @Override
    public String toString() {
        return this.time + "[" + this.type + "]";
    }

    @Override
    public int compareTo(Event o) {
        // sort in ascend order
        if (this.time < o.time) {
            return -1;
        } else if (this.time > o.time) {
            return 1;

        } else return 0;
    }
}
