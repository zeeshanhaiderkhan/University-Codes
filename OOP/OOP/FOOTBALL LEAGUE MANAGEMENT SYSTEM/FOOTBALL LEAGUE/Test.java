import java.util.*;

public class Test{
    public static void main(){
        Scanner kb = new Scanner(System.in);
        int day= kb.nextInt();
        int month = kb.nextInt();
        int year=kb.nextInt()-1900;
        
        Date d1= new Date(year,month-1,day);   //month-1
        System.out.println(d1.toString());
        
    }
}