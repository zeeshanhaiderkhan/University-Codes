

public class Time
{
    
    private int H,M,S;

   
    public Time()
    {
       H=0;
       M=0;
       S=0;
    }
    

    public void setH(int h)
    {
        H=h;
    }
    
    public void setM(int m)
    {
        M=m;
    }
    
    public void setS(int s)
    {
        S=s;
    }
    
    public int getH(){
        return H;
    }
    
     public int getM(){
        return M;
    }
    
    public int getS(){
        return S;
    }
    
    public void tick()
    {
        S++;
        update();
    }
    public String getTime(){
        return (H+" Hrs, "+M+" Mins, "+S+" Sec");
    }
    private void update(){
        if(S>=60){
        S=0;
        M++;}
        if(M>=60){
        M=0;
        H++;}
        if(H>=24){
            H=0;}
        }
}
