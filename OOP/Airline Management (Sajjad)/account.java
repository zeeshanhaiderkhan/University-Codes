
import java.io.Serializable;

public class account implements Serializable {
    protected date date;
    protected double expense;
    protected double cash;

    public account() {
    }

    public account(date date, double expense, double cash) {
        this.date = date;
        this.expense = expense;
        this.cash = cash;
    }

    public date getDate() {
        return date;
    }

    public void setDate(date date) {
        this.date = date;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
