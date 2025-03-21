import java.rmi.Naming;
import java.util.UUID;

public class InjecaoFalhas {

    public static void main(String[] args) {
        try {
            ContasInterface contas = (ContasInterface) Naming.lookup("rmi://localhost/Contas");

            int contaId = 1;
            double valorDeposito = 100.0;
            double valorSaque = 50.0;

            System.out.println("\n===================================");
            System.out.println("Informações da conta");
            System.out.println("ID: " + contaId);
            System.out.println("Valor do depósito: " + valorDeposito);
            System.out.println("Valor do saque: " + valorSaque);

            System.out.println("\n===================================");
            System.out.println("Saldo inicial da conta " + contaId + ": " + contas.saldo(contaId));

            System.out.println("\n===================================");
            UUID requestIdDeposito = UUID.randomUUID();
            System.out.println("Executando depósito pela primeira vez:");
            boolean resultadoDeposito1 = contas.deposito(contaId, valorDeposito, requestIdDeposito);
            System.out.println("Depósito realizado (primeira tentativa): " + resultadoDeposito1);

            System.out.println("\n===================================");
            System.out.println("Saldo após primeiro depóisto da conta " + contaId + ": " + contas.saldo(contaId));

            System.out.println("\n===================================");
            System.out.println("Tentando executar o mesmo depósito novamente:");
            boolean resultadoDeposito2 = contas.deposito(contaId, valorDeposito, requestIdDeposito);
            System.out.println("Depósito realizado (segunda tentativa): " + resultadoDeposito2);

            System.out.println("\n===================================");
            System.out.println("Saldo após segundo depóisto da conta " + contaId + ": " + contas.saldo(contaId));

            System.out.println("\n===================================");
            UUID requestIdSaque = UUID.randomUUID();
            System.out.println("Executando saque pela primeira vez:");
            boolean resultadoSaque1 = contas.saque(contaId, valorSaque, requestIdSaque);
            System.out.println("Saque realizado (primeira tentativa): " + resultadoSaque1);

            System.out.println("\n===================================");
            System.out.println("Saldo após primeiro saques da conta " + contaId + ": " + contas.saldo(contaId));

            System.out.println("\n===================================");
            System.out.println("Tentando executar o mesmo saque novamente:");
            boolean resultadoSaque2 = contas.saque(contaId, valorSaque, requestIdSaque);
            System.out.println("Saque realizado (segunda tentativa): " + resultadoSaque2);

            System.out.println("\n===================================");
            System.out.println("Saldo após primeiro saques da conta " + contaId + ": " + contas.saldo(contaId));

            System.out.println("\n===================================");
            System.out.println("Criação de conta");
            UUID requestIdCriacao = UUID.randomUUID();
            boolean resultadoCriacao = contas.criaConta("Teste" ,1000.0, requestIdCriacao);
            System.out.println("Criação de conta realizada: " + resultadoCriacao);

            System.out.println("\n===================================");
            System.out.println("Criando uma nova conta com o mesmo ID");
            boolean resultadoCriacao2 = contas.criaConta("Teste" ,1000.0, requestIdCriacao);
            System.out.println("Criação de conta realizada: " + resultadoCriacao2);

        } catch (Exception e) {
            System.out.println("Erro no teste: " + e.getMessage());
        }
    }

}
