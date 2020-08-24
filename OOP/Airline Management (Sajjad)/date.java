
import java.io.Serializable;

public class date  implements Serializable{
    protected int date;
    protected  int month;
    protected int year;
    public date(){
date=1;
month=2;
year=3;
        
    }

    public date(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public String date(){
     String date=this.date+"/"+this.month+"/"+this.year;
     return date;
    }
}
