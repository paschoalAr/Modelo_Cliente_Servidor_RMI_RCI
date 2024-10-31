import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class admServidor extends UnicastRemoteObject{

    protected admServidor() throws RemoteException {
        super();
       
    }

    public static void main(String[] args) {
        try{
            try{
                System.setProperty("java.rmi.server.hostname", java.net.InetAddress.getLocalHost().getHostAddress());

            } catch (Exception e) {
                System.out.println("Erro ao pegar o IP da máquina");
            }
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
        } catch (RemoteException e) {
            System.out.println("RMI registry already running.");
        }
        try {
            Naming.rebind("Contas", new Contas());
            System.out.println("admServer is ready.");
            System.err.println("IP da máquina: " + java.net.InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e) {
            System.out.println("admServer failed: ");
            e.printStackTrace();
        }
    }

}   