package libraryManSyst;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AssignClass3Question2 {

	public static void main(String[] args) throws IOException {
		File file= new File("Binary_IO.dat");
		if(file.createNewFile()) {
        				System.out.println("New File Created!");
		}
		else {
			System.out.println("File Already Exists! ");
		}
		
		FileOutputStream output =new FileOutputStream(file,true);
		for(int i=0;i<100;i++) output.write(((int)(Math.random()*100)));
		output.close();
	}
	

}
