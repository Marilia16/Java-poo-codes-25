import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FileHandle {
    private ArrayList<Docentes> list = new ArrayList();
    
    public FileHandle(){

    }

    public static List<Docentes> readDocentes(String path){
        List<Docentes> lista = new ArrayList<>(); //Implementa ArrayList na interface List para melhor uso
        try( Scanner sc = new Scanner(new File(path), "StandardCharsets.UTF_8")){
            sc.nextLine();//Pula o cabeçalho de Docentes.csv
            while(sc.hasNextLine()){ //Enquanto tiver linhas
                String linha = sc.nextLine(); //escreve a linha em uma string
                String[] campos = linha.split(";"); //separa os campos

                if(campos.length >=11){ //a quantidade de tipos de itens em docentes é de 11
                    String siape = campos[0].replace("\"","").trim(); //tira as aspas e os espaços brancos de siape;
                    String nome = campos[1].replace("\"","").trim();
                    String classeFuncional = campos[7].replace("\"","").trim();
                    String lotacao = campos[9].replace("\"","").trim();
                    String admissao = campos[10].replace("\"","").trim();
                    Docentes d = new Docentes(siape, nome, classeFuncional, lotacao, admissao);
                    lista.add(d); //adiciona os Docentes na lista
                    
                }

            }
        }catch(Exception e){
            System.out.println("Erro ao ler docentes: " + e.getMessage());
        }
        return lista; //retorna a lista

    }

    public static void writeEmails(String exitPath, List<String> linhas){
        try(PrintWriter pw = new PrintWriter(new FileWriter(exitPath))){
            pw.println("siape;nome;email");
            for(String linha : linhas){
                pw.println(linha);
            }
        }catch(Exception e){
            System.out.println("Erro ao escrever e-mail: " + e.getMessage());
        }
    }
}
