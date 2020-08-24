import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class LibraryMain {
	static Scanner input= new Scanner(System.in);
	static Scanner kb= new Scanner(System.in);
	
	// This method returns Number of Lines in a File
	public static int numberOfLines(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		int result=0;String line;
		while(input.hasNext()) {			//Loop Until All lines end
			line=input.nextLine();
			result++;
		}
		input.close();
		return result;
	}

	
	// This method is used to store all the lines in a file into array
		public static String[] storeLinesToArray(File file) throws FileNotFoundException {
					String[] result=new String[numberOfLines(file)];   // Creates a String array with length of number of lines in a file using Method ( numberOfLines(file));
					Scanner input = new Scanner(file); 
					String line;int count=0;			
					
						while(input.hasNext())			 //Loop Until All lines end
						{ 						
						line=input.nextLine();
						result[count++]=line;             //Stores line in Result Array
						}
						input.close();
						return result;					//returns array
		
		}
		
		
		
		public static long charLength(String str) {
		long result=0;
		for(int i=0;i<str.length();i++) result+=str.charAt(i);
		return result;
		}
		
//===============================================================================================================================================================================================================================================================
			//Bubble Sort Using Recursion
		//String a[] array which to Sort, n is number of lines in a file or number of items in that array, state is variable for split name from array items which are separated by commas
		//state=1 for name;; state=2 and id=1 for registration number sorting, and faSP is used for FAll and Spring
			public static void bubbleSort(String a[], int n,int state,int id,String faSP)
			{
			    // Base case
			    if (n == 1)
			        return;
			  
			    // One pass of bubble sort. After
			    // this pass, the largest element
			    // is moved (or bubbled) to end.
			    for (int i=0; i<n-1; i++) {//bookName=1, id==0, 1,0,""
			        if (id == 0 && ( a[i].split(","))[state].toLowerCase().charAt(0) > (a[i+1].split(","))[state].toLowerCase().charAt(0) ) // .toLowerCase().charAt(0) is used for first alphabet of name to sort
			        {
			            // swap a[i], a[i+1]
			            String temp = a[i];
			            a[i] = a[i+1];
			            a[i+1] = temp;
			        }
			        //for id =1
			        else if(id == 1 && a[i].toLowerCase().contains(faSP.toLowerCase()) && Integer.valueOf(specificString(((a[i].split(","))[state]),9,11)) > Integer.valueOf(specificString(((a[i+1].split(","))[state]),9,11)) ) { // this is used for sorting Fall and Spring
			        	String temp = a[i];
			            a[i] = a[i+1];
			            a[i+1] = temp;
			        }
			    }
			    // Largest element is fixed,
			    // recur for remaining array
			    bubbleSort(a, n-1,state,id,faSP);
			}
	
			// This method is used to check if a certain String is numeric or not; for in case of name where all letters are name
	public static boolean isName(String name) { 
		if(name.length()==0) return false;
		for(int i=0;i<name.length();i++) {
			if(!((name.charAt(i)<='Z' && name.charAt(i)>='A') || (name.charAt(i)<='z' && name.charAt(i)>='a') || name.charAt(i)==' ' )) return false;
		}
		return true;
	}
	
	
	//This method is used for checking if a String is CNIC or not with boundary conditions of dash..
	public static boolean isCNIC(String id) {
		if(id.length()==15 && id.charAt(5)=='-' && id.charAt(13)=='-') {
			for(int i=0;i<15;i++) {if((!(id.charAt(i)>='0' && id.charAt(i)<='9') && ( i!= 5 && i!= 13 ))) return false;}
			return true;
		}
		else return false;
	}
	
	//This method is used to test if A string is Valid Library ID with standard form of   "lib-a1"
	public static boolean isLibID(String id) {
		String[] idArray= id.split("-");
		boolean flag=true;
		if(idArray[0].equals("lib")) {
			if(idArray[1].charAt(0)>='a' && idArray[1].charAt(0)<='z' ) {
				for(int i=5;i<id.length();i++) {
					if(!(id.charAt(i)>='0' && id.charAt(i)<='9')) flag=false;
				}
				return flag;
			}
			else return false;
		}
		else return false;
	}
	
// This Method is used to enter a valid Library ID
	public static String enterLibID(File memberFile) throws FileNotFoundException {
		String id=kb.nextLine();
		if(isLibID(id) && !isUnique(memberFile, id)) return id;
		System.out.print("Enter Correct LibID: ");
		return enterLibID(memberFile);
	}

	//isDate Format method is used to check if a date is valid or not with format of dd/mm/yyyy
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
	
	//this method is used to check if a Phone number is valid  by two scenarios one with dash and other dashless
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
	
	//This method is used to check if Registration number is valid
	public static boolean isReg(String s) {
		
		
		if(s.length() != 12) return false;
		
		int mid2= s.charAt(5)+s.charAt(6)+s.charAt(7);
		int last= s.charAt(9)+s.charAt(10)+s.charAt(11);
		
		if(!((s.charAt(0)+""+s.charAt(1)).toLowerCase().equals("fa")  || 	(s.charAt(0)+""+s.charAt(1)).toLowerCase().equals("sp"))) // fa and spring
				return false;
		else if (!(s.charAt(2) >= '0' && s.charAt(2)<='9') &&(s.charAt(3)>='0' && s.charAt(3)<='9')) return false;
		else if(s.charAt(4)!= '-' || s.charAt(8) != '-') return false;
		else if(!((mid2 >= 291 && mid2 <= 366) || (mid2 >= 195 && mid2 <= 270))) return false;
		else if(!(last>=144 && last <= 171)) return false;
		return true;
	}
	
	// used for checking valid Email ,, not a good method still some flaws
	public static boolean isEmail(String s) {
		int test=0;
		int contLen=0;
		if(s.length()>40) return false;
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
	
	
	//This method used to return valid input form for instance for Wrong Registration number and CNIC and Vice Versa
	public static String enterForm(File file,String what,int opt) throws FileNotFoundException{
		String name;
		System.out.print("Enter "+what+": ");
		do {
			name=input.nextLine();
			if((isReg(name) && opt==3 && !isUnique(file,name)) ) System.out.println("This "+"Registration No"+" already Exists...");
			if((isCNIC(name) && opt==4 && !isUnique(file,name))) System.out.println("This CNIC No already Exists...");
			if(((isName(name) && name.length()<=40 && opt==1) || (isReg(name) && opt==3 && isUnique(file,name)) || (isCNIC(name) && opt==4 && isUnique(file,name)) || (isDateFormat(name) && opt==5) || (isPhone(name) && opt==7 ) || (isEmail(name) && opt==8) || (isGender(name) && opt==2) )) break;
			else System.out.print("Opss! Enter Correct "+what+": ");
		}while(true);
		return name;
	}
	
	// This method generates Library number 
	public static String generateLibNum(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		String line=input.nextLine();
		String intPart="";
		for(int i=1;i<line.length();i++) intPart+=(""+line.charAt(i));
		int intPartB=Integer.valueOf(intPart);
		intPartB++;
		char a=line.charAt(0);
		if(intPartB==10) {
			intPartB=0;
			a++;
		}
		PrintWriter pw= new PrintWriter(file);
		
		String newString=a+String.valueOf(intPartB);
		pw.write(newString);
		pw.close();
		return newString;
		}
	
	//This method returns current date in the form of String
	public static String currentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		   LocalDateTime now = LocalDateTime.now();  
		   return  dtf.format(now).toString();
	}
	
	//Returns true for male and female and for  else returns for basically for checking valid gender
	public static boolean isGender(String s) {
		if(s.toLowerCase().equals("m") || s.toLowerCase().equals("f")) {
			return true;
		}
		return false;
	}
	
	//This method is used for yes or no
	public static boolean isCorrect(String s) {
		if(s.toLowerCase().equals("y") || s.toLowerCase().equals("Y") || s.toLowerCase().equals("N") || s.toLowerCase().equals("n")) {
			return true;
		}
		return false;
	}	
	
	//This is whole form for Adding Students to Fills 
	public static void formAddStudent(File file,File tempLibNum) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);
		
		
		String[] dataStudent= new String[9];  				//Creates String array of length 9
		
		
		dataStudent[1] = enterForm(file,"Name",1);			// Takes name
		
		dataStudent[2]=enterForm(file,"Gender (m/f)",2).toUpperCase();		//Takes Gender
		dataStudent[3] = enterForm(file,"Registration No (format: fa18-bse-001)",3).toUpperCase();		//Takes valid Registration number

		dataStudent[4]=enterForm(file,"CNIC (format: 61101-1234567-8)",4);		//Takes valid CNIC

		dataStudent[5] = enterForm(file,"DOB (format: dd/mm/yyyy)",5);				//Takes valid DOB

		dataStudent[6]=currentDate();										//Stores current date for date of joining
		
		dataStudent[7] =enterForm(file,"Phone no. (format: 0123-1234567)",7);		// Takes valid phone number in both dash and dashless format

		dataStudent[8] = enterForm(file,"E-mail (format: abc123@example.com)",8);		//Takes valid Email
		
		dataStudent[0]="lib-"+generateLibNum(tempLibNum);							//Generates library  ID
		
		for(int i=0;i<dataStudent.length;i++) pw.print(dataStudent[i]+",");					//Stores data into File
		pw.println("");
		System.out.println("NEW LIBRARY ID ISSUED:\nID : "+dataStudent[0]);					//Shows Library ID
		pw.close();
		
	}
	
	//This method is basic and used for taking input as line
	public static String takeInputAsLine() {
		Scanner kb= new Scanner(System.in);
		String result=kb.nextLine();
		
		return result;
	}

	//This method is used to printing Data from Members List file.. It has its own format 
public static void readLine(String text) {
		String[]  textA=text.split(",");
		for(int i=0;i<textA.length;i++) {
			System.out.print(textA[i]);
			if(i==0) for(int j=textA[i].length();j<=15;j++) System.out.print(" ");
			else if(i==1) for(int j=textA[i].length();j<=45;j++) System.out.print(" ");
			else System.out.print("\t\t");
		}
	}

//This method is used to copy Files from and to Files
public static void copyFileAToFileB(File a,File b) throws FileNotFoundException {
	Scanner scA=new Scanner(a);
	PrintWriter pwB= new PrintWriter(b);
	while(scA.hasNext()) {
		String line=scA.nextLine();
		pwB.println(line);
	}
	scA.close();pwB.close();
}


//This is whole scenario for Editing a record
//This methods edits a record then stores it into second and again stores in original file
public static void editRecord(File file,String id,int fromChange,String toChange,boolean deleteFlag) throws IOException{
	
	Scanner output=new Scanner(file);					//name=1,reg=3,cnic=4,dob=5,phone=7,email=8
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
			if(deleteFlag) continue;
			else {for(int i=0;i<lineArray.length;i++) pwTemp.print(lineArray[i]+",");
			}
			pwTemp.println("");		
		}
		else pwTemp.println(line);
	}
	pwTemp.close();output.close();
	copyFileAToFileB(tempFile,file);
	
	
}

//=====================================
//Useo of Try and Catch
//==================================
//This method is used to print the format of Book Record Lines
public static void readLineBook(String line, File issuedBook) throws NumberFormatException, FileNotFoundException{
		try {		String[] lineArray=line.split(",");
				System.out.print(lineArray[0]+"      ");
				System.out.print(lineArray[1]);
				for(int i=lineArray[1].length();i<=50;i++) System.out.print(" ");
				System.out.print(lineArray[2]);
				for(int i=lineArray[2].length();i<=45;i++) System.out.print(" ");
				System.out.print(lineArray[3]);
				for(int i=lineArray[3].length();i<=20;i++) System.out.print(" ");
				System.out.print(lineArray[4]);
				for(int i=lineArray[4].length();i<=25;i++) System.out.print(" ");
				System.out.print(lineArray[5]);
				for(int i=lineArray[5].length();i<=16;i++) System.out.print(" ");
				if(bookStatus(issuedBook,lineArray[0],Integer.valueOf(lineArray[5]))) {
					System.out.println("Not Available");
				}
				else System.out.println("Available");
		}
		catch(Exception IndexOutOfBound) {
			System.out.println("No Such Index Found! Error in readLineBook Method!");
		}
				
	
	
}
// Returns true for book availability and false for unavail..
public static boolean bookStatus(File bookIssue,String bookID,int bookQuantity) throws FileNotFoundException {
	Scanner booksIssued=new Scanner(bookIssue);
	String line;
	int countQuant=0;	
	while(booksIssued.hasNext()) {
		line=booksIssued.nextLine();
		if(line.toLowerCase().contains(bookID.toLowerCase())) {
			countQuant++;
		}
	}
	booksIssued.close();
	return countQuant==bookQuantity; // used to check if quantity and issued matches
}
	
//This method is used to check if String is Unique in a file or not
// This is used mostly for validity of CNIC and Registration 
	public static boolean isUnique(File file,String id) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			String text=input.nextLine();
			if(text.toLowerCase().contains(id.toLowerCase())) {
				return false;
			}
		}
		return true;
		
	}
	
//Search recursion=========================================================================================================================================
	
			public static void rSearch(Scanner input,String id,String line,int infoBar,boolean book,File issuedBook) throws FileNotFoundException {//infoBar==1 member,infoBar==2 book
				if(infoBar==1) {//member
					System.out.println("ID           Name                                               Author's Name\\t\\t\\t\\t      Edition\\t\\t   Genre                     Quantity        Status");
					System.out.println("==============================================================================================================================================================================================================");
					infoBar=0;
				}
				else if(infoBar==2) {//book
					System.out.println("Lib#\\t\\tName\\t\\t\\t\\t\\t      Gender    Reg#  \\t\\t\\tCNIC\\t\\t\\tDOB\\t\\t\\tDOJ\\t\\t\\tPhone#\\t\\t\\tE-mail");
					System.out.println("==============================================================================================================================================================================================================");
					infoBar=0;
				}
				if(!input.hasNext()) {
					//input.close();
					if(infoBar!=9) System.out.println("No Such Record Found! \n\n");
					return;
				}
				line=input.nextLine();
				if(line.toLowerCase().contains(id.toLowerCase())) {
					if(book) 	readLineBook(line,issuedBook);
					else 	    readLine(line);
					System.out.println();   infoBar=9;
				}
				rSearch(input,id,line,infoBar,book,issuedBook);
			}
			
	
	// Search Standard====================================================================================================================================================
	public static void searchRecord(File file,boolean searchFlag,String toSearch,boolean book,File issuedBook) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		int countSearch=0;
		if(book) System.out.println("ID           Name                                               Author's Name\t\t\t\t      Edition\t\t   Genre                     Quantity        Status");
		
		else	System.out.println("Lib#\t\tName\t\t\t\t\t      Gender    Reg#  \t\t\tCNIC\t\t\tDOB\t\t\tDOJ\t\t\tPhone#\t\t\tE-mail");
		System.out.println("==========================================================================================================================================================================================================");
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
        		readLineBook(text,issuedBook);
        		countSearch++;
        	}
        }
        if(countSearch==0) System.out.println("No Such Record Found! \n\n");
        input.close(); 
	}

	//This method returns string of a number to take correct number input
public static String enterIntAsNumber() {
	String opt;
	while(true) {
		opt=input.nextLine();
		try {
			Integer.valueOf(opt);
			break;
		}
		catch(Exception ex){
			System.out.print("Enter Correct Number: ");
		}
		
	}
	return opt;
}	
// This method is used to add books to  a file
//======= use of try and catch
	public static void formBook(File file) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		try {		Scanner kb=new Scanner(System.in);
				String[] data=new String[6];
				System.out.print("Enter Book Name: ");
				data[1]=kb.nextLine();											//////
				System.out.print("Enter Author Name: ");
				data[2]=kb.nextLine();
				System.out.print("Enter Edition: ");
				data[3]=enterIntAsNumber();
				System.out.print("Enter Category: ");
				data[4]=kb.nextLine();
				System.out.print("Enter Quantity: ");
				data[5]=enterIntAsNumber();
				data[0]=(data[2].charAt(0)+""+data[2].charAt(1)+data[2].charAt(2)+data[1].charAt(0)+""+data[1].charAt(1)+data[1].charAt(2)+data[3].charAt(0)).toUpperCase();  // generate BookID by first three letters of author and other three of first three of book name and edition
				PrintWriter pw=new PrintWriter(fw);
				for(int i=0;i<6;i++) pw.print(data[i]+",");
				pw.println();
				System.out.println("Book ID ISSUED\n BookID : "+data[0]);
				pw.close();
		}
		catch(Exception IndexOutOfBound) {
			System.out.print("Index not Found! Error in formBook Method!");
		}
	}
	
// This method is used to add issued books to a file	
	public static void addIssued(File file,File check,File bookHistory,File memberFile,File bookFile) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw=new PrintWriter(fw);
		
		FileWriter fwB = new FileWriter(bookHistory, true);
		PrintWriter pwB=new PrintWriter(fwB);
		
		System.out.print("Enter BookID: ");
		String bookID=enterBookID(bookFile);														////
		System.out.print("Enter Library ID: ");
		String libID=enterLibID(memberFile);
		searchRecord(check,true,bookID,true,file);
		System.out.println("This Book has Been issued to "+linearSearch(memberFile,libID,1));
		
		pw.print(bookID+","+libID+","+currentDate());
		pwB.print(bookID+","+libID+","+currentDate());
		pw.println();pwB.println();
		pw.close();fw.close();
		pwB.close();fwB.close();
	}
	
//This method is used throughtout the program it is used to test if option is correct	
//============= use of try and catch
	public static int correctOption() {
		String opt;
		while(true) {
			opt=input.nextLine();
			try {
				Integer.valueOf(opt);
				break;
			}
			catch(Exception ex){
				System.out.print("Enter Correct Option: ");
			}
			
		}
		return Integer.valueOf(opt);
	}
	
	// This Method is used to print History of a Book
	public static void bookHistory(File file,File memberFile, String bookID) throws FileNotFoundException {
		Scanner output = new Scanner(file);
		while(output.hasNext()) {
			String line=output.nextLine();
			if(line.toLowerCase().contains(bookID.toLowerCase())) {
				String[] lineB = line.split(",");
				searchRecord(memberFile,true,lineB[1],false,file);
			}
			
			
		}
		output.close();
	}
	
	//Used to enter correct Choice
	public static String enterChoice() {
		while(true) {
			String choice=kb.nextLine();
			if((isCorrect(choice))) return choice.toLowerCase();
			else System.out.print("Enter Correct Choice: ");
		}
	}
	
	
	public static void main(String[] args) throws IOException {

		// creates file if not created
		File memberFile=new File("D:\\Projects\\Pf Project\\members.txt");
		 if(memberFile.createNewFile()){
		    }else System.out.print("");
		 
		File bookFile=new File("D:\\Projects\\Pf Project\\books.txt");
		 if(bookFile.createNewFile()){
		    }else System.out.print("");
		
		File tempLibNum=new File("D:\\Projects\\Pf Project\\LibID.txt");
		 if(tempLibNum.createNewFile()){
		   }else System.out.print("");
		 
		File issuedBook=new File("D:\\Projects\\Pf Project\\issued.txt");
		 if(issuedBook.createNewFile()){
		    }else System.out.print("");
		 
		File issuedBookHistory=new File("D:\\Projects\\Pf Project\\issuedBookHistory.txt");
		 if(issuedBookHistory.createNewFile()){
		    }else System.out.print("");
		 
		File returnBook=new File("D:\\Projects\\Pf Project\\return.txt");
		if(returnBook.createNewFile()){
		    }else System.out.print("");
		 
		File returnedBookHistory=new File("D:\\Projects\\Pf Project\\returnedBookHistory.txt");
		 if(returnedBookHistory.createNewFile()){
		    }else System.out.print("");
		
		 
		String choice;
		int option;
		Scanner memberScanner=new Scanner(memberFile);
		
		Scanner kb=new Scanner(System.in);
		System.out.println("=====================     ==      ==WELCOME TO LIBRARY==    ==     =======================");
		while(true) {//the most outer loop
			
			
			
			System.out.print("1. Student Membership Record\n2. Books Catalogue\n3. Issue || Return Book\n4. Exit\n Choose One Option: ");//to edit menu
			option=correctOption();
			if(option==4) {
				System.out.println("Exiting...");
				break;
			}
			if(option==1) {
				while(option!=6) {
					System.out.print("1. Add Student Record\n2. Edit Student Record\n3. Delete Record\n4. View Student Records\n5. Search for Student Record\n6. Exit\n Choose One Option: ");
						option=correctOption();
						if(option==1) {
							while(true) {
								formAddStudent(memberFile,tempLibNum);
								System.out.print("Do You Want to Add Another Student? Enter Y/N : ");
								choice=enterChoice();
								if(choice.equals("n")) break;
							}
							 
							
						}
						else if(option==2) {
							System.out.print("Enter Library ID: ");
							String id=enterLibID(memberFile);
							
							boolean idExists=!isUnique(memberFile,id);
							
							searchRecord(memberFile,true,id,false,issuedBook);
							while(option!=7 && idExists) {
								System.out.print("1. Edit Name\t2. Edit Gender\t3. Edit Reg#\t4. Edit DOB\t5. Edit Phone\t6. Edit E-mail\t7.Exit\nChoose One Option: ");
								
								option=correctOption();
								String toEdit;																		 
								
								if(option==1) { 
										toEdit=enterForm(memberFile,"New Name",1);
										editRecord(memberFile,id,1,toEdit,false);
										
								}
								if(option==2 ) {
									toEdit=enterForm(memberFile,"Gender",2);
									editRecord(memberFile,id,2,toEdit,false);
								}
								if(option==3) { 
										toEdit=enterForm(memberFile,"New Registration No",3).toUpperCase();
										editRecord(memberFile,id,3,toEdit,false);
										
								}
								if(option==4) { 
								
										toEdit=enterForm(memberFile,"New DOB",5);
										editRecord(memberFile,id,5,toEdit,false);
										
								}
								if(option==5) { 
										toEdit=enterForm(memberFile,"New Phone",7);
										editRecord(memberFile,id,7,toEdit,false);
										
								}
								if(option==6) {
										toEdit=enterForm(memberFile,"New Name E-mail",8);
										editRecord(memberFile,id,8,toEdit,false);
										
								
								}
							}
							
							
						}
						
						////delete
						
						else if(option==3) {
							searchRecord(memberFile,true,"",false,issuedBook);
							System.out.print("Enter LibID: ");
							String del=enterLibID(memberFile);
							searchRecord(memberFile,true,del,false,issuedBook);
							editRecord(memberFile,del,1,"",true);
						}
						
						
						else if(option==4) {
							while(option!=3) {
								String[] mems=storeLinesToArray(memberFile);
								System.out.print("1. Sorted via Lib-No\n2. Sorted Via Name\n3. Exit\n Choose One Option: ");
								memberScanner=memberScanner.reset();
								option=correctOption();
								if(option==1) {
									searchRecord(memberFile,true,"",false,issuedBook);
									System.out.println("Total Number of Members: "+numberOfLines(memberFile));
								}
								
								else if(option==2) {
									System.out.println("Lib#\t\tName\t\t\t\t\t      Gender    Reg#  \t\t\tCNIC\t\t\tDOB\t\t\tDOJ\t\t\tPhone#\t\t\tE-mail\n=================================================================================================================================================================================================================");
											bubbleSort(mems,numberOfLines(memberFile),1,0,"");
											readMultipleLines(mems);
											System.out.println("Total Number of Members: "+numberOfLines(memberFile));
											
									}
							
								//
								
								
							}
							//System.out.print("1. Sorted via Lib-No\n2. Sorted Via Name\n3. Sorted Via Reg# Fall\4.Sorted Via Reg# Spring\n5. Exit");


							
							
						}
						else if(option==5) {
							//search
							System.out.print("Search by any Keyword:  ");
							String searchTemp=takeInputAsLine();
							searchRecord(memberFile,true,searchTemp,false,issuedBook);
							
						}
						
				}
			}
			
			else if(option==2) {
					
							while(option!=6) {
								System.out.print("1. Add Book Record\n2. Edit Book Record\n3. Delete Book Record\n4. View Book Record\n5. Search Book\n6. Exit\n Choose One Option: ");
								option=correctOption();
								if(option==1) {
									formBook(bookFile);
								}
								else if(option==2) {
									System.out.println("Enter BookID: ");
									String bookID=takeInputAsLine();
									
									searchRecord(bookFile,true,bookID,true,issuedBook);
									while(option!=5) {
										if(isUnique(bookFile,bookID)) break;
										System.out.print("\n1. Edit Name\t2. Edit Author Name\t3. Edit Edition\t4. Edit Category\t5. Exit\nChoose One Option: ");
										
										option=correctOption();
										String toEditB;																		 
										
										if(option==1) { System.out.print("Enter New Name: ");
												toEditB=takeInputAsLine();
												editRecord(bookFile,bookID,1,toEditB,false);
												
										}
										if(option==2) { System.out.print("Enter New Author: ");
												toEditB=takeInputAsLine();
												editRecord(bookFile,bookID,2,toEditB,false);
												
										}
										if(option==3) { System.out.print("Enter New Edition: ");
												toEditB=enterIntAsNumber();
												editRecord(bookFile,bookID,3,toEditB,false);
												//break;
										}
										if(option==4) { System.out.print("Enter New Category: ");
												toEditB=takeInputAsLine();
												editRecord(bookFile,bookID,4,toEditB,false);
												
										}
										
									}
									
								}
								else if(option==3) {
									searchRecord(bookFile,true,"",true,issuedBook);
									System.out.print("Enter BookID: ");
									String delB=takeInputAsLine();
									searchRecord(bookFile,true,delB,true,issuedBook);
									editRecord(bookFile,delB,1,"",true);
								}
								else if(option==4) {
									
									option=0;
									while(option!=4) {
										System.out.print("1. Sorted Via Date of Addition\n2. Sorted Via Book Name\n3. Sorted Via Author Name\n4. Exit\n Choose One Option:");
										option=correctOption();
										if(option==1) searchRecord(bookFile,true,"",true,issuedBook);
										else if(option==2) {
											System.out.println("ID           Name                                               Author's Name\t\t\t\t      Edition\t\t   Genre                     Quantity        Status\n==========================================================================================================================================================================================================");
											String[] books=storeLinesToArray(bookFile);
											bubbleSort(books,numberOfLines(bookFile),1,0,"");
											readMultipleBookLines(books,issuedBook);
											
											
										}
										else if(option==3) {
											System.out.println("ID           Name                                               Author's Name\t\t\t\t      Edition\t\t   Genre                     Quantity        Status\n==========================================================================================================================================================================================================");
												String[] books=storeLinesToArray(bookFile);
												bubbleSort(books,numberOfLines(bookFile),2,0,"");
												readMultipleBookLines(books,issuedBook);
												
											
										}
									}
									
								}
								else if(option==5) {
									System.out.print("Search By Anykeyword: ");
									String sBook=takeInputAsLine();
									searchRecord(bookFile,true,sBook,true,issuedBook);
								}
								
							}
							
				
			}
			else if(option==3) {
				
				
						while(option!=7) {
							System.out.print("\n1. Add Issued Books Record\n2. Edit Issued Books Record\n3. View Currently Issued Books\n4. Add Returned Book\n5. View Book History\n6. Search Book Current Status\n7. Exit\n Choose One Option: ");
							option=correctOption();
						if(option==1) {//1. Add Issued Books Record
							addIssued(issuedBook,bookFile,issuedBookHistory,memberFile,bookFile);
						}
						else if(option==2) {//Edit Issued Books
							System.out.print("Enter BookID: ");
							String issuedBookSearch=enterBookID(issuedBook);
							searchRecord(bookFile,true,issuedBookSearch,true,issuedBook);
							System.out.print("Enter New LibraryID: ");
							String libIDcheck=enterLibID(memberFile);
							editRecord(issuedBook,issuedBookSearch,1,libIDcheck,false);
							System.out.println("The BookID: "+issuedBookSearch+" is now issued to : "+ linearSearch(memberFile,libIDcheck,1));
						}
						else if(option==3) {
							viewCurrentlyIssued(issuedBook,memberFile,bookFile);
							if(isUnique(issuedBook,"lib")) System.out.println("No Books Issued Yet!");
						}
						else if(option==4) {
							returnBook(returnBook,issuedBook,memberFile,bookFile,returnedBookHistory);
							System.out.println("This Book is Returned Successfully!");
						
							
						}
						
						if(option==5) {
							viewBooksHistory(issuedBookHistory,returnedBookHistory, bookFile,memberFile);
						}
						if(option==6) {
							System.out.print("Enter BookID: ");
							String issuedHistory=enterBookID(bookFile);
							searchRecord(bookFile,true,issuedHistory,true,issuedBook);
							System.out.println("\n\t\t\t\t ====================== This Book is Issued By ====================== ");
							bookHistory(issuedBook,memberFile, issuedHistory);
							if(isUnique(issuedBook,issuedHistory)) System.out.println("						       Never Issued By Anyone");
							
						}
				
						
					}
					
					
					
			}
			
		
			
			
		
		
	}
	
	
//kb.close();
		memberScanner.close();
}
	public static String linearSearch(File file,String id,int indexRetrieve) throws FileNotFoundException {//index of name=1...
		Scanner input=new Scanner(file);
		while(input.hasNext()) {
			String line=input.nextLine();
			if(line.toLowerCase().contains(id.toLowerCase()))
			{	try {
				String[] lineSplit = line.split(",");
				input.close();							//try
				return lineSplit[indexRetrieve];
					}
				catch(Exception IndexOutOFBound) {
					return null;
				}
			}
		}
		input.close();
		return null;
	}
	
	public static void printLineCurrenltyIssued(String line) {
		String[] lineSplit=line.split(",");
		System.out.print(lineSplit[0]+"\t\t");
		System.out.print(lineSplit[1]);
		for(int i=lineSplit[1].length();i<=50;i++) System.out.print(" ");
		System.out.print(lineSplit[2]+"\t\t");
		System.out.print(lineSplit[3]);
		for(int i=lineSplit[3].length();i<=45;i++) System.out.print(" ");
		System.out.print(lineSplit[4]);
		
	}
	public static void viewCurrentlyIssued(File issuedBook,File memberFile, File booksFile) throws FileNotFoundException {
		String[] arrayIssuedLines = storeLinesToArray(issuedBook);
		System.out.println("BookID\t\tBook Name\t\t                           LibID\t\tIssued By(Name) \t\t              DO.Issue");
		System.out.println("========================================================================================================================================================================");
		
		for(int i=0;i<arrayIssuedLines.length;i++) {
			String[] splitIssued = arrayIssuedLines[i].split(",");
			String text = splitIssued[0]+","+linearSearch(booksFile,splitIssued[0],1)+","+splitIssued[1]+","+linearSearch(memberFile,splitIssued[1],1)+","+splitIssued[2];
			printLineCurrenltyIssued(text);
			System.out.println();
		}
		
		
	}
	public static String specificString(String str,int startIndex,int endIndex) {
		String result="";
		for(int i=startIndex;i<=endIndex;i++) {
			result+=(""+str.charAt(i));
		}
		return result;
	}
	
	public static String searchLine(File file,String lineToSearch,int opt) throws FileNotFoundException {//0 line,1 name
		Scanner search=new Scanner(file);
		String line;
		while(search.hasNext()) {
			line=search.nextLine();
			if(opt>0 && line.toLowerCase().contains(lineToSearch.toLowerCase())) {
				String[] lineSplit=line.split(",");
				search.close();
				return lineSplit[opt];
			}
			if(line.equalsIgnoreCase(lineToSearch) && opt==0) {
				search.close();
				return line;
			}
		}
		search.close();
		return null;
		
	}
public static void readLineBooksHistory(String line) {
	String[] lineSplit = line.split(",");
	System.out.print(lineSplit[0]+"\t\t");
	System.out.print(lineSplit[1]);
	for(int i=lineSplit[1].length();i<=50;i++) System.out.print(" ");
	System.out.print(lineSplit[2]+"\t\t");
	System.out.print(lineSplit[3]);
	for(int i=lineSplit[3].length();i<=45;i++) System.out.print(" ");
	System.out.print(lineSplit[4]+"\t\t");
}

	public static void viewBooksHistory(File issuedBookHistory,File returnedBookHistory, File  books,File members) throws FileNotFoundException{
		System.out.println("BookID\t\tBook Name\t\t\t\t\t   Member libID\t\tMember Name\t\t\t\t      DO.Issue\t\t        DO.Return");
		System.out.println("===============================================================================================================================================================================");
		Scanner issuedBookHist=new Scanner(issuedBookHistory);
		Scanner returnedBookHist=new Scanner(returnedBookHistory);
		String newText;
		if(isUnique(issuedBookHistory,"lib")) System.out.println("No Record!");
		else {
			while(issuedBookHist.hasNext()) {
				String line=issuedBookHist.nextLine();
				//15
				String[] lineSplit=line.split(",");
				newText=lineSplit[0]+","+searchLine(books,lineSplit[0],1)+","+lineSplit[1]+","+searchLine(members,lineSplit[1],1)+","+lineSplit[2];
				//System.out.print(lineSplit[0]+"\t\t"+searchLine(books,lineSplit[0],1)+"\t\t\t\t"+lineSplit[1]+"\t\t\t"+searchLine(members,lineSplit[1],1));
				//System.out.print("\t\t\t\t"+lineSplit[2]+"\t\t");
				readLineBooksHistory(newText);
				if(isUnique(returnedBookHistory,specificString(line,0,14))) System.out.println("Not Returned Yet!");
				else System.out.println(searchLine(returnedBookHistory,specificString(line,16,24),2));
				
			}
			
		}
		
	}
	public static boolean isBookID(String id,File bookFile) throws FileNotFoundException {
		
		if(id.length()==7) {
			if(id.charAt(6)>='0' && id.charAt(6)<='9' && !isUnique(bookFile,id)) return true;
		}
		return false;
	}
	public static String enterBookID(File bookFile) throws FileNotFoundException {
		String id=kb.nextLine();
		id.split(",");
		if(isBookID(id,bookFile)) return id;
		System.out.print("Enter Correct BookID: ");
		return enterBookID( bookFile);
	}
	public static String enterLibIDb(File memberFile, File issuedBook) throws FileNotFoundException {
		String libID;
		while(true) {
			libID=enterLibID(memberFile);
			if(isUnique(issuedBook,libID)) {
				System.out.println("No book Issued to : "+libID);
				System.out.print("Enter Correct LibID: ");
			}
			else return libID;
		}
	}
	public static void returnBook(File returnFile,File issuedBook,File memberFile,File bookFile,File returnedBookHistory) throws IOException {
		FileWriter fw=new FileWriter(returnFile,true);
		PrintWriter pw=new PrintWriter(fw);
		
		FileWriter fwB=new FileWriter(returnedBookHistory,true);
		PrintWriter pwB=new PrintWriter(fwB);
		
		String libID;String bookID;
		while(true) {
			System.out.print("Enter LibID: ");
			libID=enterLibIDb(memberFile,issuedBook);			///no such book issued then??
			System.out.print("Enter BookID: ");
			bookID= enterBookID(bookFile);
			if( !isUnique(issuedBook,libID) && !isUnique(issuedBook,bookID) ) break;
			
		}
		pw.println(bookID+","+libID+","+currentDate());
		pwB.println(bookID+","+libID+","+currentDate());
		editRecord(issuedBook,libID,1,"",true);
		pw.close();fw.close();
		pwB.close();fwB.close();
		
	}
	public static void readMultipleLines(String[] mems) {
		for(int i=0;i<mems.length;i++) {
			readLine(mems[i]);
			System.out.println();
		}
	}
	public static void readMultipleBookLines(String[] mems,File issuedBook) throws NumberFormatException, FileNotFoundException {
		for(int i=0;i<mems.length;i++) {
			readLineBook(mems[i],issuedBook);
			
		}
	}
}
