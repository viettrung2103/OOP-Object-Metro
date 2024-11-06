package Week1.Task3.A37.assignment;

public class MainTest {

    public static void  main(String[] args){

    // create 10 arrival customer X,Y
        Clock clock = Clock.getInstance();
        ArrivalProcess arrivalProcess = new ArrivalProcess();
        EventList queue = new EventList();
        for (int i = 0; i <= 10; i++) {
//            System.out.println(arrivalProcess.getEventType());
//            double ranNum = arrivalProcess.getArrivalTime();
//            System.out.println("Random number: " + ranNum);
            queue = arrivalProcess.createEvent(queue);
        }
    }
}
