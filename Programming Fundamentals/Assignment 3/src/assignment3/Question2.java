package assignment3;

import java.util.Scanner;
public class Question2 {
	public static void print(double[] array) {
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	public static boolean isUnitMatrix(int[][] m) {
		int sum=0;
		int count=0;
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				sum+=m[i][j];
				if(i==j && m[i][j]==1) count++;
			}
		}
		return sum==m.length && count==m.length;
	}
	public static double[] extractMajorDiagonal(double[][] m) {
		double[] array=new double[m.length];
		for(int i=0;i<m.length;i++) {
			array[i]=m[i][i];
		}
		return array;
	}
	
	public static void main(String[] args) {
		/*double[][] matrix= {{1,0,0},{0,1,0},{0,0,1}};
		double[] test=extractMajorDiagonal(matrix);
		print(test);*/
		double[][] matrix=new double[4][4];
	
		Scanner kb= new Scanner(System.in);
		System.out.println("Enter a 4x4 array;");
		for(int i=0;i<4;i++) for(int j=0;j<4;j++) {
			matrix[i][j]=kb.nextDouble();
		}    
		//int[][] matrix= {{1,0,0},{1,1,0},{0,0,1}};
		
		double[] diagonal=extractMajorDiagonal(matrix);
		System.out.print("The diagonal is:  ");
		print(diagonal);
		double sum=0;
		for(int i=0;i<4;i++) sum+= diagonal[i];
		System.out.print("Sum of diagonal is = "+ sum);
		//System.out.println(isUnitMatrix(matrix));

	}

}
