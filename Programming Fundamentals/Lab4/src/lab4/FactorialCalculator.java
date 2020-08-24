/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package lab4;

/**
 *
 * @author comsats
 */
public class FactorialCalculator {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n;
        n= kb.nextInt();
        while(n<0){
            n=n*(n-1);
            n=n-1;
        }
        System.out.println(n);
    }
}
