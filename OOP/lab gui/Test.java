import java.util.ArrayList;

public class Test{
    public Test(){
        
    }
    public ArrayList<Integer> fold(ArrayList<Integer> a){
        ArrayList<Integer> b=new ArrayList<Integer>();
        for(int i=0,j=a.size()-1;i!=j;i++,j--){
            b.add(a.get(i)+a.get(j));
        }
        return b;
    }
    public static void main(){
        
    }
}
