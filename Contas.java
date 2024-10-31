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
        this.contas.add(new Conta(4, "Fernando Suzuki", 1000.0));
    }

    @Override
    public double saldo(int id) throws RemoteException {
        Conta conta = contas.get(id - 1);
        return conta.saldo;
    }

    @Override
    public boolean deposito(int id, double valor) throws RemoteException {
        Conta conta = contas.get(id - 1);
        if (valor < 0) {
            return false;
        }
        conta.saldo += valor;
        return true;
    }

    @Override
    public boolean saque(int id, double valor) throws RemoteException {
        Conta conta = contas.get(id - 1);
        if (valor < 0 || conta.saldo < valor) {
            return false;
        }
        conta.saldo -= valor;
        return true;
    }

    @Override
    public boolean criaConta(String nome, double saldo) throws RemoteException {
        Conta novaConta = new Conta(contas.size() + 1, nome, saldo);
        contas.add(novaConta);
        return true;
    }

    @Override
    public boolean removeConta(int id) throws RemoteException {
        for (Conta conta : contas) {
            if (conta.id == id) {
                contas.remove(conta);
                return true;
            }
        }
        return false;

        
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public ArrayList<Conta> listaContas() throws RemoteException {
        return contas;
    }

}