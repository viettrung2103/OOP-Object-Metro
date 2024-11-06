package Week1.Task3.A37.assignment;


public class Event implements Comparable<Event> {
    private static int arriveCount = 1;
    private static int exitCount = 1;
    private double time;
    private long insertTime;
    private String name;
    private Customer customer;
    EventType eventType;

    public Event(Customer customer, EventType eventType, double time) {
        this.eventType = eventType;
        this.time = time;
        this.customer = customer;
        this.insertTime = System.currentTimeMillis();
        this.name = setName();

    }

    private String setName() {

        String newName = this.eventType + " Event of " + this.customer.getName();

        return newName;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTime() {
        return this.time;
    }

    public String getName() {
        return this.name;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    @Override
    public int compareTo(Event e) {
        if (this.time > e.time) {
            return 1;
        } else if (this.time < e.time) {
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
        return this.name + " " + "Start Time: t = " + this.time;
    }

}
