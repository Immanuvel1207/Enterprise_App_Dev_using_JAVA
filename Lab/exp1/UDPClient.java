import java.net.*;
import java.io.*;

public class UDPClient {
    private static final String SERVER_IP = "localhost";
    private static final int UDP_PORT = 12346;

    public static void main(String[] args) {
        try { 
            DatagramSocket udpSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            // Client sends a message to the server
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter message for server: ");
            String message = clientInput.readLine();

            byte[] sendBuffer = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, UDP_PORT);
            udpSocket.send(sendPacket);

            // Client receives a response from the server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            udpSocket.receive(receivePacket);
            String serverMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server: " + serverMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
