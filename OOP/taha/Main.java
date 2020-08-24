import java.util.Scanner;
public class Main{
    public static void Main(){
     Scanner kb = new Scanner (System.in);
     System.out.println("Welcome to Snakes and Ladders:");
     System.out.println("Enter the name of first player: ");
     String p1= kb.next();
     System.out.println("Enter the name of second player: ");
     String p2 = kb.next();
     System.out.println("Player 1 = " + p1 + "\n" + "Player 2 = " + p2 + "\n" + "Let's Start");
     
     S_L winner = new S_L(p1,p2);
    }
}