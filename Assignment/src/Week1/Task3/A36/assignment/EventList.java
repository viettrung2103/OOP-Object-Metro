package Week1.Task3.A36.assignment;

import java.util.Arrays;
import java.util.PriorityQueue;


public class EventList {
    private PriorityQueue<Event> queue;

    public EventList() {
        this.queue = new PriorityQueue<>();
    }

    public void addEvent(Event e) {
        System.out.println("Adding " + e.getName() + " with start time " + e.getStartTime());
        this.queue.add(e);
    }

    public Event removeEvent() {
        Event removed = this.queue.remove();
        System.out.println("Remove " + removed.getName() + " from queue.");
        return removed;
    }

    public void printEventList() {
        PriorityQueue<Event> tempQueue = new PriorityQueue<>();
        while (queue.peek() != null) {
            Event removedEvent = queue.poll();
            System.out.println(removedEvent);
            tempQueue.add(removedEvent);
        }
        this.queue = tempQueue;
    }

    public PriorityQueue<Event> getQueue() {
        return this.queue;
    }

    public void setQueue(PriorityQueue<Event> queue) {
        this.queue = queue;
    }

//    public void get

    public static void main(String[] args) {
        EventList el = new EventList();
        Event e1 = new Event(EventType.ARRIVAL, 1);
//        e1.setStartTime(System.currentTimeMillis());
        System.out.println(e1);
        el.addEvent(e1);
        Event e2 = new Event(EventType.EXIT, 2);
//        e2.setStartTime(System.currentTimeMillis());
        System.out.println(e2);
        el.addEvent(e2);
        Event e3 = new Event(EventType.ARRIVAL, 3);
//        e3.setStartTime((System.currentTimeMillis() + 10));
        System.out.println(e3);
        el.addEvent(e3);

        el.printEventList();
        Event removed = el.removeEvent();
        System.out.println(removed);
        el.printEventList();


    }

}