public class Triangle{
    /*       A
     *      / \  
     *     /   \
     *    /     \
     *   /       \
     *  B---------C 
     */ 
    private Point a,b,c;
    
    //argument constructor
    public Triangle(Point x,Point y,Point z){
        set(x,y,z);
    }
    
    //copy Contstructor
    public Triangle(Triangle t){
        set(t.a,t.b,t.c);
    }
    
    //default constructor
    public Triangle(){
        set(new Point(2,2),new Point(0,0),new Point(0,4));
    }
    
    public void set(Point x,Point y,Point z){
        a=x;b=y;c=z;
    }
    
    //1/2 * base * height
    public double getArea(){
        Point basePoint = new Point(a.getX(),b.getY());     //reference poinit in base for calculating height of triangle
        return (0.5) * basePoint.distance(a) * b.distance(c);
        
    }
    
    //adding all sides ab ac bc
    public double getPerimeter(){
        return a.distance(b)+a.distance(c)+b.distance(c);
    }
    
}