package Week1.Task4.A45.assignment;

import java.util.LinkedList;
import java.util.Random;

public class ServicePoint {

    private LinkedList<Customer> queue;
    private Random rand;
    private double averageServeTime;
    private long totalServeTime;
    private int servedCount;
    private boolean isBusy;
    private static final int SERVETIME = 1;
    private Customer curCustomer;
    private ServicePointType servicePointType;

    public ServicePoint(ServicePointType servicePointType) {
        this.queue = new LinkedList<>();
        this.rand = new Random();
        this.averageServeTime = 0.0;
        this.totalServeTime = 0;
        this.servedCount = 0;
        this.servicePointType = servicePointType;
        this.isBusy = false;
        this.curCustomer = null;
    }

    public ServicePointType getServicePointType() {
        return this.servicePointType;
    }

    public boolean isSPQueueEmpty() {
        return this.queue.isEmpty();
    }

    public void addToQueue(Customer customer, Clock clock) {

        if (customer.getArrivalTime() == 0) {

            customer.setArrivalTime(clock.getCurTime());
        }
        System.out.println("Adding Customer " + customer.getName() + " with start time t = " + customer.getArrivalTime() + " to queue of service "+this.getServicePointType());
        queue.addFirst(customer);
    }

    public Customer removeFromQueue() {
        if (queue.size() > 0) {
            return queue.removeLast();
        } else
            return null;
    }


//    public void serve() {
//        long tic, toc;
//        Customer customer = this.removeFromQueue();
//        while (customer != null) {
//            //simulate the service time
//            tic = System.currentTimeMillis();
//            try {
//                final int lowerLimit = 50;
//                final int upperLimit = 200;
////                Thread.sleep(100);
//                Thread.sleep(lowerLimit + rand.nextInt(upperLimit));// service time from 50ms - 99ms // uniform distribution
//
//            } catch (InterruptedException e) {
//            }
//            toc = System.currentTimeMillis();
//            customer.setEndTime(toc);
//            long duration = toc - tic;
//            System.out.println("Customer #" + customer.getId() + " service time is " + duration + " ms");
//            System.out.println(customer);
//            this.servedCount++;
//            this.totalServeTime += duration;
//
//            customer = this.removeFromQueue();
//        }
//        this.averageServeTime = totalServeTime * 1.0 / servedCount;
//    }

    public Customer getServingCustomer() {
        return this.curCustomer;
    }

    public Event serveExitCustomer(Customer newCustomer, Clock clock, ServeProcess serveProcess) {
        Event newEvent = null;
        System.out.println(this.curCustomer);
        this.servedCount++;
        this.isBusy = false;
        this.curCustomer = null;
        // after serving the customer, receiving next customer from sp queue
        // the below is wrong
        if (!this.isSPQueueEmpty())
            newEvent = this.serveArrivalCustomer(clock, serveProcess);
        // the correct one should be generate new arrival event
        return newEvent;
    }

    public Event serveArrivalCustomer(Clock clock, ServeProcess serveProcess) {
        double startTime, endTime;
        Event finishEvent = null;

        // serve the next customer which must have type Arrival
        if (!this.isBusy) {
            // if sp is not busy, it will take the first customer from
            Customer customer = this.removeFromQueue();
            //
            if (customer != null) {
                this.isBusy = true;
                startTime = clock.getCurTime();
                double serveTime = serveProcess.generateServeTime(this);
                System.out.println("random serve time: " + serveTime);
                endTime = startTime + serveTime;
                customer.setEndTime(endTime);
                this.curCustomer = customer;
                System.out.println("Customer " + customer.getName() + " is being served, expected finish at t = " + customer.getEndTime());
                finishEvent = new Event(customer, EventType.EXIT, endTime);
            }
        } else {
            System.out.println("Service point is busy, " + this.seeFirstPosition().getName() + " is waiting in queue of service point " + this.getServicePointType());
        }
        return finishEvent;
    }

    public Customer seeFirstPosition() {
        return this.queue.peek();
    }

    public double getAverServeTime() {
        return this.averageServeTime;
    }

    public void displayAverageServeTime() {
        System.out.println("Average serve time is " + this.getAverServeTime() + " ms");
    }
}
