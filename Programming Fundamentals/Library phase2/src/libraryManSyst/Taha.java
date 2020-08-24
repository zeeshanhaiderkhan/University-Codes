package libraryManSyst;

import java.util.Scanner;

public class Taha {

	public static int[] checkrow(int[][] p1, int r, int j,int[] row) {
        if(j>5)
            return row ;
        //else{
            row[j]=p1[r][j];
           // System.out.println(j+""+r);
            //j+=1;
            checkrow(p1,r,j+1,row);
        
       // }
        return row;
    }
    
       public static int[] checkcolumn(int[][] p1, int c, int j,int[] column) {
        if(c==p1.length)
            return column ;
        else{
            column[c]=p1[c][j];
            //c+=1;
            //System.out.println(c+""+j);
            checkcolumn(p1,c+1,j,column);
        
        }
        return column;
    }
       
       public static void print(int[] a) {
   		for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
   		System.out.println();
   	}
       
       
	static Scanner kb = new Scanner(System.in);
	
	public static long factorial(int n) {
		if(n==0) return 1;
		return n*factorial(n-1);
	}
	public static void main(String[] args) {
		System.out.println(fibonacci(14));
}
	public static long fibonacci(int n) {
		if(n==0) {
			return 1;
		}
		if(n==1) return 1;
		
		return fibonacci(n-2)+fibonacci(n-1);
		}
	}
	
