public class Doctor extends Professional {
    private String crm;
    
    public Doctor(String cpf, String name, float brutSalary, String crm) {
        super(cpf, name, brutSalary);
        this.crm = crm;
    }

    @Override
    public String professionalData(){
        return "CPF:" + getCpf() + "\n" + "Name:" + getName() + "\n" + "Brut Salary:" + getBrutSalary() + "\n" + "CRM:" + crm;  
    }
}