package Sessional1;

public class Question5 {
	public static int backward(int n) {
		int rev=0;
		for(int rem=n; rem!=0;rem=rem/10 )
			rev=rev*10+(rem%10);
		return rev;
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
	public static boolean emirp(int n) {
		return ( isPrime(n) && isPrime(backward(n)) && !(isPalindrome(n)) );
	}
	public static void main(String[] args) {
		int i=0;
		int count=0;
		while(count<100) {
			if(emirp(i)) {
				System.out.print(i+" ");
				count++;
				if(count%10==0) System.out.println();
			}
			
			i++;
		}
		
	}

}
