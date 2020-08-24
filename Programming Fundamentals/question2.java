package Sessional1;
import java.util.Scanner;
public class question2 {
	public static int backward(int n) {
		int rev=0;
		for(int rem=n; rem!=0;rem=rem/10 )
			rev=rev*10+(rem%10);
		return rev;
		}
		
	
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n;
		while(true) {
			System.out.print("Enter an integer number: ");
			n=kb.nextInt();
			if(n==0) break;
			else System.out.println("Result "+backward(n)); 
			
			
		}
		System.out.println("Exiting");
	}
	
	
}
 