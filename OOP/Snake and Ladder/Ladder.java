
public enum Ladder
{
    ladder1(51,3),
    ladder2(27,6),
    ladder3(70,20),
    ladder4(55,36),
    ladder5(95,63),
    ladder6(98,68);
    
    private int top;
    private int bottom;
    
    Ladder(int t,int b){
        top=t;bottom=b;
    }
    public int top(){
        return this.top;
    }
    public int bottom(){
        return this.bottom;
    }
}
