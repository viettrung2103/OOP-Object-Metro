package Week1.Task2.A22;

import java.util.Arrays;
import java.util.PriorityQueue;

public class EventList {
    PriorityQueue<Event> queue;

    public EventList() {
        this.queue = new PriorityQueue<>();
    }

    public void addEvent(Event e) {
        System.out.println("Adding " + e.getName() + "with start time " + e.getStartTime());
        this.queue.add(e);
    }

    public Event removeEvent() {
        Event removed = this.queue.remove();
        System.out.println("Remove " + removed.getName() + " from queue.");
        return removed;
    }

    public void printEventList() {
        Object[] convertedArray = this.queue.toArray();
        for (Object event : convertedArray) {
            System.out.println("This is " + event);
        }


//        if (this.queue.peek() == null) {
//            System.out.println("This queue is empty");
//        } else {
//            System.out.println("The list of events: ");
//            while (this.queue.peek() != null) {// if the first element of the queue is not empty
//                System.out.println(this.queue.poll()); //return the head of the queue and remove its from the queue
//            }
//
//        }
    }

    public static void main(String[] args) {
        EventList el = new EventList();
        Event e1 = new Event("Event1");
        e1.setStartTime(System.currentTimeMillis());
        System.out.println(e1);
        el.addEvent(e1);
        Event e2 = new Event("Event2");
        e2.setStartTime(System.currentTimeMillis());
        System.out.println(e2);
        el.addEvent(e2);
        Event e3 = new Event("Event3");
        e3.setStartTime((System.currentTimeMillis() + 10));
        System.out.println(e3);
        el.addEvent(e3);

//        Event e3 = new Event("Event3");
//        e3.setStartTime(System.currentTimeMillis());
//        System.out.println(e3);
//        el.addEvent(e3);

        el.printEventList();
        Event removed = el.removeEvent();
        System.out.println(removed);
        el.printEventList();


    }

}
