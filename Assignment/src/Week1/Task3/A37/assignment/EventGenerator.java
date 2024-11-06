package Week1.Task3.A37.assignment;

public class EventGenerator {
    public EventGenerator(int numberOfEvents, EventList queue, ArrivalProcess arrivalProcess) {

        for (int i = 0; i < numberOfEvents; i++) {
            queue = arrivalProcess.createEvent(queue);
        }
    }

}
