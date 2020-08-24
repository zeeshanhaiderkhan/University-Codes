
import java.io.Serializable;

public class ticket implements Serializable{
protected double price;
protected int seat_no;
    protected String arrival_station;
    protected String departure_station;


    protected date date_flight;
    protected time departure_time;
    public ticket(){

    }

    public ticket(double price, int seat_no, String arrival_station, String departure_station, date d, time departure_time) {
        this.price = price;
        this.seat_no = seat_no;
        this.arrival_station = arrival_station;
        this.departure_station = departure_station;
        this.date_flight = d;
        this.departure_time = departure_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    public String getArrival_station() {
        return arrival_station;
    }

    public void setArrival_station(String arrival_station) {
        this.arrival_station = arrival_station;
    }

    public String getDeparture_station() {
        return departure_station;
    }

    public void setDeparture_station(String departure_station) {
        this.departure_station = departure_station;
    }

    public date getDate_flight() {
        return date_flight;
    }

    public void setDate_flight(date date_flight) {
        this.date_flight = date_flight;
    }


    public time getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(time departure_time) {
        this.departure_time = departure_time;
    }
    void display(){

    }
    boolean compare_time(time t){
        return( (this.departure_time.hour==t.hour)&&(this.departure_time.min==t.min)&&(this.departure_time.sec==t.sec));
    }

}
