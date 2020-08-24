package libraryManSyst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author MHM
 */
public class BINGOProject  {
   // private static Object dis;

    /**
     * @param args the command line arguments


     */
	public static void print(int[] a) {
		for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[]args) throws IOException {
    	/* int[] a= {0,0,0,0,0};
    	 int[] a= {0,0,0,0,1};
    	 int[] a= {0,0,0,1,0};
    	 int[] a= {0,0,1,0,0};
    	 int[] a= {0,1,0,0,0};
    	 int[] a= {1,0,0,0,0};*/
    //	 checkrow(int[][] p1, int r, int j,int[] row)
    	 
                 Scanner kb = new Scanner(System.in);
        boolean x = true;
        int score1 = 0, score2 = 0;
        while (x) {//MAIN MENU
            
            System.out.println("\t \t BINGO CARDS");
            System.out.println("===============================================");
            System.out.println(" 1.Start Game \n 2.Resume \n 3.Score Board \n 4.Exit");
            System.out.println("===============================================");            
            System.out.print("Enter Option ");
            int option = kb.nextInt();
            if (option <= 0 || option > 4) {
                while (option <= 0 || option > 4) {//this if statement checks that user has entered valid option 
                    System.out.println("Invalid Option ");
                    System.out.print("Select again ");
                    option = kb.nextInt();
                    continue;
                }
            }

            if (option == 1) {
                int[][] p1 = new int[5][5];   //player 1 bingo card
                int[][] p2 = new int[5][5];  //player 2 bingo card

                int result = game(p1, p2);
                System.out.println(result);
               //00 if (result == 0 ) {
                   // System.out.println("GAME PAUSE\n\n");
                //}
                if(result==1) {
                     System.out.println("player 1 wins");
                     score1++;
                }
                else if (result==2){
                     System.out.println("player 2 wins");
                     score2++;
                }
            } else if (option == 2) {
                int[][] p1 = new int[5][5];   //player 1 bingo card
                int[][] p2 = new int[5][5];  //player 2 bingo card
                File ps;
               // resume(p1,p2,ps);
             

            } else if (option == 3) { //display Score Board
                          score(score1,score2);
            
        }
           

    }
     }

    public static int[][] player1card(int[][] p1) {           //this function fills card of player 1
        Scanner kb = new Scanner(System.in);
        int x;
        System.out.println("Enter Player 1 card");
        try{
        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < p1[0].length; j++) {
                x = (int) (1 + Math.random() * 25);

               
                boolean b = unique_no(p1, x);

                if (x <= 0 || x > 25 || b == true) {                           //this if statement checks that entered number is within range and non-repeated
                    while ((unique_no(p1, x)) == true || x <= 0 || x > 25) {   //ensures that program gives error on every invalid input
                        System.out.println("Invalid Input ");
                        System.out.print("Enter again ");
                        x = (int) (1 + Math.random() * 25);
                        continue;
                    }
                    p1[i][j] = x;
                    continue;
                } else {
                    p1[i][j] = x;
                }
            }

        }

        //return p1;
    } catch(InputMismatchException e){
            System.out.println("Invalid input");
            x=kb.nextInt();
    }return p1;
    }

    public static int[][] player2card(int[][] p2) {  //this function fills card of player 2
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Player 2 card");
        int y = 0;
        try{
        for (int i = 0; i < p2.length; i++) {
            for (int j = 0; j < p2[0].length; j++) {
                y = (int) (1 + Math.random() * 25);
                boolean b = unique_no(p2, y);
                if (y <= 0 || y > 25 || b == true) { //this if statement checks that entered number is within range and non-repeated  
                    while ((unique_no(p2, y)) == true || y <= 0 || y > 25) {//ensures that program gives error on every invalid input
                        System.out.println("Invalid Input ");
                        System.out.print("Enter again ");
                        y = (int) (1 + Math.random() * 25);
                        continue;
                    }
                    p2[i][j] = y;
                    continue;
                } else {
                    p2[i][j] = y;
                }
            }
        }
        //return p2;
    }catch(InputMismatchException e){
            System.out.println("Invalid input");
            y=kb.nextInt();
    }return p2;
    }
    public static void printing(int[][] p1, int[][] p2) {    //this function dislays the cards
        System.out.println("Player 1 card");
        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < p1[0].length; j++) {
                System.out.print(p1[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Player 2 card");
        for (int i = 0; i < p2.length; i++) {
            for (int j = 0; j < p2[0].length; j++) {
                System.out.print(p2[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean unique_no(int[][] p1, int n) {    //this function checks if the value entered is not repeated
        boolean b = false;
        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < p1[0].length; j++) {
                if (p1[i][j] == n) {
                    b = true;
                }
            }
        }
        return b;
    }

    public static int[][] search(int[][] p1, int n) {   // this functon is used to cancel number from bingo card entered by user
        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < p1[0].length; j++) {
                if (p1[i][j] == n) {
                    p1[i][j] = 0;                      //entered number is replaced with zero
                }

            }
        }
        return p1;
    }

      public static int[] checkrow(int[][] p1, int r, int j,int[] row) {
        if(j>4)
            return row ;
        //else{
            row[j]=p1[r][j];
           // System.out.println(j+""+r);
            //j+=1;
            checkrow(p1,r,j+1,row);
        
       // }
        return row;
    }
    
       public static int[] checkcolumn(int[][] p1, int c, int j,int[] column) {
        if(c==5)
            return column ;
        else{
            column[c]=p1[c][j];
            //c+=1;
            //System.out.println(c+""+j);
            checkrow(p1,c+1,j,column);
        
        }
        return column;
    }
    
    public static int sum(int[] p1, int low, int sum){   // calculates sum of given array   
        if (low==p1.length)
            return sum;
        
        sum+=p1[low];
        return sum(p1,low+1,sum);
       
    }

    public static int game(int[][] p1, int[][] p2)  { // this fuction actually runs the game 
        Scanner kb = new Scanner(System.in);
        int count1 = 0, count2 = 0;
        p1 = player1card(p1);
        p2 = player2card(p2);

        printing(p1, p2);
        int result = 0;
        
        System.out.println("GAME STARTS NOW ");
                              //counts score for player 2
        while (count1<=5 && count2<=5) {   //loop continues until one of the player's score is five
        	 count1 = 0;                        //counts score for player 1
             count2 = 0; 
            System.out.print("Player 1 Enter number: ");
            int b1 , b2 , b3, b4;
            int n = kb.nextInt();
//            if(n==0){
  //              pause(p1,p2);
      //          break;
    //        }
            if (unique_no(p1,n)==false||n < 0 || n > 25) {  //this if statement checks that entered number is within range and not already cancelled
                while (unique_no(p1,n)==false||n < 0 || n > 25) {  //ensures program doesnt proceed further until valid input is given
                    System.out.println("Invalid Input ");
                     System.out.print("Enter again ");
                    n = kb.nextInt();
                    continue;
                }
            }
            p1 = search(p1, n);                    //the entered by player 1 is searched and cancelled in his own card
            p2 = search(p2, n);                          // and in plaer2 card too
            printing(p1, p2);                            // display cards to help players 

            for (int i = 0; i < 4; i++) {               //this loop ensures all columns and rows are checked
                int[] row= new int[p2.length];

                b1 = sum(checkrow(p1,i,0,row),0,0);
                print(checkrow(p1,i,0,row));
                b2 = sum(checkcolumn(p1,i,0,row),0,0);
                print(checkcolumn(p1,i,0,row));
                b3 = sum(checkrow(p2,i,0,row),0,0);
                print((checkrow(p2,i,0,row)));
                b4 = sum(checkcolumn(p2,i,0,row),0,0);
                print(checkcolumn(p2,i,0,row));
                
                
                if (b1 == 0) {                      //if all entries in a specific row of player1 card are cancelled then count1 is incremented by 1         
                    count1++;
                }
                if (b2 == 0) {                     //if all entries in a specific row of player1 card are cancelled then count1 is incremented by 1         
                    count1++;

                }
                if (b3 == 0) {                    //if all entries in a specific row of player2 card are cancelled then count2 is incremented by 1         
                    count2++;
                }
                if (b4 == 0) {                    //if all entries in a specific row of player2 card are cancelled then count2 is incremented by 1         
                    count2++;
                }
            }
            System.out.println("COUNT 1:  "+count1);
            System.out.println("COUNT 2:  "+count2);
            if (count1 == 5) {
                break;}
            //}//else
              //  //count1=0;

            if (count2 == 5) {
                break;
            }// else{
                //count2=0;
            //}

            System.out.print("Player 2 Enter number: ");
            n = kb.nextInt();
          //  if(n==0){
             //  pause(p1,p2);
              //  break;
            //}
            if (unique_no(p1,n)==false||n < 0 || n > 25) {  //this if statement checks that entered number is within range and not already cancelled
                while (unique_no(p1,n)==false||n < 0 || n > 25) {  //ensures program doesnt proceed further until valid input is given
                    System.out.println("Invalid Input ");
                    System.out.print("Enter again ");
                    n = kb.nextInt();
                    continue;
                }
            }
            p1 = search(p1, n);                    //the entered by player 1 is searched and cancelled in his own card
            p2 = search(p2, n);                          // and in plaer2 card too
            printing(p1, p2);                            // display cards to help players 

            for (int i = 0; i < 4; i++) {               //this loop ensures all columns and rows are checked
                int[] row= new int[p2.length];

                b1 = sum(checkrow(p1,i,0,row),0,0);
                b2 = sum(checkcolumn(p1,i,0,row),0,0);
                b3 = sum(checkrow(p2,i,0,row),0,0);
                b4 = sum(checkcolumn(p2,i,0,row),0,0);
                if (b1 == 0) {                      //if all entries in a specific row of player1 card are cancelled then count1 is incremented by 1         
                    count1++;
                }
                if (b2 == 0) {                     //if all entries in a specific row of player1 card are cancelled then count1 is incremented by 1         
                    count1++;

                }
                if (b3 == 0) {                    //if all entries in a specific row of player2 card are cancelled then count2 is incremented by 1         
                    count2++;
                }
                if (b4 == 0) {                    //if all entries in a specific row of player2 card are cancelled then count2 is incremented by 1         
                    count2++;
                }
            }

           /* if (count1 == 5) {
                continue;
            }

            if (count2 == 5) {
                continue;
            }*/
            System.out.println("COUNT 1:  "+count1);
            System.out.println("COUNT 2:  "+count2);
            if (count1 >= 5) {
                result++;
                break;
            }

           if (count2 >= 5) {
              result+=2;
              break;

           }

        }
        
        return result;
    }
    
    
    public static void pause(int[][] p1, int[][] p2) {
           try {
    PrintWriter writer = new PrintWriter(new File("Pausefile.txt"));
    writer.println("Player 1");
    for(int i=0; i<p1.length; i++){
        for(int j=0; j<p1[i].length; j++){
           //use this if your array has String
             writer.write(p1[i][j]+" "); //Its String so you dont have to use String.valueOf(something(int,double,...)
        }
       writer.println(); //leave one line 
    }
    writer.println();
    writer.println("Player 2");
     for(int i=0; i<p2.length; i++){
        for(int j=0; j<p2[i].length; j++){
           //use this if your array has String
             writer.write(p2[i][j]+" "); //Its String so you dont have to use String.valueOf(something(int,double,...)
        }
       writer.println(); //leave one line 
    }

    writer.flush();  //flush the writer
    writer.close();  //close the writer      



   } catch (FileNotFoundException e) {      
     e.printStackTrace();
   }


	}
    public static void resume(int[][] p1,int[][]p2, File Pausefile) throws IOException {
        
        BufferedReader br= new BufferedReader(new FileReader(Pausefile.getAbsolutePath()));
        boolean b=true;
        FileWriter fw= new FileWriter(Pausefile,true);
        BufferedWriter bw= new BufferedWriter(fw);
        while(b){
            String s=br.readLine();
            if(s==null){
                b=false;
                continue;
            }
            bw.write(s);
            bw.newLine();
        }
        
    }
         public static void score(int s1, int s2) throws IOException {
           try {
               File A=new File("Score.txt");
    BufferedWriter writer = new BufferedWriter (new FileWriter(A.getAbsoluteFile()));
    writer.write("Player 1"+"\t");
    writer.write("Player 2"+"\t");
    writer.write(s1+"\t");
    writer.write(s2+"\t");
    writer.write("\n");

    writer.flush();  //flush the writer
    writer.close();  //close the writer      



   } catch (FileNotFoundException e) {      
     e.printStackTrace();
   }


	}   
       }
