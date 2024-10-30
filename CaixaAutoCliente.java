import java.rmi.Naming;

public class CaixaAutoCliente {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java CaixaAutoCliente <id>");
            return;
        }

        int id = Integer.parseInt(args[0]);
        
        while (true) {
            int opcao = menu();
            if (!escolha(opcao, id)){
                break;
            }
        }

      

        // System.out.println("Caixa Automático");
        // while (true) {
        // System.out.println("Qual o id da sua conta");

        // // System.out.println("1 - Saldo");
        // // System.out.println("2 - Saque");
        // // System.out.println("3 - Depósito");
        // // System.out.println("4 - Transferência");
        // // System.out.println("5 - Sair");
        // // System.out.println("Digite a opção desejada: ");

        // int opcao = Integer.parseInt(System.console().readLine());

    }

    public static int menu() {
        System.err.println("===================================");
        System.out.println("1 - Saldo");
        System.out.println("2 - Saque");
        System.out.println("3 - Depósito");
        System.out.println("4 - Transferência");
        System.out.println("5 - Sair");
        System.out.println("Digite a opção desejada: ");
        
        int opcao = Integer.parseInt(System.console().readLine());

        return opcao;
    }

    public static boolean escolha(int opcao, int id) {
        switch (opcao) {
            case 1:
                try {
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    Conta[] listaContas = contas.getContas();
                    for (Conta c : listaContas) {
                        if (c.id == id) {
                            System.out.println("Conta encontrada: " + c.nome + " - " + c.saldo);
                            return true;
                        }
                    }
                    System.out.println("Conta não encontrada");
                    break;
                } catch (Exception e) {
                    System.out.println("CaixaAutoCliente failed: ");
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Saque");
                break;
            case 3:
                System.out.println("Depósito");
                break;
            case 4:
                System.out.println("Transferência");
                break;
            case 5:
                System.out.println("Sair");
                return false; // Sai do método main, encerrando o programa
            default:
                System.out.println("Opção inválida");
                break;
        }

        return true;
    }
}
