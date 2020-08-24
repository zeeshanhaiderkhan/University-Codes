package Sessional1;
import java.util.Scanner;
public class question2 {
	public static int backward(int x) {
		int lastDigit; //%
		int reverseSum=0;//reverseSum=reverseSum+ last*(Math.pow(10,lengthOf1st-1);
		int rem=x;
		while(rem>0) {
			int lengthOfX=0;
			for(int i=rem; i>0;i=i/10 ) {
				lengthOfX++;
			}
			lastDigit=rem%10;
			rem=rem/10;
			reverseSum=reverseSum+(int)(lastDigit*Math.pow(10, lengthOfX-1));
			
		}
		return reverseSum;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int opt=1;
		while(opt!=0) {
			System.out.print("Enter an integer number: ");
			opt=kb.nextInt();
			System.out.println("Result "+backward(opt));
			
		}
		System.out.println("Exiting");
	}
	
	
}
