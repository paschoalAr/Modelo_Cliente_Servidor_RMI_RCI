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
    public double saldo(int id) throws RemoteException {
        for (Conta c : contas) {
            if (c.id == id) {
                return c.saldo;
            }
        }
        return -1;
    }

    @Override
    public void deposito(int id, double valor) throws RemoteException {
        for (Conta c : contas) {
            if (c.id == id) {
                c.saldo += valor;
            }
        }
    }

    @Override
    public void saque(int id, double valor) throws RemoteException {
        for (Conta c : contas) {
            if (c.id == id) {
                c.saldo -= valor;
            }
        }
    }

}
