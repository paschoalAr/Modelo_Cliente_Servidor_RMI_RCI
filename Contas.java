import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class Conta {
    public int id;
    public String nome;
    public Double saldo;

    public Conta(int i, String nome, Double saldo) {
        this.id = i;
        this.nome = nome;
        this.saldo = saldo;
    }


}

public class Contas extends UnicastRemoteObject implements ContasInterface {

    private Conta[] contas;

    public Contas() throws RemoteException{
        this.contas = new Conta[]{
            new Conta(1, "Arthur Paschoal", 1000.0),
            new Conta(2, "João Carvalho", 2000.0),
            new Conta(3, "Rafa Roth", 1005.00),
            new Conta(4, "Japones do Sexo", 1000.0),
        };
    }

    @Override
    public Conta[] getContas() throws RemoteException {
        for (Conta c : contas) {
            System.out.println(c.id + " " + c.nome + " " + c.saldo);
        }
        //Mudar Depois
        Conta[] x = new Conta[contas.length];
        return x;
    }

}
