
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import java.awt.Graphics;

public class Main extends JFrame{
    private GamePlay gameplay;
    // instance variables - replace the example below with your own
  public  void Main(){
      gameplay=new GamePlay();
      
      setBounds(10,10,700,600);
      setTitle("BRICKS BREAKER");
      setResizable(false);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(gameplay);
      
    }
    
     public void toNextLevel(){
                 
                 
                 Next next = new Next();
                 next.setBounds(10,10,700,600);
                 
                 gameplay.setTotalBricks(1);
                 getContentPane().removeAll();
                 add(next);
                 
  
    }
    
    public static void main(){
        Main mai = new Main();
    }
    public void paintComponent(Graphics g){
        if(gameplay.getTotalBricks() <= 0){
                toNextLevel();
      }
      
    }
}
