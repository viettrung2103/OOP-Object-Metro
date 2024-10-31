package Week1.Task1.A16;

public class Customer {
    private int id;
    private long startTime;
    private long endTime;
    private static  int _id = 1;

    public Customer(){
        this.id = _id;
        _id++;
    }

    public int getId(){
        return this.id;
    }

    public long getArrivalTime(){
        return this.startTime;
    }

    public void setArrivalTime(long time){
        this.startTime = time;
    }

    public long getEndTime(){
        return this.endTime;
    }

    public void setEndTime(long time){
        this.endTime = time;
    }


    public long duration(){
        return this.endTime - this.startTime;
    }

    public String toString(){
        return "Customer #"+this.id+ ", Total response time = "+this.duration();
    }

    // service time is time between the start of service and the end of the service
    // the Response time is the service time + the waiting time in the queue


    public static void main(String[] args){
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer1.setArrivalTime(System.currentTimeMillis());
        customer1.setEndTime(System.currentTimeMillis() +10);

        customer2.setArrivalTime(System.currentTimeMillis());
        customer2.setEndTime(System.currentTimeMillis() + 20);

        System.out.println(customer1);
        System.out.println(customer2);

    }
}
