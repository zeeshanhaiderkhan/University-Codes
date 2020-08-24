package assignment3;

public class Question4 {
	public static void print(int[][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean checkRow(int[][] m, int rowNo) {
		int sum=0;
		for(int i=0; i<m[rowNo].length;i++) if(m[rowNo][i]==1) sum++;
		return sum%2==0;
	}
	
	public static boolean checkColumn(int[][] m, int colNo) {
		int sum=0;
		for(int i = 0; i<m.length;i++) if(m[i][colNo]==1) sum++;
		return sum%2==0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[][] array= new int[6][6];
			for(int i=0;i<6;i++) for(int j=0;j<6;j++) array[i][j]=(int) (Math.random()*2);
			print(array);
			
			for(int i=0;i<6;i++) {
				if(checkColumn(array,i)) System.out.println("Column " +i +" has even number of ones");
				else System.out.println("Column " +i +" has not even number of ones");
				if(checkRow(array,i)) System.out.println("Row " +i +" has even number of ones");
				else System.out.println("Row " +i +" has not even number of ones");
			}
	}

}

