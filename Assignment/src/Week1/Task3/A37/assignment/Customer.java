package Week1.Task3.A37.assignment;

public class Customer {
    private int id;
    private long startTime;
    private long endTime;

    CustomerType customerType;
    private static int countX = 1;
    private static int countY = 1;
    private String name;

    public Customer(CustomerType customerType) {
        this.customerType = customerType;
        this.setName();
        this.setId();
    }

    private void setName() {
        if (this.customerType.name().equals("X")) {
            this.name = "X" + countX;

        } else {
            this.name = "Y" + countY;

        }
    }

    public String getName() {
        return this.name;
    }

    private void setId() {
        if (this.customerType.name().equals("X")) {
            this.id = countX++;
        } else {
            this.id = countY++;
        }
    }

    public CustomerType getCustomerType() {
        return this.customerType;
    }


    public int getId() {
        return this.id;
    }

    public long getArrivalTime() {
        return this.startTime;
    }

    public void setArrivalTime(long time) {
        this.startTime = time;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long time) {
        this.endTime = time;
    }


    public long duration() {
        return this.endTime - this.startTime;
    }

    public String toString() {
        return "Customer #" + this.name + ", Total response time = " + this.duration();
    }

    // service time is time between the start of service and the end of the service
    // the Response time is the service time + the waiting time in the queue


    public static void main(String[] args) {
        Customer customer1 = new Customer(CustomerType.X);
        Customer customer2 = new Customer(CustomerType.Y);
        Customer customer3 = new Customer(CustomerType.X);
        Customer customer4 = new Customer(CustomerType.Y);

        customer1.setArrivalTime(System.currentTimeMillis());
        customer1.setEndTime(System.currentTimeMillis() + 10);

        customer2.setArrivalTime(System.currentTimeMillis());
        customer2.setEndTime(System.currentTimeMillis() + 20);

        customer3.setArrivalTime(System.currentTimeMillis());
        customer3.setEndTime(System.currentTimeMillis() + 10);

        customer4.setArrivalTime(System.currentTimeMillis());
        customer4.setEndTime(System.currentTimeMillis() + 20);

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);

    }
}
