import java.util.Scanner;
public class Game{
  
    int p; //number of players
    Player[] players;// array of players
    
    //arguments
    public Game(int players){
        p=players;
        gameLoop();
    }
    
    //default
    public Game(){
        p=2;
        gameLoop();
    }
    
    //if head return tail
    private int isHead(int h){
        for(Snake s : Snake.values()){
            if(s.head()==h) return s.tail();
        }
        return 0;
    }
    
    //if bottom return top
    private int isBottom(int b){
        for(Ladder l : Ladder.values()){
            if(l.bottom()==b) return l.top();
        }
        return 0;
    }
    
    //returns true when game is end prints winner name
    private boolean gameEnd(){
        for(int i=0;i<p;i++){
        if(players[i].isEnd()){ 
            System.out.println(players[i].name+" is the winner");
            return true;
        }
        }
        return false;
    }
    
    //main loop where all the work and methods are used
    private void gameLoop(){
        createPlayers();
        while(!gameEnd()){
            for(int i=0;i<p;i++){
                int toAdd=Player.genRandom();
                System.out.println(players[i].name+" turn:-"+ toAdd);
                players[i].add(toAdd);
                if(isHead(players[i].counter) != 0) {
                    players[i].counter = isHead(players[i].counter); //returns tail
                    System.out.println("Ohhhhh!!!");
                }
                else if(isBottom(players[i].counter) !=0 ){
                    players[i].counter = isBottom(players[i].counter); //returns top
                    System.out.println("Yayyyy!!!!!");
                }
                System.out.println(players[i].name+" new pos "+players[i].counter);
            }
        }
    }
    
    //creates players
    private void createPlayers(){
        players=new Player[p];  // creates new players
        
        Scanner kb = new Scanner(System.in);
        
        for(int i=0;i<p;i++){
            System.out.print("Enter Player "+(i+1)+" Name: ");
            players[i] = new Player();
            players[i].name = kb.next();
        }
    }
    
    
}