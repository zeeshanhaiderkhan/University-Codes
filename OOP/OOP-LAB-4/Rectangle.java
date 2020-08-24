public class Rectangle{
    private Point a,b,c;
    
    public Rectangle(Point x,Point y,Point z){
        a=x;b=y;c=z;
    }
    public double getArea(){
        double side1 = a.distance(b);
        double side2 = a.distance(c);
        return side1*side2;
    }
    
}