import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Processo {
    public static final double salario_base = 2000;

    public static boolean validarSalario(double salario_pretendido) {
        if (salario_base > salario_pretendido) {
            System.out.println("Ligar para o candidato.");
            return true;
        } else if (salario_base == salario_pretendido) {
            System.out.println("Ligar para o candidato com uma proposta.");
            return true;
        }

        System.out.println("Aguardando resultado dos outros candidatos.");
        return false;
    }

    public static void main(String[] args) throws Exception {
        String[] candidatos = {"Marcos", "Lucas", "Estevão", "Leonardo", "Gabriel"};
        List<String> selecionados = new ArrayList<>();

        for (String candidato : candidatos) {
            double valor = ThreadLocalRandom.current().nextDouble(1800, 2200);

            if (validarSalario(valor)) {
                selecionados.add(candidato);
            }
        }

        System.out.println("Candidatos selecionados:\n" + selecionados);

        for (String candidato : selecionados) {
            int tentativas = 0;
            boolean atendeu = false;

            while (tentativas != 3) {
                Random atender = new Random();
                atendeu = atender.nextInt(3) == 1;
                tentativas++;

                if (atendeu) {
                    break;
                }
            }

            if (atendeu) {
                System.out.println("Conseguimos contato com " +
                            candidato + " após " +
                            tentativas + " tentativa(s).");
            } else {
                System.out.println("Não conseguimos contato com o " + candidato);
            }
        }
    }
}