package Week2.Thursday;

import java.util.PriorityQueue;

public class EventList {
    // this is java collection in priority
    private PriorityQueue<Event> events;

    public EventList() {
        this.events = new PriorityQueue<>();
    }

    public Event remove() {
        if (events.isEmpty()) return null;
        return events.remove(); // remove the first time in the list
    }

    public void add(Event event) {
        this.events.add((event));
    }

}
