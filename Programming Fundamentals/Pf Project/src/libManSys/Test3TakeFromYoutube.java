package libManSys;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test3TakeFromYoutube {
	
	
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
	public static void clearFile(File file) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(file);
		pw.print("");
		pw.close();
	}
	
	public static String takeInputAsLine() {
		Scanner kb= new Scanner(System.in);
		String result=kb.nextLine();
		kb.close();
		return result;
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
		
		
		//writing to original file
		pwTemp.close();
		kb.close();
		input.close();
		clearFile(file);
		//file to store
		File tempFileRev= new File("tempFile.txt");
		copyFileAToFileB(tempFileRev,file);
		
	}
	
	public static void copyFileAToFileB(File a,File b) throws FileNotFoundException {
		Scanner scA=new Scanner(a);
		PrintWriter pwB= new PrintWriter(b);
		while(scA.hasNext()) {
			String line=scA.nextLine();
			pwB.println(line);
		}
		scA.close();pwB.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file=new File("test.txt");
		editRecord(file, "FA18-bse-104");
	}

}
