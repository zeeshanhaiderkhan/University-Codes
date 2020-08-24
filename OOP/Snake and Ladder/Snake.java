
public enum Snake
{
    
    snake1(34,1),
    snake2(25,5),
    snake3(47,19),
    snake4(62,52),
    snake5(87,57),
    snake6(91,61),
    snake7(99,78);
    
    
    
    
    public int head;
    public int tail;
    Snake(int h,int t){
       head=h;
       t=tail;
    }
    
    public int tail(){
        return this.tail;
    }
    public int head(){
        return this.head;
    }
    
    
}
