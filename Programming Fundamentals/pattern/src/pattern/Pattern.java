/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern;
import java.util.Scanner;

/**
 *
 * @author comsats
 */
public class Pattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n,r,b,c,c_a;
        Scanner kb=new Scanner(System.in);
        n=kb.nextInt();
        r=1;
        c=(n-1);
        while(r<=n){
                    
                    b=1;
                    
                    c_a=1;
                         
                   
                    while (b<=r){
                        System.out.print("*");
                        b++;
                    }
                    while(c_a<=c){
                        System.out.print("+");
                        c_a++;
                    }
                    c--;
                    
                     System.out.println("");
                     
                    r++;
                    
        }
        // TODO code application logic here
    }
    
}
