package Time;

import java.util.*;

public class Clock
{
    
    public static void main()
    {
        Task task = new Task();
        Time t= new Time();
        task.bind(t);
        Timer timer = new Timer(true);
        timer.schedule(task,0,1000);
    }
}
