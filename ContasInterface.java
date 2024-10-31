import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ContasInterface extends Remote{
    public double saldo(int id) throws RemoteException;
    public void deposito(int id, double valor) throws RemoteException;
    public void saque(int id, double valor) throws RemoteException;
}
