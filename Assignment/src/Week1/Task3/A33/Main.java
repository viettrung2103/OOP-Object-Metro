package Week1.Task3.A33;

public class Main {
    public static void main(String[] args) {
        // This will get the single instance of the Singleton class.
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

//        Singleton newInstance = new Singleton();
        // Calling a method on the Singleton instance.
        singleton.showMessage();
        singleton1.showMessage();
    }
}