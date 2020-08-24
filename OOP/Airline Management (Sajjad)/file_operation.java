
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class  file_operation <T> implements Serializable{
public void write(String s,Object p){
    ObjectOutputStream out =null;

    try {
 // Read old objects
ArrayList<Object>StudentList = readAllData(s);

// Append new object into existing list
StudentList.add(p);

// Open Stream for writing
out = new ObjectOutputStream(new FileOutputStream(s));

// Write all objects (old and new one) into the file
for(int i = 0 ; i<StudentList.size() ; i++)
 {
	out.writeObject(StudentList.get(i));
}

}
catch(IOException exp)
 {
System.out.println("IO Exception while opening file");
}

 finally { 
// cleanup code which closes output stream if its object was created
try {
	if(out != null) {
		out.close();
		// flag of success
		
	}

} catch (IOException exp)
{
	System.out.println("IO Exception while closing file");
}






}}
public <T>ArrayList readAllData (String s)
{
  //  ArrayList initialized with size 0
ArrayList<T> StudentList = new ArrayList<T>(0);
// Input stream
ObjectInputStream inputStream = null;
try
{
// open file for reading
inputStream = new ObjectInputStream(new FileInputStream(s));
// End Of File flag
boolean EOF = false;
// Keep reading file until file ends

while(!EOF) 
{
try {
// read object and type cast into CarDetails object

T myObj = (T) inputStream.readObject();
// add object into ArrayList
StudentList.add(myObj);
//System.out.println("Read: " + myObj.getName());
} 
catch (ClassNotFoundException e) {
//System.out.println("Class not found");
} 
catch (EOFException end) {
// EOFException is raised when file ends
// set End Of File flag to true so that loop exits
EOF = true;
}
}
} catch(FileNotFoundException e) {
//System.out.println("Cannot find file");
} catch (IOException e) {
//System.out.println("IO Exception while opening stream");
//e.printStackTrace();
} finally { // cleanup code to close stream if it was opened
try {
if(inputStream != null)
inputStream.close( );
} catch (IOException e) {
// TODO Auto-generated catch block
System.out.println("IO Exception while closing file");
}
}
// returns ArrayList
return StudentList;
}
public void delete(String s,int p){
    ObjectOutputStream out =null;

    try {
 // Read old objects
ArrayList<Object>StudentList = readAllData(s);

// Append new object into existing list
StudentList.remove(p);

// Open Stream for writing
out = new ObjectOutputStream(new FileOutputStream(s));

// Write all objects (old and new one) into the file
for(int i = 0 ; i<StudentList.size() ; i++)
 {
	out.writeObject(StudentList.get(i));
}

}
catch(IOException exp)
 {
System.out.println("IO Exception while opening file");
}

 finally { 
// cleanup code which closes output stream if its object was created
try {
	if(out != null) {
		out.close();
		// flag of success
		
	}

} catch (IOException exp)
{
	System.out.println("IO Exception while closing file");
}





}}}