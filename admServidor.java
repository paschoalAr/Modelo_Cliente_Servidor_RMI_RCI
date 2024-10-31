import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;


public class admServidor extends UnicastRemoteObject{

    protected admServidor() throws RemoteException {
        super();
       
    }

    public static void main(String[] args) {
        try {
            String ip = "179.68.6.31"; // Replace with the desired IP address
            java.rmi.registry.LocateRegistry.getRegistry(ip, 1099);
            System.out.println("Connected to RMI registry at " + ip);
        } catch (RemoteException e) {
            System.out.println("Failed to connect to RMI registry at the specified IP.");
            e.printStackTrace();
        }
        try {
            // String serverIP = "179.68.6.31";
            // Naming.rebind("rmi://"+serverIP+"/Contas", new Contas());
            Naming.rebind("Contas", new Contas());
            // Naming.rebind("Contas", new Contas());
            System.out.println("admServer is ready.");
        } catch (Exception e) {
            System.out.println("admServer failed: ");
            e.printStackTrace();
        }
    }

}