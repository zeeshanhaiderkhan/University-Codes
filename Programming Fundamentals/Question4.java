package Sessional1;
import java.util.Scanner;
public class Quesetion4 {
	public static int gcd(int a, int b) {
		int i=a;
		for(; i>0;i--) 
			if((a%i==0) && (b%i==0)) break;
		return i;
	}
	public static void main(String[] args) {
		//a.
		/*int a,b;
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("Enter two Positive Integers: ");
			a=kb.nextInt();
			b=kb.nextInt();
			if(a < 0 || b<0) break;
			System.out.println("GCD = "+ gcd(a,b));
	}
		System.out.println("Exiting.");

		int a,b;
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("Enter two Positive Integers: ");
			a=kb.nextInt();
			b=kb.nextInt();
			if(a < 0 && b<0) break;
			System.out.println("GCD = "+ gcd(a,b));
	}
		System.out.println("Exiting.");*/
		int a,b;
		Scanner kb = new Scanner(System.in);
		a=kb.nextInt();
		b=kb.nextInt();
		
		while(a>0 && b>0) {
			System.out.println("GCD = "+ gcd(a,b));
			System.out.print("Enter two Positive Integers: ");
			a=kb.nextInt();
			b=kb.nextInt();
			
	}
		System.out.println("Exiting.");
}
}
