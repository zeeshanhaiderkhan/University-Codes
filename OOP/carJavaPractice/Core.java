public class Core implements Engine,Brake{
    private boolean state;
    int gear;   //maxGears==5
    private char gearCondition;
    private double speed;
    public Core(){
        state=false;
        gear=0;
    }
    
    public void start(){
        state=true;
        gear=0;
    }
    
    public void stop(){
        state=false;
        gear=0;
    }
    
    public int getGear(){
        return gear;
    }
    
    public boolean isRunning(){
       return state;
    }
    
    public boolean clutch(){
        return true;
    }
    
    public double getSpeed(){
        return speed;
    }
     
    public void gearUp(){
        if(gear==5){
            System.out.println("No more Gears to Gear UP!");
        }
        else {
            gear++;
            gearCondition='f';
        }
    }
    public void gearDown(){
        if(gear==0){
            System.out.println("Car is Already Stopped!");
        }
        else{
            gear--;
            gearCondition='f';
        }
    }
    
    public void gearReverse(){
        gear = -1;
        gearCondition = 'r';
    }
    
    public void accelerate(){
        if(gear == 0){
            System.out.println("Car is Static no Accelartion");
        }
        else if(gear == -1) {
            System.out.println("Reversing");
        }
        else{
            System.out.println("Moving forward");
            speed++;
        }
    }
    public void brakeFront(){
        System.out.println("Pressing front Brake");
    }
    public void brakeBack(){
        System.out.println("Pressing back Brake");
    }
    
    public void brakeBoth(){
        System.out.println("Pressing both Brakes");
    }
    
    public void handBrake(){
        System.out.println("Pressing hand Brakes");
    }
}