package libraryManSyst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Sal {
    public static void rank() throws FileNotFoundException{
        Scanner kb=new Scanner(System.in);
        System.out.print("Enter name: ");
        String name=kb.next();
        System.out.println("Year: ");
        int year =kb.nextInt();
    	File file = new File(year+".txt");
        Scanner reading=new Scanner(file);
        while(reading.hasNext()){
        int rank=reading.nextInt();
        String male=reading.next();
        int population_male=reading.nextInt();
        String female=reading.next();
        int population_female=reading.nextInt();
        if(male.equals(name) || female.equals(name)){
            System.out.println("the rank for the name "+name+" in the year "+year+" is "+rank);   
    }
        }
        reading.close();
    }

public static void main(String[] args) throws IOException {
	rank();
}

}
