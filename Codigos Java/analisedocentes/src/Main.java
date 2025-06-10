import model.Docente;
import utils.MyFileHandle;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        String inputPath = "model/data/docentes.csv";
        String outputPath = "model/data/listaemails.csv";

        // Lê os dados brutos do CSV
        ArrayList<String[]> rawData = MyFileHandle.read(inputPath);
        ArrayList<Docente> listDocentes = new ArrayList<>();

        // Cria objetos Docente e adiciona à lista
        for (String[] campos : rawData) {
            String siape = campos[0].replace("\"", "");
            String nome = campos[1].replace("\"", "");
            String classeFuncional = campos[7];
            String lotacao = campos[9];
            String admissao = campos[10];

            Docente d = new Docente(siape, nome, classeFuncional, lotacao, admissao);
            listDocentes.add(d);
        }

        // Ordena a lista por data de admissão (mais recente primeiro)
        listDocentes.sort(new Comparator<Docente>() {
            public int compare(Docente d1, Docente d2) {
                return d2.getAdmissao().compareTo(d1.getAdmissao());
            }
        });

        // Geração dos e-mails ordenados
        ArrayList<String> emailDocentes = new ArrayList<>();
        HashSet<String> emailsCriados = new HashSet<>();

        for (Docente d : listDocentes) {
            String siape = d.getSiape();
            String nome = d.getNome();

            // Geração do e-mail 
            String[] partesNome = nome.split(" ");
            String primeiroNome = partesNome[0].toLowerCase();
            String ultimoNome = partesNome[partesNome.length - 1].toLowerCase();

            String emailBase = primeiroNome + "." + ultimoNome + "@ufrn.br";
            String emailFinal = emailBase;

            if (emailsCriados.contains(emailBase)) {
                emailFinal = primeiroNome + "." + siape.substring(0, 3) + "." + ultimoNome + "@ufrn.br";
            }

            emailsCriados.add(emailFinal);
            emailDocentes.add(siape + ";" + nome + ";" + emailFinal);
        }

        // Escreve no CSV (em ordem decrescente de admissão)
        MyFileHandle.write(outputPath, emailDocentes);

        // Cálculo de docentes titulares
        int titulares = 0;
        for (Docente d : listDocentes) {
            if (d.getClasseFuncional().toUpperCase().contains("TITULAR")) {
                titulares++;
            }
        }

        double percentual = (titulares * 100.0) / listDocentes.size();
        System.out.printf("Docentes Titulares: %d (%.2f%% do total de %d docentes)%n",
                          titulares, percentual, listDocentes.size());
    }
}