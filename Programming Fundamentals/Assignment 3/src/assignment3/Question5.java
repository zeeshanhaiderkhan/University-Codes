package assignment3;


	//Markov
	import java.util.Scanner;

	public class Question5 {
		public static void print(double[][] array) {
			for(int i=0;i<array.length;i++) {
				for(int j=0; j<array[i].length; j++) {
					System.out.print(array[i][j]+" ");
				}
				System.out.println();
			}
		}
		public static boolean isMarkovMatrix(double[][] m) {
			boolean result=true;
			for(int i=0;i<m.length;i++) {
				double sum=0;
				for(int j=0;j<m[i].length;j++) {
					sum+=m[j][i];
				
				if(m[i][j]<0) {
					result=false;
					break;
				}
			}
				if(sum!=1.0) {
					result=false;
					break;
				}
		}
			return result;
		}
		
		
	public static void main (String[] args) {
		//double[][] test= {{0.5,0.5,0},{0.5,0.5,0.8},{0,0,0.2}};
		Scanner kb = new Scanner(System.in);
		double[][] matrix=new double[3][3];
		System.out.println("Enter Elements of Matrix: ");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				matrix[i][j]=kb.nextDouble();
			}
		}
		print(matrix);
		if(isMarkovMatrix(matrix)) System.out.println("Markov Matrix True");
		else System.out.println("Markov Matrix False");
		}
	}
