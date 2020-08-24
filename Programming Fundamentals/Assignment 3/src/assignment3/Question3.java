package assignment3;

public class Question3 {
	public static void print(double[][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void print(int[] array) {
		for(int i=0;i<array.length;i++) {
			
				System.out.print(array[i]+" ");
		}
	}
	public static double[][] multiplyMatrix(double[][] a,double[][] b){
		//no of rows of b== no of columns a
		int sumColumn=0;
		for(int i=0;i<a.length;i++) {
			sumColumn+=a[i].length;
		}
		if(sumColumn%a[0].length==0 && b.length==a[0].length) {
		double[][] m=new double[a.length][b[0].length];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				double sum=0;
				for(int k=0;k<b.length;k++) {
					sum+=(a[i][k]*b[k][j]);
				}
				m[i][j]=sum;
			}
		}
		return m;
		}
		else return null;
	}
	
	public static void main(String[] args) {
		double[][] b= {{1,2},{3,4}};
		double[][] a= {{1,2},{3,4}};
		double[][] m=multiplyMatrix(a,b);
		print(m);
		
		
	}

}
