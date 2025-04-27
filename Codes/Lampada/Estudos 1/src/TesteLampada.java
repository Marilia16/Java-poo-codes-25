public class TesteLampada{
public static void main (String[] args) {
Lampada lampada= new Lampada();

lampada.setTipo("Fluorescente");
lampada.setPotencia(20);
lampada.setCor("Branca");
lampada.setEstado(false);

  System.out.println("Tipo" + lampada.getTipo());
  
  System.out.println("Potência: " + lampada.getPotencia() + "w");
   System.out.println("Cor: " + lampada.getCor());
   System.out.println("Estado: " + (lampada.getEstado() ? "Ligada": "Desligada"));

                lampada.trocarLampada(30);
    System.out.println("Potência após troca:" + lampada.getPotencia() + "w");
}
}