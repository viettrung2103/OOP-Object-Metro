package Week1.Task3.A35;

public class Clock {
    // Private static member to hold the unique instance
    private static Clock instance;
    private long startTime;
    private long curTime;

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

    public void setCurTime(int time) {
        this.curTime = time;
    }

    public void elapse() {
        this.curTime++;
    }

    public long getCurTime() {
        return this.curTime;
    }

    @Override
    public String toString() {
        return "Current time: t = " + this.curTime;
    }
}
