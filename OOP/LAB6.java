/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author ciit
 */
public class LAB6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = "COMSATS-university";
        System.out.println(name);  //printing name== COMSATS university
        int count = name.length(); //length of Name
        System.out.println("Length = " +name.length());
        int i=0; //index
        while(i<count){
            System.out.print(name.charAt(i));
            i++;
        }
        System.out.println("\ni  = "+i);
        
        while (i>0){
            i--;
            System.out.print(name.charAt(i));
        }
        //i == 0
        System.out.println("");
        
        while(i<count){
                if( name.charAt(i) != '-'){
                    System.out.print(name.charAt(i));
                    i++;
                                            }
                else{
                    break;
                    }    
           
            
                     }
        System.out.println("");
        i=0;
        while(i<count){
                if( name.charAt(i) != '-'){
                    System.out.print(name.charAt(i));
                    i++;
                                           }
                else{
                    i++;
                    continue;
                    
                    } 
                
           
            
                     }
//////// MERA METHOD
        
        i=0;
        System.out.println("");
        while(i<count){
                if( name.charAt(i) == '-'){
                    i++;
                    while(i<count){
                        
                        System.out.print(name.charAt(i));
                        i++;
                    }
                   
                                           } 
                  i++;
                     }
        System.out.println("");
        
        /////////////
        
        /// Sir ka method
       boolean flag  = false;
       i=0;
       while(i<count){
           if(name.charAt(i)=='-'){
               flag = true;
               i++;
           }
           
           if (flag==true){
               System.out.print(name.charAt(i));
           }
           i++;
       }
       
        System.out.println("");
       ///Rabia ka method
       
       i=0;
       while (name.charAt(i)!='-'){
           System.out.print(name.charAt(i));
           i++;
       }
        
        
    }
}
