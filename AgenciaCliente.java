import java.rmi.Naming;
import java.util.ArrayList;;

public class AgenciaCliente {

    public static void main(String[] args){
        while (true) {
            int opcao = menu();
            if (!escolha(opcao)) {
                break;
            }
        }
    }


    public static int menu(){
        System.out.println("Agência - Menu");
        System.out.println("===================================");
        System.out.println("Contas existentes: ");
        try {
            ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
            ArrayList<Conta> listaContas = contas.listaContas();
            System.out.println("ID - Nome - Saldo");
            for (Conta conta : listaContas) {
                System.out.println(conta.id + " - " + conta.nome + " - " + conta.saldo);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("===================================");
        System.out.println("1 - Criar Conta");
        System.out.println("2 - Remover Conta");
        System.out.println("3 - Saldo");
        System.out.println("4 - Saque");
        System.out.println("5 - Depósito");
        System.out.println("6 - Sair");
        System.out.println("Digite a opção desejada: ");

        int opcao = Integer.parseInt(System.console().readLine());

        return opcao;
    }

    public static boolean escolha(int opcao){
        switch (opcao){
            case 1:
                try {
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    System.out.println("Digite o nome do cliente: ");
                    String nome = System.console().readLine();
                    System.out.println("Digite o saldo inicial: ");
                    double saldo = Double.parseDouble(System.console().readLine());
                    contas.criaConta(nome, saldo);
                    System.out.println("Conta criado com sucesso");
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
        }
        return true;
    }
}
