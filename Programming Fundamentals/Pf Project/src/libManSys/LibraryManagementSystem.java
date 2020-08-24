package libManSys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LibraryManagementSystem {
	static Scanner kb= new Scanner(System.in);
	
		// student membership records
	////
	
	//add student record
	
		//isRegistrationNoCorrect
	
	
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
	
	//isEmailCorrect
	//checking if email is right
	
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
	
	// enter new member
	public static void formAddStudent(File file) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);
		
		
		String[] dataStudent= new String[6];
		System.out.print("Enter Full Name: ");
		dataStudent[0] = kb.nextLine();
		System.out.print("Enter Registration No: ");
		dataStudent[1] = kb.nextLine().toUpperCase();
		System.out.print("Enter CNIC: ");
		dataStudent[2]=kb.nextLine();
		System.out.print("Enter DOB: ");
		dataStudent[3] = kb.nextLine();
		System.out.print("Enter Phone number: ");
		dataStudent[4] = kb.nextLine();
		System.out.print("Enter E-mail Address: ");
		dataStudent[5] = kb.nextLine();
		
		
		
		for(int i=0;i<dataStudent.length;i++) pw.print(dataStudent[i]+",");
		pw.println("");
		pw.close();
	}
	
	//edit student data
/*	public static void editStudent(String name,File file) {
		
	}
	public static void editStudent(int reg)
	
	// view student records
	public static void edit
	*/
	public static void clearFile(File file) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(file);
		pw.print("");
		pw.close();
	}
	
	public static void main(String[] args) throws IOException {
		File file = new File("testB.txt");
		formAddStudent(file);
	}

}
