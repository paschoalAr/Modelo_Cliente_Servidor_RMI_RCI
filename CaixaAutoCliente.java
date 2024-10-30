import java.rmi.Naming;

public class CaixaAutoCliente {
    
    public static void main(String[] args) {
        try {
            ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
            contas.getContas();
        } catch (Exception e) {
            System.out.println("CaixaAutoCliente failed: ");
            e.printStackTrace();
    }
}}
