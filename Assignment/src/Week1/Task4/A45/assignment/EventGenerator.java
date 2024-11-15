package Week1.Task4.A45.assignment;

public class EventGenerator {
    public EventGenerator(int numberOfEvents, EventList queue, ArrivalProcess arrivalProcess) {

        for (int i = 0; i < numberOfEvents; i++) {
            queue = arrivalProcess.createEvent(queue);
        }
    }

}
