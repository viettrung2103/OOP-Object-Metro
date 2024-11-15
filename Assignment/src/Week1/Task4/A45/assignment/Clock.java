package Week1.Task4.A45.assignment;

public class Clock {
    // Private static member to hold the unique instance
    private static Clock instance;
    private double startTime;
    private double curTime;

    // Private constructor to prevent instantiation from outside
    private Clock() {
        this.startTime = 0;
        this.curTime = 0;
        // Initialization code
    }

    // Public static method to access the unique instance
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }


    // Other methods and properties of the Singleton class
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public void setCurTime(double time) {
        if (this.curTime != time) {
            this.curTime = time;
            System.out.println("_______");
            System.out.println("Clock is moved to t = " + this.curTime);

        }
    }

    public void elapse() {
        this.curTime++;
    }

    public double getCurTime() {
        return this.curTime;
    }

    @Override
    public String toString() {
        return "Current time: t = " + this.curTime;
    }
}
