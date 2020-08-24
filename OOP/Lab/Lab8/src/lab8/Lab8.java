/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;
import java.util.Scanner;

/**
 *
 * @author FA18-BSE-103
 */
public class Lab8 {
    
    public static void myPrint(String s){
        System.out.println("Hello!");
    }
    public static int maxB(int n1,int n2,int n3){
        if(n1>=n2 && n1>=n3) return n1;
        else if(n2>=n1 && n2>=n3) return n2;
        else return n3;
    }
    /*public static boolean isFibonacci(int n){
        int a=0;
        int b=1;
        int fibonacci;
        while(true){
            fibonacci=a+b;
            a=b;
            b=fibonacci;
            if(fibonacci==n) break;
        
        
        
        
    }
    public static boolean isFibonacci(int n){
        
    }*/
    public static int ulta(int n){
        String s;
       
       String n=(char)n;
       for(int i; i<n.length)
       
        
    }
    public static int max(int n1,int n2){
        if(n1>n2) return n1;
        else return n2;
    }
    public static int gcd(int n1, int n2, int n3){
        int result = 0;
            for(int i=n1; i>0; i--){
                if ((n1%i==0) && (n2%i==0) && (n3%i==0)){
                     result=i;
                     break;         
                }
            }
            return result;
            
        
    }
    public static boolean isPrime(int n){
        int count=0;
        for(int i=1; i<=n; i++){
            if(n%i==0) count++;
        }
        return count==2;
    }
    
    public static boolean isPrimea(int n){
        boolean result = false;
        for(int i=2; i<n;i++){
            if(n%i==0){
                result=true;
                break;
            }
        }
        return result==false;
    }
    
    
    public static void main(String[] args) {
        //System.out.println(maxB(2,3,4));
        //myPrint("a");
        //System.out.println(max(2,3));
        //System.out.println(gcd(8,4,12));
       // System.out.println(isPrime(53));
        //System.out.println(isPrimea(2));
        Scanner kb= new Scanner(System.in);
        int a,b;
       /* while(true){
            System.out.print("Enter a:");
            a=kb.nextInt();
            System.out.print("Enter b:");
            b=kb.nextInt();
            if(a<0 || b<0) break;
            else System.out.println(max(a,b));
        }*/
        while(true){
            System.out.print("Enter Number : ");
            a=kb.nextInt();
            if(a==0) break;
            else if (isPrimea(a)==true) System.out.println("The Number "+a+" is prime.");
            else System.out.println("The Number "+a+" is not prime.");
        }
    }
    
}
