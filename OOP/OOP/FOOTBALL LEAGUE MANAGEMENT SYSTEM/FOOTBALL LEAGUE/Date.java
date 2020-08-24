

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;


public class Date {
    private String date;
    public Date(String date){
        this.date = date;
    }
    public Date(){
        this.date = "NULL";
    }
    public static void main(String[] args) {
        String date1;
        Scanner kb = new Scanner(System.in);
        System.out.print("Please Enter the date in one of the following given format: \n1- DD-MM-YYYY  \n");

        System.out.println("Enter the first Date: ");
        date1 = kb.nextLine();

        while (!(checkdate(date1))) {
            System.out.println("The format of the entered date is incorrect \nPlease enter again according to defined format!");
            date1 = kb.nextLine();
        }
        System.out.println("Enter the Second Date: ");
        String date2 = kb.nextLine();

        while (!checkdate(date2)) {
            System.out.println("The format of the entered date is incorrect \nPlease enter again according to defined format!");
            date2 = kb.nextLine();
        }
        System.out.println("The two dates are:\n" + date1 + "\n" + date2);
        
        System.out.println(calc_duration(new Date(date1),new Date(date2)));
    }

    public static boolean checkformat(String a) {

        int count = 0;
        boolean check = true;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '-') {
                count++;
            }
        }
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == '-' && a.charAt(i + 1) == '-') {
                check = false;
                break;
            }
        }

        return count == 2 && check;
    }

    public static boolean checkdate(String a) {
        if (checkformat(a)) {

            String list[] = a.split("-");
            try {
                String day = list[0];
                String month = list[1];
                String year = list[2];
                
                if (isNumber(day) && isNumber(year) && isNumber(month)) {
                    int check = (checkdays(month,year));
                       boolean check1 = false;
                    if(Integer.parseInt(day)> 0 && Integer.parseInt(day)<= check  ){
                       check1 = true;
                    }
                    return (check1 &&(Integer.valueOf(month) >= 1 && Integer.valueOf(month) <= 12));

                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                return false;
            }
        }
        return false;
    }

    

    public static boolean isNumber(String s) {
        try {

            Integer.valueOf(s);
        } catch (Exception ex) {
            //invalid
            System.out.println("Invalid Number");
            return false;
        }
        return true;
    }

    public static boolean leapyear(String year) {
        int year1= Integer.parseInt(year);
        if ((year1 % 4 == 0 && year1 % 100 != 0) || (year1 % 400 == 0)) {
            return true;

        }
        return false;
    }

    public static int checkdays(String mon, String year) {
        boolean lyear = leapyear(year);
        String months[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try{
            int monInt = Integer.valueOf(mon);
            try{
                if( lyear){
                    return days[monInt-1]+1;
                } 
                
                return days[monInt-1];
            }
            catch(Exception outOfBound){  //not valid
                return 0;
            }
        }
        catch(Exception invString){
            return 0;
            
        }
      /*
        for (int i = 0; i < months.length - 1; i++) {
            if (mon.startsWith(months[i])) {
                if(mon=="1")
                    return days[0];
                if (mon=="2" && lyear == true) {
                     System.out.println("days"+days[i+1]);
                    return days[i];
                   
                }
                else{
                    return days[i+1];
                }
                   
            }
        }
  */     // return 0;
    }
    public static int getSplitIndex(String date,int index){
        return Integer.valueOf((date.split("-"))[index]);
    }
    public String getDate(){
        return date;
    }
    public static String calc_duration(Date start_date, Date end_date){
        try{
        int start_day = getSplitIndex(start_date.getDate(),0);
        int start_mon = getSplitIndex(start_date.getDate(),1);
        int start_year= getSplitIndex(start_date.getDate(),2);
        
        int end_day = getSplitIndex(end_date.getDate(),0);
        int end_mon = getSplitIndex(end_date.getDate(),1);
        int end_year = getSplitIndex(end_date.getDate(),2);
        
        if(start_year>end_year){
            return "Invalid";
        }
        else if(start_year==end_year && start_mon>end_mon){
            return "Invalid";
        }
        else if(start_year==end_year && start_mon==end_mon && start_day>end_day){
            return "Invalid";
        }
        else{
            int mon_diff,year_diff,day_diff;
            
            if(start_day>end_day){
                end_day+=checkdays(end_date.getDate().split("-")[1], end_date.getDate().split("-")[2]);
                end_mon--;
            }
            if(start_mon>end_mon){
                end_mon+=12;
                end_year--;
            }
            
            mon_diff=  end_mon - start_mon;
            year_diff= end_year- start_year;
            day_diff = end_day - start_day;
            return year_diff+" Years "+mon_diff+" Months "+ day_diff+" Days";
            }
        
        }
        
        catch(Exception IndexOutOfBound){
            return "Invalid";
        }
        
    } 

}
