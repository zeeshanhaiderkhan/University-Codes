package libraryManSyst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssignClass3Question3 {
	public static void showRank(File file,String gender,String name,int year) throws FileNotFoundException {
		try {
		Scanner fileScan= new Scanner(file);
		int rank=1;
		int count=0;
		
		
		while(fileScan.hasNext()) {  
			String line=fileScan.nextLine();
			if(line.toLowerCase().contains(name.toLowerCase())) {																																		
				System.out.println(name+" is ranked "+"#"+rank+" in Year "+""+year);
				count++;
			}
			rank++;		
		}
		fileScan.close();
		if(count==0) System.out.println("Result not Found");
	
	}
		catch(Exception ex){System.out.println("File not Found");
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner kb=new Scanner(System.in);
		System.out.print("Ente Year: ");
		int year=kb.nextInt();
		File file = new File(String.valueOf(year)+".txt");
		System.out.print("Enter Gender: ");
		String gender = kb.next();
		System.out.print("Enter Name: ");
		String name=kb.next();
		showRank(file,gender,name,year);
		
	}

}
