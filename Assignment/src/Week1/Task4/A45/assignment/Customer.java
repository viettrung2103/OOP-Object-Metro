package Week1.Task4.A45.assignment;

public class Customer {
    private int id;
    private double startTime;
    private double endTime;

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

    public double getArrivalTime() {
        return this.startTime;
    }

    public void setArrivalTime(double time) {
        this.startTime = time;
    }

    public double getEndTime() {
        return this.endTime;
    }

    public void setEndTime(double time) {
        this.endTime = time;
    }


    public double duration() {
        return this.endTime - this.startTime;
    }

    public boolean isSameName(Customer anotherCustomer) {
        if (anotherCustomer == null) {
            return false;
        }

        return this.name.equals(anotherCustomer.getName());

    }

    public String toString() {
        if (this.startTime != 0 && this.endTime != 0) {
            return "Customer #" + this.name + " has been served,Start time t = " + this.getArrivalTime() + ", Total response time = " + this.duration();

        } else if (this.startTime != 0) {
            return "Customer #" + this.name + ", Start time = " + this.startTime;

        } else {
            return "Customer #" + this.name;
        }

    }

    // service time is time between the start of service and the end of the service
    // the Response time is the service time + the waiting time in the queue


    public static void main(String[] args) {
        Customer customer1 = new Customer(CustomerType.X);
        Customer customer2 = new Customer(CustomerType.Y);
        Customer customer3 = new Customer(CustomerType.X);
        Customer customer4 = new Customer(CustomerType.Y);

        customer1.setArrivalTime(1.0);
        customer1.setEndTime(customer1.startTime + 10);

        customer2.setArrivalTime(2);
        customer2.setEndTime(customer2.startTime + 20);

        customer3.setArrivalTime(3);
        customer3.setEndTime(customer3.startTime + 10);

        customer4.setArrivalTime(4);
        customer4.setEndTime(customer4.startTime + 20);

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);

    }
}
