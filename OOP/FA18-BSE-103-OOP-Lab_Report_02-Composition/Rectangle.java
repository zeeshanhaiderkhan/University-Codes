public class Rectangle{
    
    /*      a------------------b
     *      |                  |
     *      |                  |
     *      c------------------d
     */
    
    private Point a,b,c,d;
    
    //argument constructor
    public Rectangle(Point w,Point x,Point y,Point z){
        set(w,x,y,z);
    }
    
    //copy constructor
    public Rectangle(Rectangle r){
        set(r.a,r.b,r.c,r.d);
    }
    
    //default constructor
    public Rectangle(){
       set(new Point(0,1),new Point(1,1),new Point(0,0),new Point(1,0));
    }
   
    public void set(Point w,Point x,Point y,Point z){
        a=w;b=x;
        c=y;d=z;
    }
    
    //multiply side1 (a,c) by side 2 (a,b)
    public double getArea(){
        return a.distance(b) * a.distance(c);
    }
    
    //perimeter add all the sides
    public double getPerimeter(){
        return 2*a.distance(b) + 2*a.distance(c);
    }
    
    //returns length of diagonal
    public double getDiagonal(){
        return a.distance(d);
    }
}