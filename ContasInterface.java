import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ContasInterface {
    public Conta[] getContas() throws RemoteException;
    
    
    // public Conta getConta(int id) throws RemoteException;
    // public void setConta(int id, Conta c) throws RemoteException;
    // public void deposito(int id, double valor) throws RemoteException;
    // public void saque(int id, double valor) throws RemoteException;


}
