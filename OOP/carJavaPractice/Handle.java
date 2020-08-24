public interface Handle{
    
    void turnRight();
    void turnLeft();
    
    void setIndicator(char side);   //both, left, right
    
    void horn();
    void headLights(boolean state);//false for off true for on
    
}