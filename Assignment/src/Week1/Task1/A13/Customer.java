package Week1.Task1.A13;

public class Customer {
    private static int id = 1;
    private int customerId;
    private long startTime;
    private long endTime;

    public Customer() {
        this.customerId = id;
        this.startTime = System.currentTimeMillis();
        this.endTime = 0;
        id++;
    }

    public long timeSpent() {
        this.endTime = System.currentTimeMillis();
        long duration = this.endTime - this.startTime;
        return duration;
    }

    @Override
    public String toString() {
        return "Customer " + this.customerId;
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        try {
            Thread.sleep(1000);
            long duration1 = customer1.timeSpent() / 1000; // convert to second
            System.out.println(customer1 + " spent " + duration1 + " seconds");
            Thread.sleep(1000);
            long duration2 = customer2.timeSpent() / 1000; // convert to second
            System.out.println(customer2 + " spent " + duration2 + " seconds");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
