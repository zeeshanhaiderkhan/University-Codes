package libManSys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Raw {
	public static void searchRecord(File file,boolean searchFlag,String toSearch) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		System.out.println("Lib#\t\tName\t\t\t Reg#\t\t\tCNIC\t\t\tDOB\t\t\tDOJ\t\t\tPhone#\t\t\tE-mail");
		System.out.println("============================================================================================================================================================================");
        while(input.hasNext()){
        	String text=input.nextLine();
        	if(text.length()==0) {
        		continue;
        		
        	}
        	//int i=0;
        	//int k=0;
        	if(searchFlag && text.toLowerCase().contains(toSearch)) {
        	/*while(i<text.length()){
        		if(text.charAt(i)==',') {
        			if(k==1 ) {
		        			for(int j=0;j<=(30-i);j++) {
		        				System.out.print(" ");
		        				k++;
		        			}
		        			
        			}
        			
        			else {System.out.print("\t\t");
        			i++;
        			k++;
        			continue;
        			
        			}
        			
        								}
        		
        			else
        			System.out.print(text.charAt(i));
        		i++;
        	}*/
        	readLine(text);	
        	System.out.println();
        	
        }
        }
        
        input.close(); 
	}
}
	public static void showRecord(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		System.out.println("Lib#\t\tName\t\t\t\tReg#\t\t\tCNIC\t\t\tDOB\t\t\tDOJ\t\t\tPhone#\t\t\tE-mail");
		System.out.println("============================================================================================================================================================================");
        while(input.hasNext()){
        	String text=input.nextLine();
        	if(text.length()==0) {
        		continue;
        		
        	}
        	int i=0;
        	int k=0;
        	while(i<text.length()){
        		if(text.charAt(i)==',') {
        			if(k==1 ) {
		        			for(int j=0;j<=(30-i);j++) {
		        				System.out.print(" ");
		        				
		        			}
		        		k++;	
        			}
        			
        			else {System.out.print("\t\t");
        			i++;
        			continue;}
        			
        								}
        		
        			else
        			System.out.print(text.charAt(i));
        		i++;
        	}
        	System.out.println();
        	
        }
        
        input.close(); 
	}
	public static void editRecord(File file, String id) throws IOException {
		Scanner input = new Scanner(file);
		Scanner kb= new Scanner(System.in);
		File tempFile = new File("tempFile.txt");
        if(tempFile.createNewFile()){
        }else System.out.print("");

		
		//File tempFile = File.c
		PrintWriter pwTemp=new PrintWriter(tempFile);
		
		rSearch(file,id);
		//System.out.println("1. Edit Name\n2. Edit Registration no\n3. Edit DOB\n4. Edit All");
		int option=kb.nextInt();
		input.reset();
		if(option==1) {
			
			System.out.print("Enter New Name: ");
			
			String newName=takeInputAsLine();
			
			while(input.hasNext()) {
				
				String newLine=input.nextLine();
				
				String toAppend;
				String toConcat="";
					if(newLine.toUpperCase().contains(id.toUpperCase())) {
									int countComma=1;
									for(int i=0;i<newLine.length();i++) {
										if(newLine.charAt(i)==',' && countComma==1) {
												countComma++;
												for(int j=i;j<newLine.length();j++) {
													toConcat+=newLine.charAt(j);
												}
												break;
										}
									
									}
								toAppend=newName+toConcat;
								pwTemp.println(toAppend);
								}
					else {
						pwTemp.println(newLine);
					}
			}
		
		}
	public static void editRecordFinal(File file,String id) {
		search()
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String toSplit="1,2,3,4,5,6";
		String[] array=toSplit.split(",");
		for(int i=0;i<array.length;i++) System.out.print(array[i]);
	}

}
