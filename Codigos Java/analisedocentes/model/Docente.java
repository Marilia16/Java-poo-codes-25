package model;

public class Docente {
    private String siape;
    private String nome;
    private String classeFuncional;
    private String lotacao;
    private String admissao;

    public Docente(String siape, String nome, String classeFuncional, String lotacao, String admissao) {
        this.siape = siape;
        this.nome = nome;
        this.classeFuncional = classeFuncional.trim();
        this.lotacao = lotacao;
        // Remove a parte da hora
        this.admissao = admissao.trim().split(" ")[0];
    }

    public String getSiape() {
        return siape;
    }

    public String getNome() {
        return nome;
    }

    public String getClasseFuncional() {
        return classeFuncional;
    }

    public String getLotacao() {
        return lotacao;
    }

    public String getAdmissao() {
        return admissao;
    }
}