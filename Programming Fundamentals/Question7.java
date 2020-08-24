package Sessional1;

public class Question7 {
	public static boolean isPrime(int n){
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
		
	for(int i=2;i<1000;i++) {
			if(isPrime(i) && isPrime(i+2)) {
				System.out.println("("+i+", "+(i+2)+")");
			}
			
		}
		
	}

}
