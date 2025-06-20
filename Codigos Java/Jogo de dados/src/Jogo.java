import java.io.*;
import java.util.*;

public class Jogo {
    private int qtdJogadores;        
    private int resultado;           
    private Dado dado1, dado2;       
    private Jogador[] jogadores;     
    private Scanner entrada = new Scanner(System.in);  

    
    public void inserirJogadores() {
        do {
            System.out.print("Informe a quantidade de jogadores (1 a 11): ");
            qtdJogadores = entrada.nextInt();
        } while (qtdJogadores < 1 || qtdJogadores > 11);

        jogadores = new Jogador[qtdJogadores];

        for (int i = 0; i < qtdJogadores; i++) {
            jogadores[i] = new Jogador();
            System.out.print("Informe o nome do jogador " + (i + 1) + ": ");
            jogadores[i].setNome(entrada.next());
        }
    }

   
    public void inserirApostas() {
        for (int i = 0; i < qtdJogadores; i++) {
            int aposta;
            do {
                System.out.print("Jogador " + jogadores[i].getNome() + ", escolha um valor para apostar (2 a 12): ");
                aposta = entrada.nextInt();
            } while (aposta < 2 || aposta > 12);
            jogadores[i].setValorAposta(aposta);
        }
    }

    
    public void lancarDados() {
        dado1 = new Dado();
        dado2 = new Dado();

        dado1.setValorFace();
        dado2.setValorFace();
    }

    
    public void mostrarResultado() {
        int face1 = dado1.getValorFace();
        int face2 = dado2.getValorFace();
        resultado = face1 + face2;

        System.out.println("\nDado 1: " + face1);
        System.out.println("Dado 2: " + face2);
        System.out.println("Resultado da soma: " + resultado);
    }

    
    public void mostrarVencedor() {
        boolean houveVencedor = false;

        for (int i = 0; i < qtdJogadores; i++) {
            if (jogadores[i].getValorAposta() == resultado) {
                String nome = jogadores[i].getNome();
                System.out.println("Jogador " + nome + " venceu!");
                gravarVencedor(nome, resultado); 
                houveVencedor = true;
            }
        }

        if (!houveVencedor) {
            System.out.println("A máquina venceu.");
        }

        mostrarTopFive();  
    }

   
    private void gravarVencedor(String nome, int resultado) {
        File arquivo = new File("vencedores.csv");
        int novaQtd = 1;

        
        if (arquivo.exists()) {
            try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = leitor.readLine()) != null) {
                    String[] partes = linha.split(",");
                    if (partes.length == 3) {
                        String jogador = partes[0];
                        int vitorias = Integer.parseInt(partes[2]);

                        if (jogador.equals(nome)) {
                            novaQtd = vitorias + 1;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, true))) {
            escritor.write(nome + "," + resultado + "," + novaQtd);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

   
    private void mostrarTopFive() {
        File arquivo = new File("vencedores.csv");
        List<String> linhas = new ArrayList<>();

        if (!arquivo.exists()) {
            System.out.println("\nTop 5 Últimos Vencedores:");
            System.out.println("Nenhum vencedor ainda registrado.");
            return;
        }

        
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        
        int inicio = Math.max(0, linhas.size() - 5);

        System.out.println("\nTop 5 Últimos Vencedores:");
        for (int i = inicio; i < linhas.size(); i++) {
            System.out.println(linhas.get(i));
        }
    }
}