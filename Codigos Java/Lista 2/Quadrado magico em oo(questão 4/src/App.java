import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Quadrado quadrado = new Quadrado();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adicione o tamanho do quadrado magico(n): ");
        int n = scanner.nextInt();
        if(n < 3 || n > 1000){
            System.out.println("O tamanho do quadrado magico deve ser maior que 3 e menor que 1000.");
            scanner.close();
            return;
            
        }
        quadrado.setCriarQM(n);
        System.out.println("Matriz: ");
        quadrado.getQuadrado();
        quadrado.somas();
        scanner.close();
    }
}
