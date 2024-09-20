import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class AdditionServer extends UnicastRemoteObject implements Addition {

    // Constructor
    public AdditionServer() throws RemoteException {
        super();
    }

    // Implementation of the remote method
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the AdditionServer
            AdditionServer server = new AdditionServer();

            // Bind the remote object (server) to the RMI registry
            Registry registry = LocateRegistry.createRegistry(2000);  // Default port 1099
            registry.rebind("AdditionService", server);

            System.out.println("Addition Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}
