public class BaseClass{
    private int a;
    private int b;
    
    public BaseClass(int f){
        a=f;
    }
    
    public double retA(){
        return a;
    }
    
    private static void set(){
        System.out.println("YES");
    }
}