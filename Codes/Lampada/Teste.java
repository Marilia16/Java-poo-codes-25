import java.util.Scanner;
public class Teste {
    public static void main(String[] args) {
        Lampada L1= new Lampada("Flourescent","white", 20);
        Scanner scanner = new Scanner(System.in);
        

        boolean perm = false;
        System.out.println("type: " + L1.getType());
        System.out.println("Color: " + L1.getColor());
        System.out.println("Power: " + L1.getPower());
        System.out.println("Is on? " + L1.getIsOn());
        while(!perm){
            System.out.println("New lamp: ");
            System.out.println("Type: ");
            String type = scanner.nextLine();
            L1.setType2(type);
            System.out.println("Color: ");
            String color = scanner.nextLine();
            L1.setColor2(color);
            System.out.println("Power: ");
            int power = scanner.nextInt();
            L1.setPower2(power);
            System.out.println("Is on( 1- yes and 0- no)? ");
           int isOn = scanner.nextInt();
           scanner.nextLine();
            if(isOn == 1){
                L1.setIsOn2(true);
            }else{
                L1.setIsOn2(false);
            }
            perm = L1.TrocarLampada();
            if(perm){
                System.out.println("Lamp changed successfully!");
                System.out.println("New type: " + L1.getType());
                System.out.println("New color: " + L1.getColor());
                System.out.println("New power: " + L1.getPower());
                System.out.println("Is on? " + L1.getIsOn());

            }else{
                System.out.println("the lamp can't be changed, it could be that the power is lower than allowed or it's turned on. please change again!");
                if(L1.getPower2() < L1.getPower()){
                    System.out.println("Power is lower than allowed. Try again!");
                }else{
                    if(L1.getIsOn2().equals("on")){
                        System.out.println("Lamp is on! The system will turn it off for you!");
                        L1.setIsOn2(false);
                        System.out.println("Lamp turned off!");
                        System.out.println("lamp changed successfully!");
                        System.out.println("New type: " + L1.getType());
                        System.out.println("New color: " + L1.getColor());
                        System.out.println("New power: " + L1.getPower());
                        System.out.println("Is on? " + L1.getIsOn());

                    }
                }
                
            }
            scanner.nextLine();

            
        }
        scanner.close();
        
        


        
        
    }

}
