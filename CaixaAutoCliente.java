import java.rmi.Naming;
import java.util.UUID;

public class CaixaAutoCliente {

    public static String serverIP = "25.21.54.189";
    public static ContasInterface contas;

    static {
        try {
            contas = (ContasInterface) Naming.lookup("rmi://" + serverIP + "/Contas");
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o servidor: " + e.getMessage());
            contas = null;
        }
    }

        public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java CaixaAutoCliente <id>");
            return;
        }

        int id = Integer.parseInt(args[0]);

        try {
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
        System.out.println("===================================");
        System.out.println("Caixa Automático - Menu");
        System.out.println("1 - Saldo");
        System.out.println("2 - Saque");
        System.out.println("3 - Depósito");
        System.out.println("4 - Sair");
        System.out.println("Digite a opção desejada: ");

        int opcao = Integer.parseInt(System.console().readLine());

        return opcao;
    }

    public static boolean escolha(int opcao, int id) {
        switch (opcao) {
            case 1:
                try {

                    System.out.println("===================================");
                    System.out.println("Resultado:");

                    System.out.println("Saldo: " + contas.saldo(id));

                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 2:
                try {

                    System.out.println("Digite o valor do saque: ");
                    double valor = Double.parseDouble(System.console().readLine());

                    UUID requestId = UUID.randomUUID();
                    boolean retorno = contas.saque(id, valor, requestId);

                    System.out.println("===================================");
                    System.out.println("Resultado:");

                    if (retorno) {
                        System.out.println("Saque realizado");
                    } else {
                        System.out.println("Saque não realizado");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            case 3:
                try {

                    System.out.println("Digite o valor do depósito: ");
                    double valor = Double.parseDouble(System.console().readLine());

                    UUID requestId = UUID.randomUUID();

                    boolean retorno = contas.deposito(id, valor, requestId);

                    System.out.println("===================================");
                    System.out.println("Resultado:");

                    if (retorno) {
                        System.out.println("Depósito realizado");
                    } else {
                        System.out.println("Depósito não realizado");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            case 4:
                System.out.println("Saindo...");
                return false;
            default:
                System.out.println("===================================");
                System.out.println("Resultado:");

                System.out.println("Opção inválida");
                break;
        }

        return true;
    }
}
