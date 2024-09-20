import java.rmi.*;
import java.util.Scanner;

public class AdditionClient {

    public static void main(String[] args) {
        try {
            // Look up the remote object (server) in the RMI registry
            Addition stub = (Addition) Naming.lookup("rmi://localhost:2000/AdditionService");

            // Input two numbers from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the first number: ");
            int a = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int b = scanner.nextInt();

            // Call the remote method and print the result
            int result = stub.add(a, b);
            System.out.println("The sum is: " + result);

        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
