/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.Scanner;

/**
 *
 * @author comsats
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("enter row");
        int r = input.nextInt();
        int i = 0;
        while (r > i) {
            i++;
        
        int j = 0;
        while (j < i) {
            System.out.print("*");
            j++;
        }
        
        System.out.println("");

    }

}
}

    
}
