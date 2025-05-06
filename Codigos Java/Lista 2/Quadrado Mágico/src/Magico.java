/* 
Arnaldo e Bernardo são dois garotos que compartilham um peculiar gosto por curiosidades
 matemáticas. Nos últimos tempos, sua principal diversão tem sido investigar propriedades 
 matemágicas de tabuleiros quadrados preenchidos com inteiros. Recentemente, durante uma 
 aula de matemática, os dois desafiaram os outros alunos da classe a criar quadrados mágicos, 
 que são quadrados preenchidos com números de 1 a N2, de tal forma que a soma dos N números 
 em uma linha, coluna ou diagonal principal do quadrado tenham sempre o mesmo valor. A ordem 
 de um quadrado mágico é o seu número de linhas, e o valor do quadrado mágico é o resultado 
 da soma de uma linha. Um exemplo de quadrado mágico de ordem 3 e valor 15 é mostrado na figura
 abaixo:

        2	7	6
        9	5	1
        4	3	8
Entrada
A primeira linha da entrada contém um único número inteiro N, indicando a ordem do 
quadrado (seu número de linhas). As N linhas seguintes descrevem o quadrado. Cada uma 
dessas linhas contém N números inteiros separados por um espaço em branco.

Saída
Seu programa deve imprimir uma única linha na saída padrão. Caso o quadrado 
seja mágico, a linha deve conter o valor do quadrado (ou seja, a soma de uma de 
suas linhas). Caso contrário, a linha deve conter o número 0.

Restrições
3 ≤ N ≤ 1000
2 ≤ valor de cada célula ≤ 109

Informações sobre a pontuação
Em um conjunto de casos de teste que totaliza 30 pontos, N ≤ 3.
Em um conjunto de casos de teste que totaliza 70 pontos, N ≤ 100.
Exemplos
Entrada
3
1 1 1
1 1 1
1 1 1
Saída
0
Entrada
4
16     3      2      13
5      10     11      8
9       6      7      12
4       15     14      1
Saída
34
Entrada
3
4 8 9
11 7 3
6 5 10
Saída
0
 */
import java.util.Scanner;

public class Quadradomagico2 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho do quadrado mágico (N): ");
        int n = scanner.nextInt();
        if (n < 3 || n > 1000) {
            System.out.println("Tamanho inválido. O tamanho deve ser entre 3 e 1000.");
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
                System.out.println("0");
                return;
            }
        }
        for(int i = 0; i < n; i++){
            int somaColuna = 0;
            for(int j = 0; j < n; j++){
                somaColuna += quadrado[j][i];
            }
            if(somaColuna != somaEsperada){
                System.out.println("0");
                return;
            }
        }
        int somaDiagonalPrincipal = 0;
        for(int i = 0; i < n; i++){
            somaDiagonalPrincipal += quadrado[i][i];
        }
        if(somaDiagonalPrincipal != somaEsperada){
            System.out.println("0");
            return;
        }
        int somaDiagonalSecundaria = 0;
        for(int i = 0; i < n; i++){
            somaDiagonalSecundaria += quadrado[i][n - 1 - i];
        }
        if(somaDiagonalSecundaria != somaEsperada){
            System.out.println("0");
            return;
        }
        System.out.println(somaEsperada);
        scanner.close();
    }

}
