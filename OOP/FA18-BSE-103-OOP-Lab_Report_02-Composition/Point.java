
public class Point
{
 
    private double x; // x coordinate
    private double y; // y coordinate
    
    //default constructor with points as origin
    public Point()
    {
        x = 0;
        y = 0;
    }

    //Constructor with arguments
    public Point(double a,double b){
        set(a,b);
    }
    public Point(double a,int b){
        set(a,b);
    }
    //Copy Constructor
    public Point(Point p){
        set(p.x,p.y);
    }
    
    //sets the attirbutes
    public void set(double a,double b){
        x=a;
        y=b;
    }
    
    //used to display coordinates in standard mathematical form
    public void display(){
        System.out.println("("+x+", "+y+")");
    }
    
    //returns difference between two points using distance formula
    public double distance(Point p){
        return  diff(p.x,p.y);
    }
    
    //returns difference between two points with second point as argument
    public double diff(double a,double b){
        return Math.sqrt(Math.pow((a-this.x),2) + Math.pow(b-this.y,2));
    }
    
    //returns length from origin to the point
    public double length_from_origin(){
        return diff(0,0);
    }
    
    //static method for difference between two argument points
    public static double diff(Point p1,Point p2){
        Point p = new Point(p1);
        return p1.distance(p2);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
