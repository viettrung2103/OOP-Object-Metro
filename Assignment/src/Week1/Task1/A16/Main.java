package Week1.Task1.A16;


public class Main {
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();
        int numOfCustomer = 10;
        new CustomerGenerator(numOfCustomer, servicePoint);
        servicePoint.serve();
        servicePoint.displayAverageServeTime();
    }
}
