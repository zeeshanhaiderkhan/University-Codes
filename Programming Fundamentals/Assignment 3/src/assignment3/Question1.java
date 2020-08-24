package assignment3;
import java.util.Scanner;

public class Question1 {
	public static void print(double[] array) {
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	public static void print(double[][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static double[] getRow(double[][] m, int rowIndex) {
		double[] array= new double[m[rowIndex].length];
		for(int i=0;i<(m[rowIndex]).length;i++) array[i]=m[rowIndex][i];
		return array;
	}
	public static double[] getColumn(double[][] m, int columnIndex) {
		double[] array= new double[m[columnIndex].length];
		for(int i=0;i<(m[columnIndex]).length;i++) array[i]=m[i][columnIndex];
		return array;
	}
	public static void main(String[] args) {
	/*double[][] array = {{1.0,4.0},{5.0,6.0,7.0},{8.0,9.0}};
	double[] array1=getRow(array,2);
	print(array1);*/
		//3x4 matrix;;
		
		
		System.out.println("Enter a 3x4 array:");
		Scanner kb= new Scanner(System.in);
		double[][] matrix = new double[3][4];
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				matrix[i][j]=kb.nextDouble();
			}
		}
		print(matrix);
		System.out.print("Enter Row to extract: ");
		int row=kb.nextInt();
		double[]  rowPrint= getRow(matrix,row);
		System.out.print("Resultant row is->   ");
		print(rowPrint);
	}

}
