public class lampada {
    private String type;
    private String color;
    private int power;
    private boolean isOn;

    private String type2;
    private String color2;
    private int power2;
    private boolean isOn2;
    
    public lampada(String type, String color, int power) {
        this.type = type;
        this.color = color;
        this.power = power;
        this.isOn = false;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

   public String getColor(){
        return this.color;
   }

   public void setColor(String color){
        this.color = color;
   }

   public int getPower(){
        return this.power;
   }
    public void setPower(int power){
          this.power = power;
    }

    public String getIsOn(){
        return this.isOn ? "on" : "off";
    }

    public void setIsOn(boolean isOn){
        this.isOn = isOn;
    }

    public void setType2(String type){
        this.type2 = type;
    }

    public String getType2(){
        return this.type2;
    }

    public void setColor2(String color){
        this.color2 = color;
    }

    public String getColor2(){
        return this.color2;
    }

    public void setPower2(int power){
     this.power2 = power;
    }

    public int getPower2(){
        return this.power2;
    }

    public void setIsOn2(boolean isOn){
       this.isOn2 = isOn;
    }

    public String getIsOn2(){
        return this.isOn2 ? "on" : "off";
    }

    public boolean TrocarLampada(){
        if(!this.isOn2){
            if(this.power2>this.power){
                this.power = this.power2;
                this.type = this.type2;
                this.color = this.color2;
                this.isOn = this.isOn2;
                return true;
            }
        }
        return false;
    } 

}
