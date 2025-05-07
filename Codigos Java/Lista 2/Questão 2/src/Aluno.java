public class Aluno {
    private String nome;
    private int matricula;
    private float nota1, nota2, nota3, media;
    private String situacao;

    public String getNome() {
        return nome;
    }
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int novaMat) {
        this.matricula = novaMat;
    }
    public float getNota1() {
        return nota1;
    }
    public void setNota1(float n1) {
        this.nota1 = n1;
    }
    public float getNota2() {
        return nota2;
    }
    public void setNota2(float n2) {
        this.nota2 = n2;
    }
    public float getNota3() {
        return nota3;
    }
    public void setNota3(float n3) {
        this.nota3 = n3;
    }
    public float getMedia() {
        return media;
    }
    public String getSituacao() {
        if (media >= 7) {
            situacao = "Aprovado(a)";
        } else if (media < 3) {
            situacao = "Reprovado(a)";
        } else {
            situacao = "Em recuperação";
        }
        return situacao;
    }
    public void calcularMedia(){
        media = (nota1 + nota2 + nota3)/3;
    }
    public boolean procurarAluno(int mat) {
        if (this.matricula == mat) {
            return true;
        } else {
            return false;
        }

    }
    public String alterarNota(int codNota, float novaNota) {
        switch (codNota){
            case 1: 
                setNota1(novaNota);
                return "Nota 1 alterada com sucesso! \n" + "Nova nota: " + getNota1();
            
            case 2: 
                setNota2(novaNota);
                return "Nota 2 alterada com sucesso! \n" + "Nova nota: " + getNota2();
            
            case 3:
                setNota3(novaNota);
                return "Nota 3 alterada com sucesso! \n" + "Nova nota: " + getNota3();
            default:
            return "Nota inválida!";
        }
    }
    
    public void imprimirDados(){
        System.out.println("\tNome: " + getNome());
        System.out.println("\tMatrícula: " + getMatricula());
        System.out.println("\tNota 1: " + getNota1());
        System.out.println("\tNota 2: " + getNota2());
        System.out.println("\tNota 3: " + getNota3());
        System.out.println("\tMédia: " + getMedia());
        System.out.println("\tSituação: " + getSituacao());
    }

}
