import java.util.Scanner;

public class Series {
 public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
int r,end;
int n=kb.nextInt();	
r=1;
end=n;
while (r<=n) {
		System.out.print(r+"/"+end+" ");
		end--;
		r++;
		
		}
r=r-2;
end=2;
while(r>0){
	System.out.print(r+"/"+end+" ");
	r--;
	end++;
	   }
}}