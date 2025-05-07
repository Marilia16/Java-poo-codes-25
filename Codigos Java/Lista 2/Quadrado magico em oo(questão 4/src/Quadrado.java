import java.util.Scanner;
public class Quadrado {
    private int[][] quadrado;
    private int n;
    private int somaDP=0;
    private int somaDS=0;
    private int somaL=0;
    private int somaC=0;
    private int somaEsperada=0;
    Scanner scanner = new Scanner(System.in);
    public Quadrado() {
        
    }

    public void setCriarQM(int n1) {
        this.n = n1;
        int[][] quadrado = new int[n][n];
        
        System.out.println("Preenchendo o quadrado magico...");
        for(int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.println("Adicione o valor da linha " + i + " e coluna " + j + ": ");
                quadrado[i][j] = scanner.nextInt(); ;
            }
        }
        this.quadrado = quadrado;
    }

    public void getQuadrado() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(quadrado[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void somas() {
        for (int i = 0; i < n; i++) {
            somaEsperada += quadrado[0][i];
        }
        for(int i = 0; i < n; i++){
            somaL = 0;
            for(int j = 0; j < n; j++){
                somaL += quadrado[i][j];
            }
            if(somaL != somaEsperada){
                System.out.println("-1");
                return;
            }
        }

        for(int i = 0; i < n; i++){
            somaC = 0;
            for(int j = 0; j < n; j++){
                somaC += quadrado[j][i];
            }
            if(somaC!= somaEsperada){
                System.out.println("-1");
                return;
            }
        }

        for(int i = 0; i < n; i++){
            somaDP += quadrado[i][i];
        }
        if(somaDP != somaEsperada){
            System.out.println("-1");
            return;
        }
        for(int i = 0; i < n; i++){
            somaDS += quadrado[i][n - 1 - i];
        }
        if(somaDS != somaEsperada){
            System.out.println("-1");
            return;
        }
        System.out.println("Soma: " + somaEsperada);
    }



}
