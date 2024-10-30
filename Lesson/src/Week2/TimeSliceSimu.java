package Week2;

import java.util.ArrayList;

public class TimeSliceSimu {
//    private static final int OPERATORPROCESSINGTIME = 5;
    private static final int ARRIVALRATE = 2;


    public static void main(String[] args) {

        int arrival = 3;

        ArrayList<Operator> operators = new ArrayList<>();
        Operator opt1 = new Operator("Operator 1");
        Operator opt2 = new Operator("Operator 2");

        operators.add(opt1);
        operators.add(opt2);

        int call = 1;

        //main simulation loop

        for (int t = 0; t <= 24; t++) {
            System.out.print("Time " + t + "min: ");
            if (arrival == 0) {
                System.out.print("New call #" + call + " received. ");
                arrival = ARRIVALRATE;
                if (!opt1.isBusy()) {
                    opt1.start(call);

                } else if (!opt2.isBusy()) {
                    opt2.start(call);
                } else {
                    System.out.println("*** System is too busy ***");
                }
                call++;
            }
            opt1.run();
            opt2.run();

            //update time delay counter
            arrival--;
            System.out.println("");
        }
    }
}
