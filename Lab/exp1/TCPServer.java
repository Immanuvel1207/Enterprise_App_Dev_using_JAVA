import java.io.*;
import java.net.*;

public class TCPServer {
    private static final int TCP_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
            System.out.println("TCP Server started. Waiting for client...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Server side: Read message from the client
            String clientMessage = input.readLine();
            System.out.println("Client: " + clientMessage);

            // Server side: Send response to the client
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter message for client: ");
            String serverMessage = serverInput.readLine();
            output.println(serverMessage);

            // Close connections
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
