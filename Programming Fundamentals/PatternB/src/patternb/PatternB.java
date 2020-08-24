/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternb;
import java.util.Scanner;
/**
 *
 * @author comsats
 */
public class PatternB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int n,r,r_a,r_b,a,b;
        n=kb.nextInt();
        r=1;
        //r_b=1;
        
        while (r<=n)  {
            
            a=1;
            b=1;
            
            
            while (a<=(n-1)){
                System.out.print("+");
                a++;
            }
            while(b<=r) {
                System.out.print("*");
                b++;
            }
            System.out.println("");
            n--;
            
            r++;
        }
        
        
    }
    
}
