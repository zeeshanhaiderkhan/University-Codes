/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamond;
import java.util.Scanner;
/**
 *
 * @author comsats
 */
public class Diamond {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        double n,a;
        int r;
        n= kb.nextDouble();
        r=1;
        while(r<=n){
            a=1;
            if (a<=(n/2+(0.5))){
                while(a<=r){
                System.out.print('*');
                a=2*a+1;
                
                    }
                System.out.println("");
            
            
            
        }
            else {
                  while(a<=r){
                System.out.print('*');
                a=2*a-1;
                 
            }
                    System.out.println("");
        // TODO code application logic here
    }
            r++;
    
}
