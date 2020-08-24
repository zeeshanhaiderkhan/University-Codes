package assignment3;


public class Question6 {
	public static void print(long[] array) {
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	public static void print(long[][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static long min(long[] array) {
		long min=array[0];
		for(int i=0; i<array.length;i++) {
			if(array[i]<min) min=array[i];
		}
		return min;
	}
	public static long max(long[] array) {
		long max=array[0];
		for(int i=0; i<array.length;i++) {
			if(array[i]>max) max=array[i];
		}
		return max;
	}

	public static long[] sort(long[] unsorted) {
		long[] copyUnsorted=new long[unsorted.length];
		for(int i=0;i<copyUnsorted.length;i++) copyUnsorted[i]=unsorted[i]; 
		
		long[] arraySort=new long[unsorted.length];
		for(int i = 0 ;i < unsorted.length ; i++ ) {
			for(int j = 0 ; j < unsorted.length ; j++ ) {
				if(copyUnsorted[j]==min(copyUnsorted)) {
					arraySort[i]=copyUnsorted[j];
					copyUnsorted[j]=max(copyUnsorted)+1;// changing number to number bigger than list
					
					break;
				}
			}
		}
		
		return arraySort;
	}
	public static long[][] sortRows(long[][] unsorted){
		long[][] m=new long[unsorted.length][unsorted[0].length];
		for(int i=0;i<unsorted.length;i++) {
			m[i]=sort(unsorted[i]);
		}
		return m;
	}
	public static void main(String[] args) {
		
	long[][] m=new long[3][6];
	for(int i=0;i<m.length;i++) {
		for(int j=0;j<m[i].length;j++) {
			m[i][j]=(long)(Math.random()*100);
		}
	}
	System.out.println("Unsorted Array is: ");
	print(m);
	System.out.println("Sorted Array is: ");
	print(sortRows(m));
	}

}
