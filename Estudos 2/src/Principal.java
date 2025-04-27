public class Principal {
    public static void main(String[] args) {
        Engineer e1 = new Engineer("123456789", "Igor", 10000 , "crea12345");
        System.out.println("Engineer:");
        System.out.println(e1.professionalData());
        System.out.println("Net Salary: " + e1.NetSalary(0.9f, 1000f));
        System.out.println("Piso Corrigido: " + Engineer.calcularPisoCorrigido(1.2f));
        System.out.println();
    

        Doctor d1 = new Doctor("987654321", "Ana", 15000, "crm12345");
        System.out.println("Doctor:");
        System.out.println(d1.professionalData());
        System.out.println("Net Salary: " + d1.NetSalary(0.85f, 2000f));
        System.out.println();

        Homoterapist h1 = new Homoterapist("456789123", "Carlos", 12000, "crm67890", true);
        System.out.println("Homoterapist:");
        System.out.println(h1.professionalData());
        System.out.println("Net Salary: " + h1.NetSalary(0.9f, 1500f));
        System.out.println();

        Teacher t1 = new Teacher("321654987", "Maria", 1500, 20);
        System.out.println("Teacher:");
        System.out.println(t1.professionalData());
        System.out.println("Net Salary: " + t1.NetSalary(0.95f, 500f));
        


    }
}
