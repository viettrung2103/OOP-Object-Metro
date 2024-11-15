package Week1.Task4.A45.assignment;

public class MainTest {

    public static void main(String[] args) {

        // initiate event()
        // create 10 arrival customer X,Y
        Clock clock = Clock.getInstance();
        ArrivalProcess arrivalProcess = new ArrivalProcess();
        ServeProcess serveProcess = new ServeProcess();
        ServicePoint sp = new ServicePoint(ServicePointType.QUEUE);
        ServicePoint spQueue = new ServicePoint(ServicePointType.QUEUE);
        ServicePoint spX = new ServicePoint(ServicePointType.SPX);
        ServicePoint spY = new ServicePoint(ServicePointType.SPY);

        EventList eventList = new EventList();

        new EventGenerator(5, eventList, arrivalProcess);
        serveProcess.createTimeGenerator(sp);
        System.out.println();

        // while loop, until EventList is empty
        while (!eventList.isEmpty()) {
            // when the event List is not empty, get the first event( which has the earliest time
            // phase A
            System.out.println("Phase A: ");
            Event currentEvent = eventList.getEarliestEvent();
            clock.setCurTime(currentEvent.getTime());
            System.out.println(currentEvent);
            System.out.println();
            Customer newCustomer = currentEvent.getCustomer();

            // if there are several B-type event and they are served in FIFO manner
            // if the customer from the event is the same as the customer inside the service point
            // it means he has been serving inside the service point and
            // it is time for the service to complete and
            // and the customer move to next SP block or complete the system
            if (newCustomer.isSameName(sp.getServingCustomer())) {
                System.out.println("Phase B: ");
                Event newEvent = sp.serveExitCustomer(newCustomer, clock, serveProcess);
                if (newEvent != null) {
                    eventList.addEvent(newEvent);
                }
                System.out.println();


            }

            // if the sp is busy,
            else {
                System.out.println("Phase C:");
                sp.addToQueue(newCustomer, clock);
                // handle the event inside the sp ( from queue to sp)
                Event newEvent = sp.serveArrivalCustomer(clock, serveProcess);
                if (newEvent != null) {
                    eventList.addEvent(newEvent);
                }
                System.out.println();
            }
            // add customer to service point

        }
        // get event from the event list in FIFO
        // get event, move time to the event
        // depend on event, create new customer or finish serve the said event
        // create customer, add to servicepoint

    }
}
