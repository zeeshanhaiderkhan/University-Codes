package libManSys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test2 {
	
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
	
	
	//target has s
	public static boolean hasThis(String target, String s) {
		return target.contains(s);
	}
	
	public static void rSearch(File file,String s) throws FileNotFoundException {
		s=s.toLowerCase();
		Scanner input = new Scanner(file);
		
		
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
						System.out.print("\t");
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
	
public static void editRecord(File file,String s) throws FileNotFoundException {
	s=s.toLowerCase();
	Scanner input = new Scanner(file);
	
	
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
					System.out.print("\t");
				}
				
				else {
						System.out.print(line.charAt(i));
					}
				
				//
				
				
			}	
			System.out.println();
		}
	}
	input.close();	
}

	

//}
/*public static void appendToSpecificLine(File file,int line,String s) throws IOException {
	Scanner input = new Scanner(file);
	FileWriter fw = new FileWriter(file, true);
	
	int i=0;
	int where=0;
	while(input.hasNext()) {
		String lineT=input.nextLine();
		where+=lineT.length();
		i++;
		if(i==line) {
			
			
		}
	}
	input.close();
	fw.close();
	
}*/
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	/*File file=new File("test.txt");
	
	//rSearch(file,"fa");
	///edit
	//appendToSpecificLine(file,2,"test");
	FileWriter fw = new FileWriter(file, true);
	PrintWriter pw=new PrintWriter(fw);
	
	
	
	fw.close();*/
		
		
	
	}

}
