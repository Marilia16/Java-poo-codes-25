public class Engineer extends Professional {
    private String crea;
    public static float salaryfloor = 7000.0f;
    
    public Engineer(String cpf, String name, float brutSalary, String crea) {
        super(cpf, name, brutSalary);
        this.crea = crea;
    }


    public static float calcularPisoCorrigido(float fatortrabalhista){
        return salaryfloor * fatortrabalhista;
    }

    @Override
    public String professionalData(){
        return "CPF:" + getCpf() + "\n" + "Name:" + getName() + "\n" + "Brut Salary:" + getBrutSalary() + "\n" +  "Crea:" + crea;
    }

}
