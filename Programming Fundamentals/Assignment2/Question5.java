package Sessional1;

public class Question5 {
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
	public static boolean isPrime(int x) {
		int count=0;
		for(int i=1; i<=x;i++) {
			if(x%i==0) count++;
		}
		return count==2;
	}
	public static boolean isPalindrome(int x) {
		return (x==backward(x) && isPrime(x));
	}
	public static void main(String[] args) {
		int i=0;
		int count=0;
		while(count<100) {
			if(isPalindrome(i)) {
				System.out.print(i+" ");
				count++;
				if(count%10==0) System.out.println();
			}
			i++;
		}
		
	}

}
