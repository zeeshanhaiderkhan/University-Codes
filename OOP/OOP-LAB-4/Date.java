

public class Date
{
   
    private int d,m,y; //day,month,year
    
    //used for displaying
    private static String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
    
    //default constructor
    public Date()
    {
        d=1;m=1;y=2000; //default date January 1, 2000
    }
    
    //argument contructor
    public Date(int day,int month,int year){
        set(day,month,year);
    }
    
    //copy constructor
    public Date(Date date){
        set(date.d,date.m,date.y);
    }
    
    //used to set the attributes
    public void set(int day,int month,int year){
        if(!(validate(day,month,year))){
            System.out.println("Wrong Input");
        }
        else {
            d=day;m=month;y=year;
            System.out.print("HERE");
        }
    }
    
    //returns date format with month as name e.g. September 25, 2019
    public String toString(){
       return months[m-1] + " "+d+", "+y;
       
    }
    
    //Checks if a certain object is in the certain list...
    private boolean in(int data,int[] array){
       for(int i=0;i<array.length;i++){
           if(data==array[i]) return true;
        }
        return false;
    }
    
    //returns true if a year is leap
    //here is leap year algorithm
    public  boolean isLeap(int year) {
    if (year % 4 != 0) {
        return false;
    }
    if (year % 400 == 0) {
        return true;
    }
    return (year % 100 != 0);
    }
    
    
    //here we check if a day is correct in the leap year or not 
    private boolean leapCheck(int day,int year)
    {
        if(isLeap(year) && day<=29 ) return true;
        else if(day>29) return false;
        else return true;
    }
    
    
    
    //checks if month and day is correct or not
    private boolean checkDayMonth(int day,int month)
    {
        return ( month<13 && month>0 &&  day<32 && day>0 );   //max number of days= 31 least number of days =1 && month max =12 and month least=1
    }
    
    
    private boolean validate(int day,int month,int year)
    {
        
        int[] days_31={1,3,5,7,8,10,12}; // months with 31 days, their sequence 
        System.out.println("GERE");
        if( !(checkDayMonth(day,month)) ) return false;  //checks if month and day is correct or not
        else if(month == 2) return leapCheck(day,year);  //if february return leapCheck
      
        else if( in(month, days_31) ) return true;  //    if month is in 31 days list but days are greater than 31 return false,using in method defined prev
        else if(!(in(month,days_31)) && day>30) return false;   //  if month is in not in 31 days list but days are greater than 30 return false
        else return true;       //everthing fine
        
    }
    
    

   
  
}
