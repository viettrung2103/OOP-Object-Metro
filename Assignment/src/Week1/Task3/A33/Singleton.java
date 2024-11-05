package Week1.Task3.A33;

public class Singleton {
    // Step 1: Create a private static instance of the class.
    private static Singleton instance;

    // Step 2: Make the constructor private to prevent instantiation from other classes.
    private Singleton() {
        // Private constructor
    }

    // Step 3: Provide a public static method that returns the instance of the class.
    public static Singleton getInstance() {
        if (instance == null) {
            // Create the instance only if it doesn’t exist
            System.out.println("No instance exist");
            System.out.println("Creating new instance");
            instance = new Singleton();
        } else{
            System.out.println("Instance is already existed");
        }
        return instance;
    }

    // Example method to show Singleton functionality
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}