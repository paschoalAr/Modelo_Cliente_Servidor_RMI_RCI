import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Contas extends UnicastRemoteObject implements ContasInterface {
    private static final long serialVersionUID = 1L;

    private ArrayList<Conta> contas = new ArrayList<>();

    public Contas() throws RemoteException {
        this.contas.add(new Conta(1, "Arthur Paschoal", 1000.0));
        this.contas.add(new Conta(2, "João Carvalho", 2000.0));
        this.contas.add(new Conta(3, "Rafa Roth", 1005.00));
        this.contas.add(new Conta(4, "Japones do Sexo", 1000.0));
    }

    @Override
    public double saldo(int id) throws RemoteException {
        Conta conta = contas.get(id - 1);
        return conta.saldo;
    }

    @Override
    public void deposito(int id, double valor) throws RemoteException {
        Conta conta = contas.get(id - 1);
        conta.saldo += valor;
    }

    @Override
    public void saque(int id, double valor) throws RemoteException {
        Conta conta = contas.get(id - 1);
        conta.saldo -= valor;
    }

    @Override
    public void criaConta(String nome, double saldo) throws RemoteException {
        Conta novaConta = new Conta(contas.size(), nome, saldo);
        contas.add(novaConta);
    }

    @Override
    public void removeConta(int id) throws RemoteException {
        contas.remove(id - 1);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }


}
