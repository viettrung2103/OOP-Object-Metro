package Week2.Thursday;

public class Event implements Comparable<Event> {
    private long startTime;
    private String type;

    private String eventName;

    @Override
    public String toString() {
        return this.startTime + "[" + this.type + "]";
    }

    @Override
    public int compareTo(Event o) {
        // sort in ascend order
        if (this.startTime < o.startTime) {
            return -1;
        } else if (this.startTime > o.startTime) {
            return 1;

        } else return 0;
    }
}
