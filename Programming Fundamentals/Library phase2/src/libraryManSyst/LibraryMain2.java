package libraryManSyst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class LibraryMain {
	
	
	public static boolean isName(String name) {
		if(name.length()==0) return false;
		for(int i=0;i<name.length();i++) {
			if(!((name.charAt(i)<='Z' && name.charAt(i)>='A') || (name.charAt(i)<='z' && name.charAt(i)>='a') || name.charAt(i)==' ' )) return false;
		}
		return true;
	}
	public static boolean isCNIC(String id) {
		if(id.length()==15 && id.charAt(5)=='-' && id.charAt(13)=='-') {
			for(int i=0;i<15;i++) {if((!(id.charAt(i)>='0' && id.charAt(i)<='9') && ( i!= 5 && i!= 13 ))) return false;}
			return true;
		}
		else return false;
	}

	public static boolean isDateFormat(String date) {
		if(date.length()==10 && date.contains("/")) {
		try {
			String[] dateSplit=date.split("/");
			if(!(Integer.valueOf(dateSplit[0])>0 && Integer.valueOf(dateSplit[0])<32))   return false;
			if(!(Integer.valueOf(dateSplit[1])>0 && Integer.valueOf(dateSplit[1])<13))   return false;
			if(!(Integer.valueOf(dateSplit[2])>0))   return false;
			return true;
		}
		catch(Exception ex) {
			return false;
		}
		}
		else return false;
	 }
	public static boolean isPhone(String phone) {
		if(phone.length()==12) {
			for(int i=0;i<phone.length();i++) {
				
				if(i==4 && phone.charAt(4)!='-') return false;
				if(i==4 && phone.charAt(4)=='-') continue;
				else if(!(phone.charAt(i)>='0' && phone.charAt(i)<='9')) return false;
			}
			return true;
		}
		else if (phone.length()==11) {
			for(int i=0;i<phone.length();i++) {
				if(!(phone.charAt(i)>='0' && phone.charAt(i)<='9')) return false;
			}
			return true;
		}
		return false;
	}
	public static boolean isReg(String s) {
		//String mid= (s.charAt(5)+""+s.charAt(6)+""+s.charAt(7)).toLowerCase();
		
		if(s.length() != 12) return false;
		
		int mid2= s.charAt(5)+s.charAt(6)+s.charAt(7);
		int last= s.charAt(9)+s.charAt(10)+s.charAt(11);
		
		if(!((s.charAt(0)+""+s.charAt(1)).toLowerCase().equals("fa")  || 	(s.charAt(0)+""+s.charAt(1)).toLowerCase().equals("sp")))
				return false;
		else if (!(s.charAt(2) >= '0' && s.charAt(2)<='9') &&(s.charAt(3)>='0' && s.charAt(3)<='9')) return false;
		else if(s.charAt(4)!= '-' || s.charAt(8) != '-') return false;
		else if(!((mid2 >= 291 && mid2 <= 366) || (mid2 >= 195 && mid2 <= 270))) return false;
		else if(!(last>=144 && last <= 171)) return false;
		return true;
	}
	public static boolean isEmail(String s) {
		int test=0;
		int contLen=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='@') {
				test++;
				contLen=1;
			}
			if(s.charAt(i)=='.' && contLen==1) {
				test++;
				break;
			}
		}
		return  test==2;
	}
	//take input;
	static Scanner input= new Scanner(System.in);
	public static String enterForm(String what,int opt){
		String name;
		System.out.print("Enter "+what+": ");
		do {
			name=input.nextLine();
			if(((isName(name) && opt==1) || (isReg(name) && opt==2 ) || (isCNIC(name) && opt==3) || (isDateFormat(name) && opt==4) || (isPhone(name) && opt==6 ) || (isEmail(name) && opt==7)) ) break;
			else System.out.print("Opss! Enter Correct "+what+": ");
		}while(true);
		return name;
	}
	
	
	public static String generateLibNum(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		int rank;
		try{
		rank= input.nextInt();
		rank++;
		PrintWriter pw=new PrintWriter(file);
		pw.write(Integer.toString(rank));
		pw.close();
					
				}
		catch(Exception ex) {
			PrintWriter pw=new PrintWriter(file);
		
		pw.write(Integer.toString(rank=1));
		pw.close();
				}
		return String.valueOf(rank);
		}
	
	static Scanner kb= new Scanner(System.in);
	public static String currentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		   LocalDateTime now = LocalDateTime.now();  
		   return  dtf.format(now).toString();
	}
	
	
	public static void formAddStudent(File file,File tempLibNum) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);
		
		
		String[] dataStudent= new String[8];
		
		//System.out.print("Enter Full Name: ");
		dataStudent[1] = enterForm("Name",1);
		//System.out.print("Enter Registration No: ");
		dataStudent[2] = enterForm("Registration No (format: fa18-bse-001)",2).toUpperCase();
		//System.out.print("Enter CNIC: ");
		dataStudent[3]=enterForm("CNIC (format: 61101-1234567-8)",3);
		//System.out.print("Enter DOB: ");
		dataStudent[4] = enterForm("DOB (format: dd/mm/yyyy)",4);
		//DOJ
		dataStudent[5]=currentDate();
		
		dataStudent[6] =enterForm("Phone no. (format: 0123-1234567)",6);
		//System.out.print("Enter E-mail Address: ");
		dataStudent[7] = enterForm("E-mail (format: abc123@example.com)",7);
		
		dataStudent[0]="lib-"+generateLibNum(tempLibNum);
		
		for(int i=0;i<dataStudent.length;i++) pw.print(dataStudent[i]+",");
		pw.println("");
		System.out.println("NEW LIBRARY ID ISSUED:\nID : "+dataStudent[0]);
		pw.close();
		
	}
	public static String takeInputAsLine() {
		Scanner kb= new Scanner(System.in);
		String result=kb.nextLine();
		
		return result;
	}
public static void readLine(String text) {
		int i=0;int k=0;
		while(i<text.length()){
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
    	}
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

public static void editRecord(File file,String id,int fromChange,String toChange) throws IOException{
	//name=1,reg=2,cnic=3,dob=4,phone=6,email=7
	Scanner output=new Scanner(file);
	//temp file creation
	
	File tempFile = new File("tempFile.txt");
    if(tempFile.createNewFile()){
    }else System.out.print("");
    PrintWriter pwTemp=new PrintWriter(tempFile);
	while(output.hasNext()) {
		String line=output.nextLine();
		if(line.toLowerCase().contains(id.toLowerCase())) {
			String[] lineArray=line.split(",");
			lineArray[fromChange]=toChange;
			for(int i=0;i<lineArray.length;i++) pwTemp.print(lineArray[i]+",");
			pwTemp.println("");		
		}
		else pwTemp.println(line);
	}
	pwTemp.close();output.close();
	copyFileAToFileB(tempFile,file);
	
}
public static void readLineBook(String line){
	//bookId,name,Author,edition,genre
	 String[] splitLine=line.split(",");
	 System.out.print(splitLine[0]+"\t\t");
	 for(int i=0;i<35;i++) {
		 try {
			 System.out.print(splitLine[1].charAt(i));
		 }
		 catch (Exception ex) {
			 System.out.print(" ");
		 }
	 }
	 for(int i=0;i<30;i++) {
		 try {
			 System.out.print(splitLine[2].charAt(i));
		 }
		 catch (Exception ex) {
			 System.out.print(" ");
		 }
	 }
	 for(int i=3;i<splitLine.length;i++) {
		 System.out.print("\t\t"+splitLine[i]);
	 }
	 System.out.println();
}

	
	
	
	
	public static void searchRecord(File file,boolean searchFlag,String toSearch,boolean book) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		int countSearch=0;
		if(book) System.out.println("ID\t\tName\t\t\t\t   Author's Name\t\t\t\tEdition\t\tGenre");
		
		else	System.out.println("Lib#\t\tName\t\t\t Reg#\t\t\tCNIC\t\t\tDOB\t\t\tDOJ\t\t\tPhone#\t\t\tE-mail");
		System.out.println("============================================================================================================================================================================");
        while(input.hasNext()){
        	String text=input.nextLine();
        	if(text.length()==0) {
        		continue;
        		
        	}
        	if(searchFlag && text.toLowerCase().contains(toSearch.toLowerCase()) && !book) {
			        	readLine(text);
			        	countSearch++;
			        	System.out.println();
        				}
        	else if(searchFlag && text.toLowerCase().contains(toSearch.toLowerCase()) && book ) {
        		readLineBook(text);
        		countSearch++;
        	}
        }
        if(countSearch==0) System.out.println("No Such Record Found! ");
        input.close(); 
	}
	
	
	public static void formBook(File file) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		Scanner kb=new Scanner(System.in);
		String[] data=new String[5];
		System.out.print("Enter Book Name: ");
		data[1]=kb.nextLine();
		System.out.print("Enter Author Name: ");
		data[2]=kb.nextLine();
		System.out.print("Enter Edition: ");
		data[3]=kb.nextLine();
		System.out.print("Enter Category: ");
		data[4]=kb.nextLine();
		data[0]=(data[2].charAt(0)+""+data[2].charAt(1)+data[2].charAt(2)+data[1].charAt(0)+""+data[1].charAt(1)+data[1].charAt(2)+data[3].charAt(0)).toUpperCase();
		PrintWriter pw=new PrintWriter(fw);
		for(int i=0;i<5;i++) pw.print(data[i]+",");
		pw.println();
		System.out.println("Book ID ISSUED\n BookID : "+data[0]);
		pw.close();
	}
	
	public static int correctOption() {
		String opt="";
		boolean flag=true;
		while(true) {
			opt=input.nextLine();
			for(int i=0;i<opt.length();i++) {
				if(!(opt.charAt(i)>=0 && opt.charAt(i)<='9')) {
					flag=false;
					break;
				}
				
			}
			if(!flag) System.out.print(" Enter Correct Option: ");
			else break;
		}
		return Integer.valueOf(opt);
	}
	
	public static void main(String[] args) throws IOException {
		
		File memberFile=new File("D:\\Projects\\Pf Project\\members.txt");
		File bookFile=new File("D:\\Projects\\Pf Project\\Books.txt");
		File tempLibNum=new File("D:\\Projects\\Pf Project\\LibID.txt");
		int option;
		
		Scanner kb=new Scanner(System.in);
		System.out.println("=====================     ==      ==WELCOME TO LIBRARY==    ==     =======================");
		while(true) {//the most outer loop
			option=correctOption();
			
			System.out.print("1. Student Membership Record\n2. Books Catalogue\n3. Exit\n Choose One Option: ");//to edit menu
		
			if(option==3) {
				System.out.println("Bye");
				break;
			}
			if(option==1) {
				while(option!=5) {
					System.out.print("1. Add Student Record\n2. Edit Student Record\n3. View Student Records\n4. Search for Student Record\n5. Exit\n Choose One Option: ");
						option=kb.nextInt();
						if(option==1) formAddStudent(memberFile,tempLibNum);
						else if(option==2) {
							System.out.print("Enter Library ID: ");
							String id=takeInputAsLine();
							searchRecord(memberFile,true,id,false);
							System.out.println();
							while(option!=6) {
								System.out.print("1. Edit Name\t2. Edit Regist#\t3. Edit DOB\t4. Edit Phone\t5. Edit E-mail\t6.Exit\nChoose One Option: ");
								
								option=kb.nextInt();
								String toEdit;																		 
								
								if(option==1) { 
										toEdit=enterForm("New Name",1);
										editRecord(memberFile,id,1,toEdit);
										
								}
								if(option==2) { 
										toEdit=enterForm("New Registration No",2);
										editRecord(memberFile,id,2,toEdit);
										
								}
								if(option==3) { 
								
										toEdit=enterForm("New DOB",4);
										editRecord(memberFile,id,4,toEdit);
										
								}
								if(option==4) { 
										toEdit=enterForm("New Phone",6);
										editRecord(memberFile,id,6,toEdit);
										
								}
								if(option==5) {
										toEdit=enterForm("New Name E-mail",7);
										editRecord(memberFile,id,7,toEdit);
										
								
								}
							}
							
							
						}
						else if(option==3) 
							searchRecord(memberFile,true,"",false);
						else if(option==4) {
							//search
							System.out.print("1. Search by Name\n2. Search by Library ID\n3. Search by Reg#\n4. Search by Phone\n5. Search by E-mail\n Choose One Option: ");
							int lol=kb.nextInt();
							System.out.print("Enter :");
							String searchTemp=takeInputAsLine();
							searchRecord(memberFile,true,searchTemp,false);
							
						}
						
				}
			}
			
			else if(option==2) {
				while(option!=5) {
					System.out.print("1. Add Book Record\n2. Edit Book Record\n3. View Book Record\n4. Search Book\n5. Exit\n Choose One Option: ");
					option=kb.nextInt();
					if(option==1) {
						formBook(bookFile);
					}
					else if(option==2) {
						System.out.println("Enter BookID: ");
						String bookID=takeInputAsLine();
						searchRecord(bookFile,true,bookID,true);
						while(option!=5) {
							System.out.print("\n1. Edit Name\t2. Edit Author Name\t3. Edit Edition\t4. Edit Category\t5. Exit\nChoose One Option: ");
							
							option=kb.nextInt();
							String toEditB;																		 
							
							if(option==1) { System.out.print("Enter New Name: ");
									toEditB=takeInputAsLine();
									editRecord(bookFile,bookID,1,toEditB);
									
							}
							if(option==2) { System.out.print("Enter New Author: ");
									toEditB=takeInputAsLine();
									editRecord(bookFile,bookID,2,toEditB);
									
							}
							if(option==3) { System.out.print("Enter New Edition: ");
									toEditB=takeInputAsLine();
									editRecord(bookFile,bookID,3,toEditB);
									break;
							}
							if(option==4) { System.out.print("Enter New Category: ");
									toEditB=takeInputAsLine();
									editRecord(bookFile,bookID,4,toEditB);
									
							}
							
						}
						
					}
					
				}
				
				
			}
		
			
			
		
		
	}
	
	
//kb.close();
}
}
