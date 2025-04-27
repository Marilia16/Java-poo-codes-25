public abstract class Professional {
    private String cpf;
    private String name;
    protected float brutSalary;
    
    public Professional(String cpf, String name, float brutSalary) {
        this.cpf = cpf;
        this.name = name;
        this.brutSalary = brutSalary;
    }
    public String getCpf(){
        return cpf;
    }
    public final void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getName(){
        return name;
    }
    public final void setName(String name){
        this.name = name;
    }
    public float getBrutSalary(){
        return brutSalary;
    }    
    public void setBrutSalary(float brutSalary){
        if(brutSalary >= 0){
                this.brutSalary = brutSalary;
        }
    }
    public float NetSalary(float discount,float bonus){
        return (brutSalary * discount) + bonus;
            
    }
    public abstract String professionalData();
}
