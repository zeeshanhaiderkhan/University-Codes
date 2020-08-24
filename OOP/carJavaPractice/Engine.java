public interface Engine{
    void start();
    void stop();
    
    boolean isRunning();
    
    boolean clutch();
    
    void gearUp();
    void gearDown();
    
    void gearReverse();
    
    void accelerate();
}