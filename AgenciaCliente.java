import java.rmi.Naming;
import java.util.ArrayList;
import java.util.UUID;;

public class AgenciaCliente {

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
        while (true) {
            int opcao = menu();
            if (!escolha(opcao)) {
                break;
            }
        }
    }

    public static int menu() {
        System.out.println("===================================");
        System.out.println("Agência - Menu");
        System.out.println("Contas existentes: ");
        try {

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

        try {
            int opcao = Integer.parseInt(System.console().readLine());
            return opcao;
        } catch (Exception e) {

        }

        System.out.println("===================================");
        System.out.println("Resultado:");

        return -1;
    }

    public static boolean escolha(int opcao) {
        switch (opcao) {
            case 1:
                try {
                    System.out.println("Digite o nome do cliente: ");
                    String nome = System.console().readLine();
                    if (nome.isEmpty() || nome.length() < 2) {
                        System.out.println("Nome inválido");
                        break;
                    }
                    System.out.println("Digite o saldo inicial: ");
                    double saldo = Double.parseDouble(System.console().readLine());

                    UUID requestId = UUID.randomUUID();

                    boolean resultado = contas.criaConta(nome, saldo, requestId);

                    System.out.println("===================================");
                    System.out.println("Resultado:");

                    if (resultado) {
                        System.out.println("Conta criada com sucesso");
                    } else {
                        System.out.println("A conta já foi criada anteriormente com este requestId");
                    }

                } catch (Exception e) {
                    System.out.println("Conta não criada");
                }

                break;
            case 2:
                try {

                    System.out.println("Digite o ID da conta: ");
                    int id = Integer.parseInt(System.console().readLine());
                    if (id > contas.quantidadeContas() || id < 0) {
                        System.out.println("ID inválido");
                        break;
                    }

                    System.out.println("===================================");
                    System.out.println("Resultado:");

                    if (contas.removeConta(id)) {
                        System.out.println("Conta removida com sucesso");
                    } else {
                        System.out.println("Erro ao remover conta");
                    }

                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 3:
                try {

                    System.out.println("Digite o ID da conta: ");
                    int id = Integer.parseInt(System.console().readLine());

                    System.out.println("===================================");
                    System.out.println("Resultado:");

                    System.out.println("Saldo: " + contas.saldo(id));
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 4:
                try {

                    System.out.println("Digite o ID da conta: ");
                    int id = Integer.parseInt(System.console().readLine());
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
                break;
            case 5:
                try {

                    System.out.println("Digite o ID da conta: ");
                    int id = Integer.parseInt(System.console().readLine());
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
                break;
            case 6:
                System.out.println("Saindo...");
                return false;
            default:
                System.out.println("Opção inválida");
                break;
        }
        return true;
    }
}
