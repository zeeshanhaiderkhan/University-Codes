
import java.io.Serializable;

public class record implements Serializable{
    protected date date;

    public record() {
    }

    public record(date date) {
        this.date = date;
    }

    public date getDate() {
        return date;
    }

    public void setDate(date date) {
        this.date = date;
    }
}
