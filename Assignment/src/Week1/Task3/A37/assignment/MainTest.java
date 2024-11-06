package Week1.Task3.A37.assignment;

public class MainTest {

    public static void main(String[] args) {

        // create 10 arrival customer X,Y
        Clock clock = Clock.getInstance();
        ArrivalProcess arrivalProcess = new ArrivalProcess();
        ServicePoint sp = new ServicePoint();
        EventList eventList = new EventList();

        new EventGenerator(10, eventList, arrivalProcess);
        // while loop, until EventList is empty
        while (!eventList.isEmpty()) {
            // when the event List is not empty, get the first event( which has the earliest time
            Event currentEvent = eventList.getEarliestEvent();
            clock.setCurTime(currentEvent.getTime());
            System.out.println(currentEvent);
            Customer newCustomer = currentEvent.getCustomer();

            if (newCustomer.isSameName(sp.getServingCustomer())) {
                Event newEvent = sp.serveExitCustomer(newCustomer, clock);
                if (newEvent != null) {
                    eventList.addEvent(newEvent);
                }

            } else {

                sp.addToQueue(newCustomer, clock);
                // handle the event inside the sp ( from queue to sp)
                Event newEvent = sp.serveArrivalCustomer(clock);
                if (newEvent != null) {
                    eventList.addEvent(newEvent);
                }
            }
            // add customer to service point

        }
        // get event from the event list in FIFO
        // get event, move time to the event
        // depend on event, create new customer or finish serve the said event
        // create customer, add to servicepoint

    }
}
