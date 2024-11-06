package Week1.Task3.A36.assignment;


public class Event implements Comparable<Event> {
    private static int arriveCount = 1;
    private static int exitCount = 1;
    private double startTime;
    private long insertTime;
    private String name;
    EventType eventType;

    public Event(EventType eventType, double startTime) {
        this.eventType = eventType;
        this.startTime = startTime;
        this.insertTime = System.currentTimeMillis();
        this.name = setName();

    }

    private String setName() {
        int count = 0;
        if (this.eventType.name().equals("ARRIVAL")) {
            count = arriveCount++;
        } else {
            count = exitCount++;
        }
        String newName = this.eventType + String.valueOf(count);

        return newName;
    }

    public void setStartTime(double time) {
        this.startTime = time;
    }

    public double getStartTime() {
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
        if (this.startTime > e.startTime) {
            return 1;
        } else if (this.startTime < e.startTime) {
            return -1;
        } else {
            // When start times are equal, compare by insertion time for FIFO order.
            return Long.compare(this.insertTime, e.insertTime);
    }
//            if (this.insertTime > e.insertTime) {
//                return 1;
//            } else if (this.insertTime < e.insertTime) {
//                return -1;
//
//            } else {
//                return 0;
//            }
//        }
}

@Override
public String toString() {
    return this.name + " " + "Start Time: " + this.startTime + " Type: " + this.eventType;
}

}
