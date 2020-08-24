package libManSys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test {
	public static void writeToPosition(String filename, String data, long position) 
			  throws IOException {
			    RandomAccessFile writer = new RandomAccessFile(filename, "rw");
			    writer.seek(position);
			    writer.writeUTF(data);
			    writer.close();
			}
	public static String readFromPosition(String filename, long position) 
			  throws IOException {
			    String result = "";
			    RandomAccessFile reader = new RandomAccessFile(filename, "r");
			    reader.seek(position);
			    result = reader.readLine();
			    reader.close();
			    return result;
			}
	
	public static void rSearch(File file,String s) throws FileNotFoundException {
		s=s.toLowerCase();
		Scanner input = new Scanner(file);
		System.out.println("Name\t\t\t        Registration No.\tDOB");
		
		while(input.hasNext()) {
			String line= input.nextLine();
			int countComma=1;
			if(line.toLowerCase().contains(s)) {
				
				for(int i=0;i<line.length();i++) {
						
					if(line.charAt(i)==',' && countComma==1) {
							for(int j=0;j<(30-i);j++) {
		        				System.out.print(" ");
		        			}
							countComma++;
							continue;
						}
					
					else if(line.charAt(i)==',' && countComma != 1 ) {
						System.out.print("\t\t");
					}
					
					else {
							System.out.print(line.charAt(i));
						}
					
				}	
				System.out.println();
			}
		}
		input.close();
		
	}
	
/////no duplicatesssssssssss
	
public static void read(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		System.out.println("Name\t\t\t       Registration No.\t \tCNIC\t\t\tDOB\t\t\tPhone#\t\t\tE-mail");
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
        			if(k==0 ) {
		        			for(int j=0;j<=(30-i);j++) {
		        				System.out.print(" ");
		        				k++;
		        			}
		        			
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
	
	
	public static char[] copyArray(char[] a) {
		char[] result=new char[a.length];
		for(int i=0;i<a.length;i++) result[i]=a[i];
		return result;
	}
	

	public static void searchStudentByName(File file,String name) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		
		char[] cName=name.toLowerCase().toCharArray();
	
        while(input.hasNext()){
        	int countSearch=0;
        	char[] text  = (input.nextLine()).toLowerCase().toCharArray();
      
        	char[] textB = copyArray(text);
        	
        	int k = 0;
        	
        	for(int i=0;i<text.length;i++) {
        		if(cName[(i%name.length())]==text[i]) countSearch++;
        		if(countSearch==name.length()) break;
        	}
        	
        	if(name.length()==countSearch) {
        		int i=0;
        		while(i<textB.length){
        			if(textB[i]==',') {
        				if(k==0) {
		        			for(int j=0;j<=(30-i);j++) {
		        				System.out.print(" ");
		        			}
		        			k=1;
        						}
        				else System.out.print("\t");
        				
        				i++;
        				
        				continue;
        				
        									}
        				else
        				System.out.print(textB[i]);
        			i++;
        		}
        		System.out.println();
        	}
        	
        }
      
        input.close(); 
	}
	
public static void searchStudentByReg(File file,String id) {
	
}
	
//edit a record
	
	

	
	

	
	
	/*public static void readFromPosition(String filename)
				  throws IOException {
				String result="";
		
				RandomAccessFile reader = new RandomAccessFile(filename, "r");
			    reader.seek(0);
			    while()
			    result = reader.readLine();
			}*/
	public static void writeToFile(File file,String s) throws IOException {
		FileWriter fw=new FileWriter(file,true);
		BufferedWriter bw= new BufferedWriter(fw);
		
		bw.write(s);
		
		bw.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		
	File file = new File("testB.txt");
	read(file);
	//FileWriter fw=new FileWriter(file,true);
	//BufferedWriter writer=new BufferedWriter(fw);
	//System.out.println(readFromPosition("raw.txt",10));
	
	
	}

}
