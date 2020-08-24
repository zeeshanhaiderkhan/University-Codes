package Sessional1;
import java.util.Scanner;
public class Question3 {
	public static double series(int i) {
		return (Math.pow(i, 2))/(i+2);
	}
	public static double seriesB(int i) {
		double sum=0;
		for(int j=0; j<=i;j++) {
			sum=sum+(Math.pow(j, 2)/(j+2));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		System.out.print("Enter value of 1: ");
		int n=kb.nextInt();
		for(int i=1; i<=n;i++){
			System.out.println(i+"   "series(i));
	}

}
