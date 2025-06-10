import java.util.*;

public class Main {
    public static void main(String[] args) {
        String entrada = "docentes.csv";
        String saida = "listaemails.csv";
        List<Docentes> docentes = FileHandle.readDocentes(entrada);
        HashSet<String> emailsGerados = new HashSet<>();
        List<String> linhasEmails = new ArrayList<>();
        int total = 0;
        int titulares = 0;

        for(Docentes d : docentes){
            String email = d.gerarEmail(emailsGerados);
            
        }
        
    }
}
