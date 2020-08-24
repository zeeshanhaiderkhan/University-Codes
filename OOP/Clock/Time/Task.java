package Time;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Task extends TimerTask
{
    private Time t;
    
    public void run()
    {
        t.tick();
        System.out.println(t.getTime());
    }
    
    public void bind(Time tx)
    {
        this.t=tx;
    }
}
