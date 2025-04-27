public class Homoterapist extends Doctor{
    private boolean acreditation;

    public Homoterapist(String cpf, String name, float brutSalary, String crm, boolean acreditation) {
        super(cpf, name, brutSalary, crm);
        this.acreditation = acreditation;
    }

    public boolean isAcreditation() {
        return acreditation;
    }

    public String professionalData(){
        return super.professionalData() + "\n" + "Acreditation:" + acreditation;
    }
}