import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String resposta;

        Jogo run = new Jogo();
        run.inserirJogadores();

        do {
            run.inserirApostas();      
            run.lancarDados();
            run.mostrarResultado();
            run.mostrarVencedor();
            System.out.print("\nDeseja jogar outra rodada? (s/n): ");
            resposta = entrada.next().toLowerCase();
            System.out.println();
        } while (resposta.equals("s") || resposta.equals("sim"));

        entrada.close();
        System.out.println("Fim do jogo.");
    }
}
