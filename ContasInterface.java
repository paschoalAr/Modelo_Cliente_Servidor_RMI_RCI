import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;


public interface ContasInterface extends Remote{
    // função de segurança
    public int quantidadeContas() throws RemoteException;

    // funções de uso dos dois clietes (CaixaAutoCliente e AgenciaCliente)
    public double saldo(int id) throws RemoteException;
    public  boolean deposito(int id, double valor, UUID requestId) throws RemoteException;
    public  boolean saque(int id, double valor, UUID requestId) throws RemoteException;

    // funções de uso do cliente AgenciaCliente
    public boolean criaConta(String nome, double saldo, UUID requestId) throws RemoteException;
    public boolean removeConta(int id) throws RemoteException;
    public ArrayList<Conta> listaContas() throws RemoteException;
}
