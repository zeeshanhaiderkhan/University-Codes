
import java.io.Serializable;

public class time implements Serializable{
    protected int hour;
    protected int min;
    protected int sec;
public time(){

}
    public time(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
    public String time(){
        String time=this.hour+":"+this.min+":"+this.sec;
        return time;
    }
}
