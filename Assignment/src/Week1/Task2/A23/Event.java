package Week1.Task2.A23;


public class Event implements Comparable<Event> {
    private long startTime;
    private String name;
    EventType eventType;

    public Event(String name, EventType eventType) {
        this.name = name;
        this.eventType = eventType;

    }

    public void setStartTime(long time) {
        this.startTime = time;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getName() {
        return this.name;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    @Override
    public int compareTo(Event e) {
        if (this.startTime < e.startTime) {
            return -1;
        } else if (this.startTime == e.startTime) {
            return 0;
        } else {
            return 1;
        }

//        if (this.startTime < o.startTime) {
//            return -1;
//        } else if (this.startTime > o.startTime) {
//            return 1;
//
//        } else return 0;
    }

    @Override
    public String toString() {
        return this.name + " " + "Start Time: " + this.startTime + " Type: " + this.eventType;
    }

}
