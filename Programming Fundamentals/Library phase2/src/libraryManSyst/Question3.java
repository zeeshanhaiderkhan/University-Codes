package libraryManSyst;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalTime;

public class Question3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file= new File("Binary_Objects.dat");
		if(file.createNewFile()) {
        				System.out.println("New File Created!");
		}
		else {
			System.out.println("File Already Exists! ");
		}
		
		double[] array= {1.1,2.2,3.3,4.5};
		LocalTime time = LocalTime.now();
		String date=time.toString();
		int value=5;
		DataOutputStream output= new DataOutputStream(new FileOutputStream(file,true));
		for(int i=0;i<array.length;i++) output.writeDouble(i);
		output.writeInt(value);
		output.writeUTF(date);
		output.close();
		
		
		
		
	}

}
