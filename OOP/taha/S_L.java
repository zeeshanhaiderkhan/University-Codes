import  java.util.Random;
import java.util.Scanner;
public class S_L
{
    // instance variables - replace the example below with your own
    private  String p1;
    private  String p2;
    private  int score1;
    private  int score2;
    Scanner kb = new Scanner(System.in);
    /**
     * Constructor for objects of class S_L
     */
    public S_L()
    {
       score1 = 0;
       score2 = 0;
       p1 = " ";
       p2 = " ";
    }
    public S_L (String a, String b){
    set(a,b);
    }
    S_L (S_L x){
     p1 = x.p1;
     p2 = x.p2;
    }
    public void set (String a , String b){
     p1 = a;
     p2 = b;
     game();
     
    }
    public  String game(){
        while(true){
            if((score1 > 100 || score2 > 100)) break;
            System.out.println(p1 + "turn");
            score1 = score1 + generator();
            if(score1 == 6 || score1 == 55){
                score1 = ladder(score1);
            }
            else if(score1 == 35 || score1 == 99){
                score1 = snake(score1);
            }
            System.out.println("the score of " + p1 + "is " + score1);
            
            System.out.println(p2 + "turn");
            score2 = score2 + generator();
            if(score2 == 6 || score2 == 55){
             score2 = ladder(score2);
            }
            else if (score2 == 35 || score2 == 99){
             score2 = snake(score2);   
            }
            System.out.println("the score of " + p2 + "is " + score2);
         }
         if (score1 == 100){
             return p1;
            }
            else{
             return p2;   
            }
    }
    public static int ladder(int num){
        int a = num;
        if (a==6){
            a = a+11;
        }
        else if(a==55){
            a = a+20;
        }
        return a;
    }
    public static int snake(int num){
     int a = num;
     if(a==99){
         a = a-21;
        }
     else if (a == 35 ){
         a = a - 15;
        }
        return a;
    }
    public static int generator (){
        Random gener = new Random();
        int i , x=0;
        x = (gener.nextInt(6)+1);
        return x;
    }
}