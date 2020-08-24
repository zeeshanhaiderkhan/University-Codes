public class Main{
    public Main(){
    
    }
    public static void main(){
        Parent p = new Parent(2);
        Child c = (Child) p;
        System.out.println(c);
    }
}