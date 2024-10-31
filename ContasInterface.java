import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ContasInterface extends Remote{
    // função de segurança
    public int quantidadeContas() throws RemoteException;

    // funções de uso dos dois clietes (CaixaAutoCliente e AgenciaCliente)
    public double saldo(int id) throws RemoteException;
    public boolean deposito(int id, double valor) throws RemoteException;
    public boolean saque(int id, double valor) throws RemoteException;

    // funções de uso do cliente AgenciaCliente
    public void criaConta(String nome, double saldo) throws RemoteException;
    public void removeConta(int id) throws RemoteException;
}
