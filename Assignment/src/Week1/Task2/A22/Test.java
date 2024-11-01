package Week1.Task2.A22;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queqe = new PriorityQueue<>();

        queqe.add(1);
        queqe.add(3);
        queqe.add(4);
        queqe.add(-1);

        while (queqe.peek() != null) {
            System.out.println(queqe.poll());
        }

    }
}
