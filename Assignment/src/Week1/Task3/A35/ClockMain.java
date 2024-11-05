package Week1.Task3.A35;

public class ClockMain {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();

        System.out.println(clock);
        clock.elapse();

        System.out.println(clock);
        clock.setCurTime(10);
        System.out.println(clock);

    }
}
