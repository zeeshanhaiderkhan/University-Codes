

public class Complex
{
  
    private double r;   //real part of complex number
    private double im;  // imaginary part of complex number

   
    //Default constructor
    public Complex()
    {
        set(0,0);
     
    }
    
    // Constructor with arguments
    public Complex(double real,double imaginary){
        set(real,imaginary);
    }
    
    //copy constructor
    public Complex(Complex z){
        set(z.r,z.im);
    }
    
    //standard set method
    public void set(double real,double imaginary){
        r=real;
        im=imaginary;
    }
    
    //displays complex number in standard mathematical notation
    public void display(){
        System.out.println(r+"+"+im+"i");
    }
    
   
    //adds two complex number and returns as complex number
    public Complex add(Complex z){
        Complex temp = new Complex(r,im);
        temp.r=temp.r+z.r;
        temp.im=temp.im+z.im;
        return temp;
    }

    //add to this with arguments
    public void add(double real,double imaginary){
        r=r+real;
        im=im+imaginary;
    }
    
    //adds two numbers and returns third number with two number argument method
    public static Complex add(Complex z1,Complex z2){
        return z1.add(z2);
    }
    
    
}
