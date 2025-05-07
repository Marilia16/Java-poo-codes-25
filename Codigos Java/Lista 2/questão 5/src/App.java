import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int soma = 0;
        
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Adicione 6 numeros inteiros: ");
        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            int number = scanner.nextInt();
            numbers.add(number);
        }
        for(int i : numbers){
            soma += i;
        }
        System.out.println("A soma dos números é: " + soma); ;
        System.out.println("A média dos números é: " + soma / numbers.size());
        System.out.println("O maior número é: " + Collections.max(numbers));
        System.out.println("O menor número é: " + Collections.min(numbers));
        Collections.sort(numbers);
        System.out.println("Ordem crescente:  " + numbers);
        Collections.reverse(numbers);
        System.out.println("Ordem decrescente:  " + numbers);
        System.out.println("escolha o número que quer ver se repitiu: ");
        int number = scanner.nextInt();
        int count = 0;
        for(int i : numbers){
            if(i==number){
                count++;
            }
        }
        System.out.println("O número " + number + " se repetiu " + count + " vezes.");
        
        
        scanner.close();

    }

}
