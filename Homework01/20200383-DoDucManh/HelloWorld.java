import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter their name
        System.out.print("Enter your name: ");

        // Read the user's input as a String
        String name = scanner.nextLine();

        // Display a greeting
        System.out.println("Hello, " + name + "!");

        // Close the scanner to release resources
        scanner.close();
    }
}
