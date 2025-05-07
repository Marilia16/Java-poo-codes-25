/*
    matrizes testadas:
    1.
    input:
    8 3 4 
    1 5 9
    6 7 2
    output:
    15

    2.
    input:
    1 15 14 4 
    12 6 7 9
    8 10 11 5
    13 3 2 18
    output:
    -1
    
    3.
    input:
    24 3 18 
    9 15 21
    12 27 6
    output:
    45
 */

import java.util.Scanner;
public class Quadradomagico {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho do quadrado mágico (N): ");
        int n = scanner.nextInt();
        if (n < 3 || n > 1000) {
            System.out.println("Tamanho inválido. O tamanho deve ser entre 3 e 1000.");
            scanner.close();
            return;
        }
        int[][] quadrado = new int[n][n];
        
        System.out.println("Preenchendo o quadrado mágico...");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                quadrado[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(quadrado[i][j] + " ");
            }
            System.out.println();
        }
        int somaEsperada = 0;
        for (int i = 0; i < n; i++) {
            somaEsperada += quadrado[0][i];
        }
        
        
        for(int i = 0; i < n; i++){
            int somaLinha = 0;
            for(int j = 0; j < n; j++){
                somaLinha += quadrado[i][j];
            }
            if(somaLinha != somaEsperada){
                System.out.println("-1");
                return;
            }
        }
        for(int i = 0; i < n; i++){
            int somaColuna = 0;
            for(int j = 0; j < n; j++){
                somaColuna += quadrado[j][i];
            }
            if(somaColuna != somaEsperada){
                System.out.println("-1");
                return;
            }
        }
        int somaDiagonalPrincipal = 0;
        for(int i = 0; i < n; i++){
            somaDiagonalPrincipal += quadrado[i][i];
        }
        if(somaDiagonalPrincipal != somaEsperada){
            System.out.println("-1");
            return;
        }
        int somaDiagonalSecundaria = 0;
        for(int i = 0; i < n; i++){
            somaDiagonalSecundaria += quadrado[i][n - 1 - i];
        }
        if(somaDiagonalSecundaria != somaEsperada){
            System.out.println("-1");
            return;
        }
        System.out.println(somaEsperada);
        
    }

}
