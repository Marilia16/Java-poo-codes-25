public class Teacher extends Professional {
    private int workedHours;

    public Teacher(String cpf, String name, float brutSalary, int workedHours) {
        super(cpf, name, brutSalary);
        this.workedHours = workedHours;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    @Override

    public float NetSalary(float discount, float bonus) {
        return ((getBrutSalary() * workedHours) * discount) + bonus;
    }

    @Override 
    public String professionalData() {
        return "CPF:" + getCpf() + "\n" + "Name:" + getName() + "\n" + "Brut Salary:" + getBrutSalary() + "\n" + "Worked Hours:" + workedHours;
    }
}