
package conversion.millisecond;

import java.util.Scanner;

public class ConversionMillisecond {


    public static void main(String[] args) {
        double ms;
        int rs , s , rm , m , rh , h , d , rd;
        
        Scanner kb ;
        kb = new Scanner (System.in);
        System.out.print("enter the number of milliseconds: ");
        ms = kb.nextDouble();
        
        rs = (int) (ms%1000);
        System.out.println("the remaining milli seconds are : "+ rs);
        
        s = (int) (ms / 1000);
        System.out.println(s);
        
        rm  =(int) (s % 60); 
        System.out.println("the remaining seconds are : "+ rm);
        
        m = (int) (s / 60);
        System.out.println(m);
        
        rh  = (int) (m % 60) ;
        System.out.println("the remaining minutes : "+ rh);
        
        h = (int) ( m / 60);
        System.out.println(h);
        
        rd = (int)(h%24);
        System.out.println("the remaining hours : "+ rd);
        
        
        d = (int) ( h / 24);
        System.out.println(d);
        
        System.out.println("There are " + d + "days " + "," + rd + "hours " + "," +rh + "minutes " + "," + rm + "seconds " + "and " + rs + "milliseconds in total of " + ms +  "milliseconds" );
        
        
        
        
        
        
        
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
