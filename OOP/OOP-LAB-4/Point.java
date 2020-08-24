
public class Point
{
 
    private int x; // x coordinate
    private int y; // y coordinate
    
    //default constructor with points as origin
    public Point()
    {
        x = 0;
        y = 0;
    }

    //Constructor with arguments
    public Point(int a,int b){
        set(a,b);
    }
    
    //Copy Constructor
    public Point(Point p){
        set(p.x,p.y);
    }
    
    //sets the attirbutes
    public void set(int a,int b){
        x=a;
        y=b;
    }
    
    //used to display coordinates in standard mathematical form
    public void display(){
        System.out.println("("+x+", "+y+")");
    }
    
    //returns difference between two points using distance formula
    public double distance(Point p){
        return Math.sqrt(Math.pow((p.x-this.x),2)+Math.pow(p.y-this.y,2));
    }
    
    //returns difference between two points with second point as argument
    public double diff(int a,int b){
        return Math.sqrt(Math.pow((a-this.x),2)+Math.pow(b-this.y,2));
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
    
}
