package Week1.Task1.A14;

public class Customer {
    private static int _id = 1;
    private int customerId;
    private long startTime;
    private long endTime;

    public Customer() {
        this.customerId = _id++;
//        this.startTime = System.currentTimeMillis();
        this.endTime = 0;
        this.startTime = 0;

    }

    public void setStartTime(long time) {
        this.startTime = time;
    }

    public void setEndTime(long time) {
        this.endTime = time;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long timeSpent() {
//        this.endTime = System.currentTimeMillis();
        long duration = this.endTime - this.startTime;
        return duration;
    }

    @Override

    public String toString() {

        String text = "Customer " + this.customerId;
        if (this.startTime > 0) {
            text = text + "- start: " + this.startTime;
        }
        if (this.endTime > 0 && this.startTime > 0) {
            text = text + " - end: " + this.endTime + "\nTotal time spent in queue: " + this.timeSpent() + "ms";
        }

        return text;
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
