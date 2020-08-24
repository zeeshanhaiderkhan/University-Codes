package Sessional1;

import java.util.Scanner;

public class Assignment2 {
// Quesetion1
	public static boolean isPrime(int n) {
		//by count method
		int count=0;
		for(int i=1; i<=n; i++){
			if(n%i==0) count++;
		}
		return count==2;
	}
	public static void main(String[] args) {
		
		Scanner kb= new Scanner(System.in);
		
		int n=1;
		while( true) {
			int i=0;
			int counting=2;
			System.out.print("Enter an integer number: ");
			n=kb.nextInt();
			if(n==0) {
				System.out.println("Exiting");
				break;
			}
			System.out.print("Prime numbers = ");
			while(i<n) {
				if(isPrime(counting)==true) {
					System.out.print(counting+" ");
					i++;
				}
				
				counting++;
			
		}System.out.println();
		
		}
	}

}
