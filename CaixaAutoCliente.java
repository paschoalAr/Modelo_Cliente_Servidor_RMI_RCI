import java.rmi.Naming;

public class CaixaAutoCliente {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java CaixaAutoCliente <id>");
            return;
        }

        int id = Integer.parseInt(args[0]);

        try {
            ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
            int quantidadeContas = contas.quantidadeContas();

            if (id > quantidadeContas) {
                System.out.println("Conta não encontrada");
                return;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        while (true) {
            int opcao = menu();
            if (!escolha(opcao, id)) {
                break;
            }
        }

    }

    public static int menu() {
        System.err.println("===================================");
        System.out.println("1 - Saldo");
        System.out.println("2 - Saque");
        System.out.println("3 - Depósito");
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
                    System.out.println("Saldo: " + contas.saldo(id));
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 2:
                try {
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    System.out.println("Digite o valor do saque: ");
                    double valor = Double.parseDouble(System.console().readLine());
                    contas.saque(id, valor);
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            case 3:
                try {
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    System.out.println("Digite o valor do depósito: ");
                    double valor = Double.parseDouble(System.console().readLine());
                    contas.deposito(id, valor);
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            case 5:
                System.out.println("Sair");
                return false;
            default:
                System.out.println("Opção inválida");
                break;
        }

        return true;
    }
}
