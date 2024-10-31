package Week1.Task1.A15;

import java.util.LinkedList;
import java.util.Random;

public class ServicePoint {

    private LinkedList<Customer> queue;
    private Random rand;

    public ServicePoint() {
        this.queue = new LinkedList<>();
        this.rand = new Random();

    }

    public void addToQueue(Customer customer) {
        customer.setArrivalTime(System.currentTimeMillis());
        queue.addFirst(customer);
    }

    public Customer removeFromQueue() {
        if (queue.size() > 0) {
            return queue.removeLast();
        } else
            return null;
    }

    public static void main(String[] arge) {
        ServicePoint sp = new ServicePoint();
        for (int i = 0; i < 10; i++) {
            sp.addToQueue(new Customer());
//            System.out.println();
        }


    }

    void serve() {
        long tic, toc;
        Customer customer = this.removeFromQueue();
        while (customer != null) {
            //simulate the service time
            tic = System.currentTimeMillis();
            try {
                final int lowerLimit = 50;
                final int upperLimit = 200;
//                Thread.sleep(100);
                Thread.sleep(lowerLimit + rand.nextInt(upperLimit));// service time from 50ms - 99ms // uniform distribution

            } catch (InterruptedException e) {
            }
            toc = System.currentTimeMillis();
            customer.setEndTime(toc);
            System.out.println("Customer #" + customer.getId() + " service time is " + (toc - tic) + " ms");
            System.out.println(customer);
            customer = this.removeFromQueue();
        }
    }
}
