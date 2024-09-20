import java.io.*;
import java.net.*;

public class TCPClient {
    private static final String SERVER_IP = "localhost";
    private static final int TCP_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, TCP_PORT)) {
            System.out.println("Connected to the TCP server.");

            // Create input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Client side: Send message to the server
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter message for server: ");
            String clientMessage = clientInput.readLine();
            output.println(clientMessage);

            // Client side: Read response from the server
            String serverMessage = input.readLine();
            System.out.println("Server: " + serverMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
