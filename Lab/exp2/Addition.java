import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote Interface
public interface Addition extends Remote {
    // Method to add two numbers
    public int add(int a, int b) throws RemoteException;
}
