import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;


public class admServidor extends UnicastRemoteObject{

    protected admServidor() throws RemoteException {
        super();
       
    }

    public static void main(String[] args) {
        try{
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
        } catch (RemoteException e) {
            System.out.println("RMI registry already running.");
        }
        try {
            Naming.rebind("Contas", new Contas());
            System.out.println("admServer is ready.");
        } catch (Exception e) {
            System.out.println("admServer failed: ");
            e.printStackTrace();
        }
    }

}