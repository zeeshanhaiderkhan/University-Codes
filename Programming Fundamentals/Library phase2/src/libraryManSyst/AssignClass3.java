package libraryManSyst;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AssignClass3 {

	public static void main(String[] args) throws IOException {
		File file= new File("Text_IO.txt");
		if(file.createNewFile()) {
        				System.out.println("New File Created!");
		}
		else System.out.println("File Already Exists! ");
		FileWriter fw = new FileWriter(file, true);

		PrintWriter pw = new PrintWriter(fw);
		for(int i=0;i<100;i++) pw.print(((int)(Math.random()*100))+" ");
		System.out.println("Done!");
		pw.close();
	}

}
