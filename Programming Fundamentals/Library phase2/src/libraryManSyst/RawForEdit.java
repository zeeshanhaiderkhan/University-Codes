package libraryManSyst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RawForEdit {
/*	public static void readLine(String text) {
		int i=0;int k=0;
		while(i<text.length()){
    		if(text.charAt(i)==',') {
    			if(k==1 ) {
	        			for(int j=0;j<=(45-i);j++) {
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
	}  */
public static boolean isLibID(String id) {
	try {
	if(id.charAt(3)=='-') {
		String[] idArray=id.split("-");
		if(idArray.length!=2) return false;
		else if(!idArray[0].equalsIgnoreCase("lib")) return false;
		else if(true) {
			try {
				Integer.valueOf(idArray[1]);
				return true;
			}
			catch(Exception ex){
				return false;
			}
		}
	}
	}
	catch(Exception StringIndexOutOfBoundsException) {
		return false;
	}
	return false;
			
}

/*public static String enterLibID(String id) {
	if(isLibID(id)) return id;
	else {
		System.out.print("Enter Correct LibID: ");
		id=input.next();
	}
	return enterLibID(id);
}*/
public static String enterLibID() {
	String id=input.next();
	if(isLibID(id)) return id;
	System.out.print("Enter Correct LibID: ");
	return enterLibID();
}
	
	public static void readLine(String text) {
		String[]  textA=text.split(",");
		for(int i=0;i<textA.length;i++) {
			System.out.print(textA[i]);
			if(i==0) for(int j=textA[i].length();j<=15;j++) System.out.print(" ");
			else if(i==1) for(int j=textA[i].length();j<=45;j++) System.out.print(" ");
			else System.out.print("\t\t");
		}
	}
	
	public static String generateLibNum(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		int rank;
		try{
		rank= input.nextInt();System.out.println(rank);
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

	public static void searchRecord(File file,boolean searchFlag,String toSearch,boolean book) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		if(book) System.out.println("ID\t\tName\t\t\t\t   Author's Name\t\t\t\tEdition\t\tGenre");
		
		else	System.out.println("Lib#\t\tName\t\t\t Reg#\t\t\tCNIC\t\t\tDOB\t\t\tDOJ\t\t\tPhone#\t\t\tE-mail");
		System.out.println("============================================================================================================================================================================");
        while(input.hasNext()){
        	String text=input.nextLine();
        	if(text.length()==0) {
        		continue;
        		
        	}
        	if(searchFlag && text.toLowerCase().contains(toSearch) && !book) {
			        	readLine(text);	
			        	System.out.println();
        				}
        	else if(book) {
        		readLineBook(text);
        	}
        }
        
        input.close(); 
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
        
		//searchRecord(file,true,id);
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
	//61101-2172076-9
public static boolean isName(String name) {
	for(int i=0;i<name.length();i++) {
		if(!((name.charAt(i)<='Z' && name.charAt(i)>='A') || (name.charAt(i)<='z' && name.charAt(i)>='a') || name.charAt(i)==' ' )) return false;
	}
	return true;
}
public static boolean isCNIC(String id) {
	if(id.length()==15 && id.charAt(5)=='-' && id.charAt(13)=='-') {
		return true;
	}
	else return false;
}

public static boolean isDateFormat(String date) {
	if(date.length()==10 && date.contains("/")) {
		String[] dateSplit=date.split("/");
		if(!(Integer.valueOf(dateSplit[0])>0 && Integer.valueOf(dateSplit[0])<32))   return false;
		if(!(Integer.valueOf(dateSplit[1])>0 && Integer.valueOf(dateSplit[1])<13))   return false;
		if(!(Integer.valueOf(dateSplit[2])>0))   return false;
		return true;
	}
	else return false;
 }
public static boolean isPhone(String phone) {
	if(phone.length()==12) {
		for(int i=0;i<phone.length();i++) {
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
//take input;
static Scanner input= new Scanner(System.in);
public static String enterName(String what,int opt){
	String name;
	System.out.print("Enter "+what+": ");
	do {
		name=input.nextLine();
		if((isName(name) && opt==1) || (isReg(name) && opt==2 ) || (isCNIC(name) && opt==3) || (isDateFormat(name) && opt==4) || (isPhone(name) && opt==6 || ) || (isEmail(name) && opt==7)) return name;
		else System.out.print("Opss! Enter Correct "+what+": ");
	}while(!isName(name));
	return null;
}
//=====================================================================================================================================================
//Searching Data Recursively
public static void rSearch(Scanner input,String id,String line,int infoBar,boolean book) throws FileNotFoundException {//infoBar==1 member,infoBar==2 book
	if(infoBar==1) {//member
		System.out.println("ID           Name                                               Author's Name\t\t\t\t      Edition\t\t   Genre");
		System.out.println("==============================================================================================================================================================================================================");
		infoBar=0;
	}
	else if(infoBar==2) {//book
		System.out.println("Lib#\t\tName\t\t\t\t\t      Reg#\t\t\tCNIC\t\t\tDOB\t\t\tDOJ\t\t\tPhone#\t\t\tE-mail");
		System.out.println("==============================================================================================================================================================================================================");
		infoBar=0;
	}
	if(!input.hasNext()) {
		input.close();
		if(infoBar!=9) System.out.println("No Such Record Found! \n\n");
		return;
	}
	//line=input.nextLine();
	if(line.toLowerCase().contains(id.toLowerCase())) {
		if(book) 	readLineBook(line);
		else 	    readLine(line);
		System.out.println();   infoBar=9;
	}
	rSearch(input,id,line=input.nextLine(),infoBar,book);
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
	pw.close();
}
//public static void sort
public static void print(int[] a) {
	for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
	System.out.println();
}
public static void print1(String[] a) {
	for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
	System.out.println();
}

public static void bubbleSort(int[] a) {  
    boolean sorted = false;
    int temp;
    while(!sorted) {
        sorted = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                sorted = false;
            }
        }
    }
}

/*
public static void bubbleSort(String[] a) {  
    boolean sorted = false;
    String temp;
    while(!sorted) {
        sorted = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].toLowerCase().charAt(0) > a[i+1].toLowerCase().charAt(0)) {
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                sorted = false;
            }
        }
    }
}
*/
			public static int numberOfLines(File file) throws FileNotFoundException {
				Scanner input = new Scanner(file);
				int result=0;String line;
				while(input.hasNext()) {
					line=input.nextLine();
					result++;
				}
				input.close();
				return result;
			}


public static String[] storeLinesToArray(File file) throws FileNotFoundException {
	String[] result=new String[numberOfLines(file)];
	Scanner input = new Scanner(file);
	String line;int count=0;
	
	while(input.hasNext()) {
		line=input.nextLine();
		result[count++]=line;
	}
	input.close();
	return result;
}
public static long charLength(String str) {
	long result=0;
	for(int i=0;i<str.length();i++) result+=str.charAt(i);
	return result;
}
public static String specificString(String str,int startIndex,int endIndex) {
	String result="";
	for(int i=startIndex;i<=endIndex;i++) {
		result+=(""+str.charAt(i));
	}
	return result;
}

					public static void bubbleSort(String a[], int n,int state,int id,String faSP)// n= number of lines , name ka state 1 n= total number of lines,, id for opt to name aur anything else,, id=0 for names; state 2 id =1 for reg
					{
					    // Base case
					    if (n == 1)
					        return;
					  
					    // One pass of bubble sort. After
					    // this pass, the largest element
					    // is moved (or bubbled) to end.
					    for (int i=0; i<n-1; i++) {
					        if ((a[i].split(","))[state].toLowerCase().charAt(0) > (a[i+1].split(","))[state].toLowerCase().charAt(0) && id == 0)
					        {
					            // swap a[i], a[i+1]
					            String temp = a[i];
					            a[i] = a[i+1];
					            a[i+1] = temp;
					        }
					        //for id =1
					        else if(a[i].contains(faSP) && Integer.valueOf(specificString(((a[i].split(","))[state]),9,11)) >= Integer.valueOf(specificString(((a[i+1].split(","))[state]),9,11)) && id == 1) {
					        	String temp = a[i];
					            a[i] = a[i+1];
					            a[i+1] = temp;
					        }
					    }
					    // Largest element is fixed,
					    // recur for remaining array
					    bubbleSort(a, n-1,state,id,faSP);
					}

			/*		public static void bubbleSort(String a[], int n)
					{
					    // Base case
					    if (n == 1)
					        return;
					  
					    // One pass of bubble sort. After
					    // this pass, the largest element
					    // is moved (or bubbled) to end.
					    for (int i=0; i<n-1; i++)
					        if (a[i].toLowerCase().charAt(0) > a[i+1].toLowerCase().charAt(0))
					        {
					            // swap a[i], a[i+1]
					            String temp = a[i];
					            a[i] = a[i+1];
					            a[i+1] = temp;
					        }
					  
					    // Largest element is fixed,
					    // recur for remaining array
					    bubbleSort(a, n-1);
					}*/



public static void print(String[] a) {
	for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
	System.out.println();
}
public static void addIssued(File file) {
	FileWriter fw = new FileWriter(file, true);
	PrintWriter pw=new PrintWriter(fw);
	
	System.out.print("Enter BookID: ");
	String bookID=takeInputAsLine();
	System.out.print("Enter Library ID: ");
	String libID=enterLibID();
	searchRecord(file,true,bookID,true);
	System.out.print("This Book has Been issued to "+libID);
	
	pw.print(bookID+","+libID);
	pw.println();
	pw.close();
	fw.close();
}


public static void bookHistory(File file,String bookID) throws FileNotFoundException {
	Scanner output = new Scanner(file);
	while(output.hasNext()) {
		String line=output.nextLine();
		if(line.toLowerCase().contains(bookID)) {
			String[] lineB = line.split(",");
			searchRecord(memberFile,true,lineB[1],true);
		}
		
		
	}
}

	public static void main(String[] args) throws IOException {
		File file=new File("D:\\Projects\\Pf Project\\members.txt");
		Scanner input = new Scanner(file);
		//editRecord(file,"lib-2",6,"this is working");
		//formBook(file);
		//searchRecord(file,false,"",true);
		//editRecord(file,"MUKCHE1",2,"INDEED IT IS WORKING VER");
		//searchRecord(file,true,"lib-9",false);
		//String name=enterName();
		 //rSearch(input,""," " );
		 //input.close();
		//String text=enterLibID();
		// t// try catch
		//rSearch(input,"zzzzzzzzzzzzzzzzzzzzzzzz","",2,false);
		//System.out.println(isLibIDB("lib-ac"));
		//Sorting
		String[] mems=storeLinesToArray(file);
		bubbleSort(mems,numberOfLines(file),2,1,"FA");
		for(int i=0;i<4;i++) {
			readLine(mems[i]);
			System.out.println();
		}
		String reg="fa18-bse-103";
		System.out.println(specificString(reg,9,11));
		
	}
}