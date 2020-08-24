import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;

public class GameTest extends JFrame implements KeyListener{
    GamePlay gameplay;
    public GameTest(){
       setLayout(null);
      gameplay=new GamePlay();
      gameplay.setLayout(null);
      gameplay.setBounds(0,0,700,600);
      JPanel game =new JPanel(null);
      game.add(gameplay);
      game.setBounds(0,0,700,600);
      setBounds(0,0,700,600);
      setTitle("BRICKS BREAKER");
      setResizable(false);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      game.addKeyListener(this);
      add(game);
      
    }
    
    public void toNextLevel(){
        getContentPane().removeAll();
        Next next = new Next();
        next.setLayout(null);
        next.setBounds(10,10,700,600);
        next.setVisible(true);
        add(next);
    }
    
   
    public void keyTyped(KeyEvent e){
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyPressed(KeyEvent e){
        if(gameplay.getTotalBricks() <=0){
            toNextLevel();
        }
    
    }
    
}