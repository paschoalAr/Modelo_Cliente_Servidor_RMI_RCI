import java.rmi.Naming;
import java.util.ArrayList;;

public class AgenciaCliente {

    public static void main(String[] args) {
        while (true) {
            int opcao = menu();
            if (!escolha(opcao)) {
                break;
            }
        }
    }

    public static int menu() {
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

        try {
            int opcao = Integer.parseInt(System.console().readLine());
            return opcao;
        } catch (Exception e) {
            
        }

        return -1;
    }

    public static boolean escolha(int opcao) {
        switch (opcao) {
            case 1:
                try {
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    System.out.println("Digite o nome do cliente: ");
                    String nome = System.console().readLine();
                    if (nome.isEmpty() || nome.length() < 2) {
                        System.out.println("Nome inválido");
                        break;
                    }
                    System.out.println("Digite o saldo inicial: ");
                    double saldo = Double.parseDouble(System.console().readLine());
                    contas.criaConta(nome, saldo);
                    System.out.println("Conta criado com sucesso");
                } catch (Exception e) {
                    System.out.println("Conta não criada");
                }
                break;
            case 2:
                try {
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    System.out.println("Digite o ID da conta: ");
                    int id = Integer.parseInt(System.console().readLine());
                    if (id > contas.quantidadeContas() || id < 0) {
                        System.out.println("ID inválido");
                        break;
                    }
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
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    System.out.println("Digite o ID da conta: ");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.println("Saldo: " + contas.saldo(id));
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 4:
                try {
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    System.out.println("Digite o ID da conta: ");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.println("Digite o valor do saque: ");
                    double valor = Double.parseDouble(System.console().readLine());
                    boolean retorno = contas.saque(id, valor);
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
                    ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");
                    System.out.println("Digite o ID da conta: ");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.println("Digite o valor do depósito: ");
                    double valor = Double.parseDouble(System.console().readLine());
                    boolean retorno = contas.deposito(id, valor);
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
                System.out.println("Sair");
                return false;
            default:
                System.out.println("Opção inválida");
                break;
        }
        return true;
    }
}
