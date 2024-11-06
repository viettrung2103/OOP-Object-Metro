package Week1.Task3.A36.assignment;

import Week1.Task3.A36.distributions.Negexp;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class ArrivalProcess {
    private static final double meanNum = 5;
    private static final long seedNum = 123;
    Negexp numGenerator;
    Random typeGenerator;

    public ArrivalProcess() {
        this.numGenerator = new Negexp(meanNum, seedNum);
        typeGenerator = new Random(seedNum);
    }

    private double getArrivalTime() {
        return Math.ceil(this.numGenerator.sample());
    }

    private EventType getEventType() {
        int num = typeGenerator.nextInt(1, 3);
        if (num % 2 == 0) {
            return EventType.EXIT;
        } else
            return EventType.ARRIVAL;

    }

    public EventList createEvent(EventList queue) {
        double startTime = this.getArrivalTime();
        EventType eventType = getEventType();
        Event newEvent = new Event(eventType, startTime);
        queue.addEvent(newEvent);
        return queue;
    }

    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        ArrivalProcess arrivalProcess = new ArrivalProcess();
        EventList queue = new EventList();

        // create 10 events
        for (int i = 0; i <= 10; i++) {
//            System.out.println(arrivalProcess.getEventType());
//            double ranNum = arrivalProcess.getArrivalTime();
//            System.out.println("Random number: " + ranNum);
            queue = arrivalProcess.createEvent(queue);
        }
        PriorityQueue<Event> tempQueue = new PriorityQueue<>();
        while (queue.getQueue().peek() != null) {
            Event removedEvent = queue.getQueue().poll();
            clock.setCurTime(removedEvent.getStartTime());
            System.out.println(removedEvent);
            tempQueue.add(removedEvent);
        }
        queue.setQueue(tempQueue);


//        queue.printEventList();

    }
}