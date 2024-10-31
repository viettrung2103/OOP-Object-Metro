package Week2.Wednesday;

public class Operator {
    // keyword: final >> const in javascript
    private static final int OPERATORPROCESSINGTIME = 5; // time spent to serve each customer

    private String name;
    private int callId;
    private int timer;
    private boolean isRunning;


    public Operator(String operatorName) {
        this.name = operatorName;
        this.isRunning = false;

    }

    public void start(int callNumber) {
        System.out.print(this.name + " service starts");
        if (callNumber > 0) {
            this.callId = callNumber;

        }
        // +1 because the operator run right when the operator run
        this.timer = OPERATORPROCESSINGTIME+1;
        this.isRunning = true;


    }

    public boolean isBusy() {
        return this.isRunning;
    }

    public void run() {
        // every minute, the timer elapse/decrease 1 minute
        if (this.isRunning) {
            timer--;
            if (timer == 0) {
                this.isRunning = false;
                System.out.print("Call #" + this.callId + " serviced (" + this.name + ")");
            }
        }
        // when timer reach 0;

    }
}
