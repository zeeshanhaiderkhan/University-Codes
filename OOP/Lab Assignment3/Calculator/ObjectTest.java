public class ObjectTest{
    public static Object sum(Object a, Object b){
    
        return a.toString() + b.toString();
    }
    public static void main(){
        System.out.println(sum(1,2));
    }
}