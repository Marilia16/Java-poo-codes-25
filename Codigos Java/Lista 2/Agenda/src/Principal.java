import java.util.Scanner;
import java.util.ArrayList;
public class Principal{
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        int resp, i;
        String nomeBusca;
        boolean achou= false;
        ArrayList<Pessoa> agenda = new ArrayList<Pessoa>();

        do{
            System.out.println("\nOperação 1: Adicionar pessoa na agenda");
            Pessoa p = new Pessoa();
            System.out.println("\nDigite o nome da pessoa: ");
            p.setNome(ler.nextLine());
            System.out.println("\nDigite o telefone da pessoa: ");
            p.setTelefone(ler.nextLine());
            agenda.add(p);
            System.out.println("\nDeseja adicionar outro contato? 1-sim 2-nao");
            resp = ler.nextInt();
            ler.nextLine(); 
        }while(resp == 1);
        System.out.println("\nOperação 2: Buscar pessoa na agenda");
        System.out.println("\nDigite o nome da pessoa que deseja buscar: ");
        nomeBusca = ler.nextLine();
        for(i=0; i<agenda.size(); i++){
            if(agenda.get(i).getNome().equals(nomeBusca)){
                System.out.println("\nContato localizado!");
                System.out.println("\nTelefone: " + agenda.get(i).getTelefone());
                System.out.println("Operação 3: Alterando telefone da pessoa");
                System.out.println("\nDigite o novo telefone: ");
                agenda.get(i).setTelefone(ler.nextLine());
                System.out.println("\nTelefone alterado com sucesso!");
                System.out.println("Operação 4: Excluir pessoa da agenda");
                System.out.println("\nDeseja excluir o contato? 1-sim 2-nao");
                if(ler.nextInt() == 1){
                    agenda.remove(agenda.get(i));
                    System.out.println("\nContato excluído com sucesso!");

                }
            }

        }
        if(!achou){
            System.out.println("\nContato não localizado!");

        }
        System.out.println("\nOperação 5: Listar pessoas na agenda");
        for(i=0; i<agenda.size(); i++){
            System.out.println("\nNome: " + agenda.get(i).getNome());
            System.out.println("\nTelefone: " + agenda.get(i).getTelefone());
        }
        ler.close();
        System.out.println("FIM DO PROGRAMA!");
    

    }
}

