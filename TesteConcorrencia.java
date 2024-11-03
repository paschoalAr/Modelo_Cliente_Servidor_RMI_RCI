import java.rmi.Naming;
import java.util.UUID;

public class TesteConcorrencia {

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

        try {
            UUID requestId = UUID.randomUUID();
            contas.criaConta("Teste", 1000.0, requestId);

            System.out.println("\nSaldo inicial: " + contas.saldo(5));

            int numThreads = 10;
            double valorOperacao = 100.0;

            System.out.println("===================================\n");
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < numThreads; i++) {
                    try {
                        UUID reqId = UUID.randomUUID();
                        contas.deposito(1, valorOperacao, reqId);
                        System.out.println("t1 Depósito realizado: " + valorOperacao);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < numThreads; i++) {
                    try {
                        UUID reqId = UUID.randomUUID();
                        contas.saque(1, valorOperacao, reqId);
                        System.out.println("t2 Saque realizado: " + valorOperacao);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("\n===================================");
            System.out.println("Saldo final: " + contas.saldo(5));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
