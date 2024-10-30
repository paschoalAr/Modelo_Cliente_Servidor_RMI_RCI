import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Contas extends UnicastRemoteObject implements ContasInterface {
    private static final long serialVersionUID = 1L;
    private Conta[] contas;

    public Contas() throws RemoteException {
        this.contas = new Conta[]{
            new Conta(1, "Arthur Paschoal", 1000.0),
            new Conta(2, "João Carvalho", 2000.0),
            new Conta(3, "Rafa Roth", 1005.00),
            new Conta(4, "Japones do Sexo", 1000.0),
        };
    }

    @Override
    public Conta[] getContas() throws RemoteException {
        return contas;
    }
}
