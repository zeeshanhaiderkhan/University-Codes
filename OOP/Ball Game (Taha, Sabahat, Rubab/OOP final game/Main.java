
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JFrame;

public class Main
{
    // instance variables - replace the example below with your own
  public static void main(){
      JFrame obj=new JFrame();
      GamePlay gameplay=new GamePlay();
      
      obj.setBounds(10,10,700,600);
      obj.setTitle("BRICKS BREAKER");
      obj.setResizable(false);
      obj.setVisible(true);
      obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      obj.add(gameplay);
      o
      
    }
}
