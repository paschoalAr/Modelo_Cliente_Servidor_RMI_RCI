import java.io.Serializable;

public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    public int id;
    public String nome;
    public Double saldo;

    public Conta(int i, String nome, Double saldo) {
        this.id = i;
        this.nome = nome;
        this.saldo = saldo;
    }

}
