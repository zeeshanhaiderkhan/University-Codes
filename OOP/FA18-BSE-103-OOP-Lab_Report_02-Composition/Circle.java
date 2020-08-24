public class Circle{

    private Point o;    //origin
    private Point cp;   //point on circumference; circumference point
    
    //argument constructor
    public Circle(Point origin,Point circum){
        set(origin,circum);
    }
    
    //copy constructor
    public Circle(Circle c){
        set(c.o,c.cp);
    }
    
    //default constructor
    public Circle(){
        set(new Point(0,0),new Point(1,1));
    }
    
    public void set(Point origin,Point circum){
        o=origin;   cp=circum;
    }
    
    //distance between origin and point on circumference
    public double getRadius(){
        return o.distance(cp);
    }
    
    //pi*r^2
    public double getArea(){
        return Math.PI * Math.pow( getRadius() , 2);
    }
    
    //2*pi*r
    public double getCircumference(){
        return 2* Math.PI * getRadius();
    }
    
    
}
