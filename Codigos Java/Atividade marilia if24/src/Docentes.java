import java.util.HashSet;
public class Docentes {
    String siape;
    String nome;
    String classeFuncional;
    String locacao;
    String admissao;
    public Docentes(String siape, String nome, String classeFuncional, String locacao, String admissao){
        this.siape = siape;
        this.nome = nome;
        this.classeFuncional = classeFuncional;
        this.locacao = locacao;
        this.admissao = admissao;
    }
    public String gerarEmail(HashSet<String> emailsGerados){
        String[] partes = nome.trim().toLowerCase().split(" ");
        String primeiro = partes[0];
        String ultimo = partes[partes.length - 1];
        String base = primeiro = "." + ultimo + "@ufrn.br";
        if(emailsGerados.contains(base)){
            String alternativo = primeiro + "." + siape + "." + ultimo + "@ufrn.br";
            emailsGerados.add(alternativo);
            return alternativo;
        }else{
            emailsGerados.add(base);
            return base;
        }
    }
}
