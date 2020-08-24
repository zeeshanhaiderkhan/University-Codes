package Sessional1;

public class question3b {
	public static int gcd(int a, int b) {
		int gcdB;
		if(a>=b) {
			for(int i=b; i>0;i--) {
				if(a%i==0 && b%i==0) gcdB=i;
			}
		}
		else {
			for(int i=a; i>0;i--) {
				if(a%i==0 && b%i==0) gcdB=i;
			}
		}
		return gcdB;
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(24,26));

	}

}
