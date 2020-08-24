import  java.util.Random;
import java.util.Scanner;
public class Game
{
    Scanner kb= new Scanner(System.in);
    private String p1,p2;
    private int score1=0,score2=0, winner=0;

    
    public Game()
    {
        p1="";
        p2="";
        winner=0;
        score1=0;
        score2=0;
        
    }

    public Game(String player1, String player2){
        p1=player1;
        p2=player2;
    }
    
    Game(Game c){
       p1=c.p1;
       p2=c.p2;
    }
    
    public void set(String a, String b){
       p1=a;
       p2=b;
    }
  
    public  int generator()
        {
            Random gener = new Random();
            int i,x=0;
            x=(gener.nextInt(6)+1);
            
            return x ;   
        }
      
    public void start(Game a){
       System.out.println("Start Game");
       int count1=0,count2=0;
       while(true){
           count1=player1(a.p1);
           count2=player2(a.p2);
          
           
           if(count1==1){
              System.out.print("winner is player1");
              break;
            }
            else if(count2==2){
               System.out.print("winner is player2");
               break;
            }
          
        }
        
    }
    
    public int player1(String a){
        
        System.out.print(a+"'s turns=");
           int temp= generator();
           score1+=temp;
           
           if(score1==6){                        //ladder 
               score1+=11;
            }
           else if (score1==99){                 //snake
                score1-=21;
            }
            
           System.out.println(score1);
           
           if(score1==100){
               winner+=1;
            }
            
            return winner;
    }
        
    public  int player2(String b){
         System.out.print(b+"'s turns=");
           int temp= generator();
           score2+=temp;
           
            if(score2==6){                        //ladder
               score2+=11;
            }
           else if (score2==99){                 //snake
                score2-=21;
            }
            
           System.out.println(score2);
           
           if(score2==100){
               winner+=2;
            }
            
            return winner;
    }
    

}
