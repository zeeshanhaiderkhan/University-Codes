
public class Rational
{
    private int num,den; // numerator and denominator
    
    //default constructor
    public Rational()
    {
        set(1,1);
    }
    
    // Constructor with arguments
    public Rational(int a,int b){
        set(a,b);
    }
    
    //Copy Constructor
    public Rational(Rational r){
        set(r.num,r.den);
    }
    
    //Standard set method
    public void set(int a,int b){
       num=a;den=b;
    }
    
    
    //Displays number in standard mathematical form
    public void display(){
        System.out.println(num+"/"+den);
    }
    
    //static method to calculate GCD of two numbers
    public static int gcd(int a,int b){
        int temp;
        if(a<b){
            temp=a;
        }
        else temp=b;
        for(int i=temp;i>=1;i--){
            if(a%i == 0 && b%i==0){
                return i;
            }
        }
        return 1;
        
    }
    
    //reduces numbers to their least form
    public void reduce(){
        int temp= gcd(num,den);
        num/=temp;
        den/=temp;
    }
    
    //adds rational number with arguments
    public void add(int a,int b){
        int new_den = b*den;
        num = num*b+den*a;
        den=new_den;
        reduce();
        
    }
    
    //adds rational numbers with argument as rational number
    public void add(Rational r){
        add(r.num,r.den);
    }
    
    //Static method to add two rational numbers and returns third number..
    public static Rational add(Rational r1, Rational r2){
        Rational temp = new Rational(r1.num,r1.den);
        temp.add(r2);
        return temp;
    }
}
