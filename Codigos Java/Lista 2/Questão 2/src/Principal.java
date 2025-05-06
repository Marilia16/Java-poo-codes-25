import java.util.ArrayList;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        int opc, codNota, buscarMat, tentarNovamente=2;
        float novaNota;
        boolean flag = false;
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        do{
            System.out.println("\t1-Cadastrar Aluno\n\t2-Cadastrar Nota\n\t3-Calcular Médias\n\t4-Imforma situações\n\t5-Imformar Dados do Aluno\n\t6-Alterar Nota\n\t7-Sair");
            System.out.println("\tDigite a opção desejada: ");
            opc = ler.nextInt();

            switch(opc){
                case 1:
                    System.out.println("\tCadastrando aluno:");
                    Aluno aluno = new Aluno();
                    System.out.println("\tDigite o nome do aluno:");
                    ler.nextLine(); 
                    aluno.setNome(ler.nextLine());
                    do{
                        System.out.println("\tDigite a matrícula do aluno:");
                        if(lista.isEmpty()){
                            aluno.setMatricula(ler.nextInt());
                        }else{
                            buscarMat = ler.nextInt();
                            flag = false;
                            for(int i = 0; i < lista.size(); i++){
                                if(lista.get(i).procurarAluno(buscarMat)==true){
                                    System.out.println("\tMatrícula já cadastrada! Tente novamente.");
                                    flag = true;
                                    break;
                                }
                            }
                            if(!flag){
                                aluno.setMatricula(buscarMat);
                            }
                        }
                    }while(flag == true);
                    lista.add(aluno);
                    System.out.println("\tAluno cadastrado com sucesso!");
                break;
                case 2:
                    System.out.println("\tCadastrando notas:");
                    do{
                        tentarNovamente=2;
                        System.out.println("\tDigite a matrícula do aluno:");
                        buscarMat = ler.nextInt();
                        flag = false;
                        for(int i = 0; i < lista.size(); i++){
                            if(lista.get(i).procurarAluno(buscarMat)==true){
                                System.out.println("\tAluno encontrado!");
                                System.out.println("\tDigite a nota 1 do aluno:");
                                lista.get(i).setNota1(ler.nextFloat());
                                System.out.println("\tDigite a nota 2 do aluno:");
                                lista.get(i).setNota2(ler.nextFloat());
                                System.out.println("\tDigite a nota 3 do aluno:");
                                lista.get(i).setNota3(ler.nextFloat());
                                flag = true;

                            }
                        } 
                        if(!flag){
                            System.out.println("\tAluno não encontrado!");
                            System.out.println("\tDeseja tentar novamente? 1-Sim 2-Não");
                            tentarNovamente = ler.nextInt();
                        }
                    }while(tentarNovamente == 1 || flag == false);
                    System.out.println("\tNotas cadastradas com sucesso!");
                break;
                case 3: 
                    System.out.println("\tCalculando médias:");
                    do{
                        tentarNovamente=2;
                        System.out.println("\tDigite a matrícula do aluno:");
                        buscarMat = ler.nextInt();
                        flag = false;
                        for(int i = 0; i < lista.size(); i++){
                            if(lista.get(i).procurarAluno(buscarMat)==true){
                                System.out.println("\tAluno encontrado!");
                                lista.get(i).calcularMedia();
                                System.out.println("\tMédia do aluno: " + lista.get(i).getMedia());
                                flag = true;
                            
                            }
                        }
                        if(!flag){
                            System.out.println("\tAluno não encontrado!");
                            System.out.println("\tDeseja tentar novamente? 1-Sim 2-Não");
                            tentarNovamente = ler.nextInt();
                        }

                    }while(tentarNovamente == 1);
                break;
                case 4: 
                    System.out.println("\tImprimindo situação do aluno:");
                    do{
                        opc=2;
                        System.out.println("\tDigite a matrícula do aluno:");
                        buscarMat = ler.nextInt();
                        flag = false;
                        for(int i = 0; i < lista.size(); i++){
                            if(lista.get(i).procurarAluno(buscarMat)==true){
                                System.out.println("\tAluno encontrado!");
                                System.out.println("\tO Aluno(a) " + lista.get(i).getNome() + " está " + lista.get(i).getSituacao());
                                flag = true;
                            }
                        }
                        if(!flag){
                            System.out.println("\tAluno não encontrado!");
                            System.out.println("\tDeseja tentar novamente? 1-Sim 2-Não");
                            tentarNovamente = ler.nextInt();
                        }
                    }while(tentarNovamente == 1);
                break;
                case 5:
                System.out.println("\tImprimindo dados do aluno:");
                    do{
                        tentarNovamente=2;
                        System.out.println("\tDigite a matrícula do aluno:");
                        buscarMat = ler.nextInt();
                        flag = false;
                        for(int i = 0; i < lista.size(); i++){
                            if(lista.get(i).procurarAluno(buscarMat)==true){
                                System.out.println("\tAluno encontrado!");
                                lista.get(i).imprimirDados();
                                flag = true;
                            }
                        }
                        if(!flag){
                            System.out.println("\tAluno não encontrado!");
                            System.out.println("\tDeseja tentar novamente? 1-Sim 2-Não");
                            tentarNovamente = ler.nextInt();
                        }
                    }while(tentarNovamente == 1);
                break;
                case 6:
                    System.out.println("\tAlterando nota do alumo:");
                    do{
                        opc=2;
                        System.out.println("\tDigite a matricúla do aluno: ");
                        buscarMat = ler.nextInt();
                        flag = false;
                        for(int i = 0; i < lista.size(); i++){
                            if(lista.get(i).procurarAluno(buscarMat)==true){
                                System.out.println("aluno encontrado!");
                                System.out.println("\tDigite a nota que deseja alterar: 1-Nota 1 2-Nota 2 3-Nota 3");
                                codNota = ler.nextInt();
                                System.out.println("\tDigite a nova nota: ");
                                novaNota = ler.nextFloat();
                                System.out.println(lista.get(i).alterarNota(codNota, novaNota));
                                System.out.println("\tNota alterada com sucesso!");
                                lista.get(i).calcularMedia();
                                System.out.println("Nova media do aluno: " + lista.get(i).getMedia());

                                System.out.println("O aluno " + lista.get(i).getNome() + " está " + lista.get(i).getSituacao());
                                flag = true;

                            }
                        }
                        if(!flag){
                            System.out.println("\tAluno não encontrado!");
                            System.out.println("\tDeseja tentar novamente? 1-Sim 2-Não");
                            tentarNovamente = ler.nextInt();
                        }
                    }while(tentarNovamente == 1);
                break;
                case 7:
                    System.out.println("\tSaindo do sistema...");
                break;
                default:
                    System.out.println("\tOpção inválida!");
            }
        }while(opc!= 7);
        ler.close();
        System.out.println("\n\tSistema encerrado!");
    }
}