package Week1.Task3.A37.assignment;

import Week1.Task3.A37.distributions.Negexp;

import java.util.PriorityQueue;
import java.util.Random;

public class ArrivalProcess {
    private static final double meanNumX = 5;
    private static final double meanNumY = 15;
    private static final long seedNum = 123;
    Negexp numGenerator;
    Random typeGenerator;

//    public void ArrivalProcess() {
////        this.numGenerator = new Negexp(meanNumX, seedNum);
//        typeGenerator = new Random(seedNum);
//    }

    public ArrivalProcess() {
        this.numGenerator = new Negexp(meanNumY, seedNum);
        typeGenerator = new Random(seedNum);
    }

    private void createNumberGenerator(CustomerType customerType) {
        double mean = 1;
        if (customerType.name().equals("X")) {
            mean = meanNumX;
        } else {
            mean = meanNumY;
        }
        // because we create a new numgenerator everytime we get num, as the parameter is the same, it always input the first number
//        this.numGenerator = new Negexp(mean, seedNum);
        this.numGenerator = new Negexp(mean);

    }

    private double getArrivalTime(Customer customer) {
        CustomerType customerType = customer.getCustomerType();
        this.createNumberGenerator(customerType);
        return Math.ceil(this.numGenerator.sample());
    }

    private EventType getEventType() {
        int num = typeGenerator.nextInt(1, 3);
        if (num % 2 == 0) {
            return EventType.EXIT;
        } else
            return EventType.ARRIVAL;
    }

    private CustomerType getCustomerType() {
        int num = typeGenerator.nextInt(1, 5);
        if (num == 4) {
            return CustomerType.Y;
        } else
            return CustomerType.X;
    }

    public EventList createEvent(EventList queue) {
        CustomerType customerType = this.getCustomerType();
        Customer newCustomer = new Customer(customerType);
        double arrivalTime = this.getArrivalTime(newCustomer);
//        EventType eventType = this.getEventType();
        Event newEvent = new Event(newCustomer, EventType.ARRIVAL, arrivalTime);
        queue.addEvent(newEvent);
        return queue;
    }



    public static void main(String[] args) {
//        Clock clock = Clock.getInstance();
//        ArrivalProcess arrivalProcess = new ArrivalProcess();
//        EventList queue = new EventList();
//
//        // create 10 events
//        for (int i = 0; i <= 10; i++) {
////            System.out.println(arrivalProcess.getEventType());
////            double ranNum = arrivalProcess.getArrivalTime();
////            System.out.println("Random number: " + ranNum);
//            queue = arrivalProcess.createEvent(queue);
//        }
//        PriorityQueue<Event> tempQueue = new PriorityQueue<>();
//        while (queue.getQueue().peek() != null) {
//            Event removedEvent = queue.getQueue().poll();
//            clock.setCurTime(removedEvent.getStartTime());
//            System.out.println(removedEvent);
//            tempQueue.add(removedEvent);
//        }
//        queue.setQueue(tempQueue);
//
//
//        queue.printEventList();

    }
}
