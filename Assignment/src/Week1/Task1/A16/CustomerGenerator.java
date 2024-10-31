package Week1.Task1.A16;

public class CustomerGenerator {
    public CustomerGenerator(int numOfCustomers, ServicePoint sp) {
        // we dont need any varibable here as we dont store here, we only use this class to generate customer
        for (int i = 0; i < numOfCustomers; i++) {
            sp.addToQueue(new Customer());
        }
    }
}
