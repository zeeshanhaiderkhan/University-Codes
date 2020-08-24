
import java.io.Serializable;

public class bookflight implements Serializable{
    protected int[] no_of_seats;
    protected String category;
    protected String arrival_station;
    protected String departure_station;
    protected date date;
    protected time takeoff_time;
    protected time arrival_time;
    protected int price;

    public bookflight() {
    }

    public bookflight(int[] no_of_seats, String category, String arrival_station, String departure_station, date date, time takeoff_time, time arrival_time,int price) {
        this.no_of_seats = no_of_seats;
        this.category = category;
        this.arrival_station = arrival_station;
        this.departure_station = departure_station;
        this.date = date;
        this.takeoff_time = takeoff_time;
        this.arrival_time = arrival_time;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int[] getNo_of_seats() {
        return no_of_seats;
    }

    public void setNo_of_seats(int[] no_of_seats) {
        this.no_of_seats = no_of_seats;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public date getDate() {
        return date;
    }
    

    public void setDate(date date) {
        this.date = date;
    }

    public time getTakeoff_time() {
        return takeoff_time;
    }

    public void setTakeoff_time(time takeoff_time) {
        this.takeoff_time = takeoff_time;
    }

    public time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(time arrival_time) {
        this.arrival_time = arrival_time;
    }

    @Override
    public String toString() {
        return "bookflight{" + "no_of_seats=" + no_of_seats + ", category=" + category + ", arrival_station=" + arrival_station + ", departure_station=" + departure_station + ", date=" + date + ", takeoff_time=" + takeoff_time + ", arrival_time=" + arrival_time + ", price=" + price + '}';
    }

    
}
