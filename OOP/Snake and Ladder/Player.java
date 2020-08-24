import  java.util.Random;
public class Player{
    public int counter=1;
    public String name;
    
    public Player(){
        name="XYZ";
    }
    public Player(String n){
        name=n;
    }
    public boolean isEnd(){
        return counter>100;
    }
    
    public static int genRandom(){
        Random generator = new Random();
        return generator.nextInt(6)+1;
    }
    public void add(int n){
        counter+=n;
    }
    public void set(int n){
        counter =n;
    }
    
}