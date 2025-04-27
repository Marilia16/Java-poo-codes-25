public class Lampada {

  private String tipo;
  private Integer potencia;
  private String cor;
  private Boolean estado;
  
  public String getTipo(){
    return tipo;
  }
 public void setTipo(String tipo){
   this.tipo=tipo;
 }
 public int getPotencia(){
   return potencia;
 }
 public void setPotencia(int potencia){
   this.potencia=potencia;
 }
 public String getCor(){
   return cor; 
 }
 public void setCor(String cor){
   this.cor=cor;
 }
 public Boolean getEstado(){
   return estado;
 }
 public void setEstado(Boolean estado){
   this.estado=estado;
 }
 public void trocarLampada(int potenciaNova){
   if (!this.estado && this.potencia<potenciaNova){
     this.potencia=potenciaNova;
     
     System.out.println("Lâmpada trocada com sucesso");
   } else{
     System.out.println("Lâmpada incompatível ou está desligada");
   } 
 }
}