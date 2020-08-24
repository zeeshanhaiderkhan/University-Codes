/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8b;
//<h1> Loop <h1/>

import java.util.Scanner;

/**
 *
 * @author FA18-BSE-103
 */
public class Lab8b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x; int y;
        
        Scanner kb = new Scanner(System.in);
        
        do{
            System.out.println("Enter First integer: ");
            x= kb.nextInt();

            System.out.println("Enter Second integer: ");
            y=kb.nextInt();
        
            //if(x==-1|| y==-1) break;
            
            System.out.println("x = "+x+" and y = "+y);
        }while(x>0 || y>0); // dono 1 sy kam  aur (x>0 && y>0) dono mei sy ek 1 
        System.out.println("I am out of the loop!");
    }
    
}
