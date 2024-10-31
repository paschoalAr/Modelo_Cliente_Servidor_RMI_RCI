import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ContasInterface extends Remote{
    // funções de uso dos dois clietes (CaixaAutoCliente e AgenciaCliente)
    public double saldo(int id) throws RemoteException;
    public void deposito(int id, double valor) throws RemoteException;
    public void saque(int id, double valor) throws RemoteException;

    // funções de uso do cliente AgenciaCliente
    public void criaConta(int id, String nome, double saldo) throws RemoteException;
    public void removeConta(int id) throws RemoteException;
}
