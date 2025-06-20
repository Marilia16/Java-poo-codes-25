public class Dado {
    private int valorFace;  

    
    public int getValorFace() {
        return valorFace;
    }

    
    public void setValorFace() {
        this.valorFace = (int) (1 + Math.random() * 6);
    }
}
