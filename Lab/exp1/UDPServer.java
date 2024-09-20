import java.net.*;  // For networking (DatagramSocket, DatagramPacket, InetAddress)
import java.io.*;   // For input/output (BufferedReader, InputStreamReader)

public class UDP Server {
    private static final int UDP_PORT = 12346;

    public static void main(String[] args) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(UDP_PORT);
            System.out.println("UDP Server started. Waiting for messages...");

            byte[] receiveBuffer = new byte[1024];

            while (true) {
                // Receive message from client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                udpSocket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client: " + message);

                // Server sends response back to client
                BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter message for client: ");
                String response = serverInput.readLine();

                byte[] sendBuffer = response.getBytes();
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                udpSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
