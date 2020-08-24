
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Font;
public class Next extends JPanel implements KeyListener, ActionListener
{
    private boolean play=false;
    private int score=0;
    private int totalbricks=32;
    private Timer timer;
    private int delay = 6;
    private int playerX=310;
    private int ballposx=120;
    private int ballposy=350;
    private int ballXdir=-1;
    private int ballYdir=-2;

    private MapGenerator1 map;
    public Next(){
        map=new MapGenerator1(4,8);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();

    }

    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(1,1,892,792);
        
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("LEVEL-2",30,30);
        //drawing map
        map.draw((Graphics2D)g);
        //borders
        g.setColor(Color.orange);
        g.fillRect(0,0,3,792);
        g.fillRect(0,0,892,3);
        g.fillRect(891,0,3,792);

        //scores
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString(""+score,590,30);
        //the paddle
        g.setColor(Color.green);
        g.fillRect(playerX,450,75,7);

        //the ball
        g.setColor(Color.yellow);
        g.fillOval(ballposx,ballposy,20,20);
        if(totalbricks <=0){
             play=false;
    ballXdir=0;
ballYdir=0;
g.setColor(Color.blue);
g.setFont(new Font("serif",Font.BOLD,30));
g.drawString("YOU WON :) ",260,300);
g.setFont(new Font("serif",Font.BOLD,20));
g.drawString("Press Enter to Restart ",230,30);
        }
        if(ballposy>550){
        play=false;
    ballXdir=0;
ballYdir=0;
g.setColor(Color.blue);
g.setFont(new Font("serif",Font.BOLD,30));
g.drawString("Game Over  Scores: "+score+"",190,300);
g.setFont(new Font("serif",Font.BOLD,20));
g.drawString("Press Enter to Restart ",230,30);
}
        

        g.dispose();
    }

    public void actionPerformed(ActionEvent e){
        timer.start();
        if(play){
            if(new Rectangle(ballposx,ballposy,20,20).intersects(new Rectangle(playerX,450,75,7))){

                ballYdir= -ballYdir;
            }
            for(int i=0;i<map.map.length;i++){
                for(int j=0;j<map.map[0].length;j++){
                    if(map.map[i][j]>0){
                        int brickX=j*map.brickWidth+80;
                        int brickY=i*map.brickHeight+50;
                        int brickWidth=map.brickWidth;
                        int brickHeight=map.brickHeight;
                        Rectangle rect= new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        Rectangle ballRect=new Rectangle(ballposx,ballposy,20,20);
                        Rectangle brickRect=rect;

                        if(ballRect.intersects(brickRect)){
                            map.setBrickValue(0,i,j);
                            totalbricks--;
                            score+=5;
                            if(ballposx +19<=brickRect.x || ballposx+1>=brickRect.x+brickRect.width){
                                ballXdir= -ballXdir;
                            }
                            else{
                                ballYdir= -ballYdir;
                            }
                        }

                    }
                }
            }

            ballposx+=ballXdir;
            ballposy+=ballYdir;
            if(ballposx<0){
                ballXdir= -ballXdir;
            }
            if(ballposy<0){
                ballYdir= -ballYdir;
            }
            if(ballposx > 670){
                ballXdir= -ballXdir;
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent e){
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if(playerX >=600){
                playerX=600;
            }
            else{
                moveRight();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            if(playerX < 10){
                playerX=10;
            }
            else{
                moveLeft();
            }
        }
if(e.getKeyCode() == KeyEvent.VK_ENTER){
if(!play){
play=true;
ballposx=120;
ballposy=350;
ballXdir=-1;
ballYdir=-2;
playerX=310;
score=0;
totalbricks=32;
map=new MapGenerator1(4,8);
repaint();}}
    }

    public void moveRight(){
        play=true;
        playerX+=20;
    }

    public void moveLeft(){
        play=true;
        playerX-=20;
    }
}