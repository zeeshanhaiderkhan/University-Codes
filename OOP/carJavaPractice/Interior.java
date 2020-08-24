public class Interior extends Core implements Lights, Handle, SpeedMeter{
    
    private char indicator;
    private boolean headLights,backLights;
    private double fuel;
    public Interior(){
    
    }
    public void turnRight(){
        System.out.println("Turning Righ!");
    }
    public void turnLeft(){
        System.out.println("Turning Left!");
    }
    public void setIndicator(char side){//'l','r','b'
        indicator = side;
    }
    public void horn(){
        System.out.println("PEEP!!");
    }
    public void headLights(boolean state){
        headLights = state;
    }
    public boolean headLights(){
        return headLights;
    }
    public boolean backLights(){
        return backLights;
    }
    public void backLights(boolean state){
        backLights=state;
    }
    
    
    public void checkFuel(){
        System.out.println("Your fuel is : "+fuel+"ltrs");
    
    }
    
    public char getIndicator(){
        return indicator;
    }
}