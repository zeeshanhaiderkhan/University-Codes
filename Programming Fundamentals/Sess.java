/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labsessional;
import java.util.Scanner;
/**
 *
 * @author comsats
 */
public class Sess1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner kb =new Scanner(System.in);
        String check = kb.next();

        int length= check.length();

        int countNumber=0;
        int countAlpha=0;
        int countNon=0;
        int a=0;
        String abc="";
        int letter =0;
        while(a<length){
            //System.out.println(check.charAt(a));
            letter = (char)check.charAt(a);
            
            if(letter>=48 && letter<=57){
                countNumber++;
                
                
            }
            else if((letter>=65 && letter<=90) || (letter>=97 && letter<=122)){
                countAlpha++;
            }

            else{
                countNon++;
            }
            a++;
        }            
        System.out.println("Alphabets   =   "+ countAlpha);
        System.out.println("Number      =   " +countNumber);
        System.out.println("Non-alpha-numeric  =  "+countNon);
        System.out.println();
        
    }
    
}
