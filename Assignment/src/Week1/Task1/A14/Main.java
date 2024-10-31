package Week1.Task1.A14;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Customer> queue = new LinkedList<>();

        System.out.println("Welcome to program");
        while (true) {
            System.out.println("Please choose program [1-4]");
            System.out.println("1. Add customer to system");
            System.out.println("2. Remove customer from system");
            System.out.println("3. Display all customer");
            System.out.println("4. Quit");
            System.out.print("Program ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    queue = generateCustomer(queue, scanner);
                    break;
                case "2":
                    Customer removed = removeCustomer(queue);
//                    System.out.println(removed);
                    if (removed == null) {
                        System.out.println("The queue is empty. Please add more customer");
                    } else {
                        System.out.println(removed);
                    }
                    break;
                case "3":
                    displayAllCustomer(queue);
                    break;
                case "4":
                    System.out.println("Thank you for using our QUEUEING program");
                    return;

            }


        }
    }


    public static LinkedList generateCustomer(LinkedList queue, Scanner scanner) {
        while (true) {
            System.out.print("How many customer would you like to add to system ? ");
            int number = Integer.valueOf(scanner.nextLine());
            if (number >= 0) {
                for (int i = 0; i < number; i++) {
                    Customer newCustomer = new Customer();
                    newCustomer.setStartTime(System.currentTimeMillis());
                    queue.addFirst(newCustomer);
                }
                String customerTxt = "customer";
                if (number > 1) {
                    customerTxt = "customers";
                }
                System.out.println("You have add " + number + " " + customerTxt);
                return queue;
            }
            System.out.println("Negative number is not accepted.");
            System.out.println("Please type again");
//            number = Integer.parseInt(scanner.nextLine());
        }
    }

    public static void displayAllCustomer(LinkedList<Customer> queue) {
        if (queue.size() <= 0) {
            System.out.println("The queue is empty. Please add customers");

        } else {
            for (Customer customer : queue) {
                System.out.println(customer);
            }

        }
    }

    public static Customer removeCustomer(LinkedList<Customer> queue) {
        Random rand = new Random();

        if (queue.size() > 0) {
            try {
                Thread.sleep(50 + rand.nextInt(201));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Customer removed = queue.removeLast();
            removed.setEndTime(System.currentTimeMillis());
            return removed;
        } else
            return null;


    }
}
