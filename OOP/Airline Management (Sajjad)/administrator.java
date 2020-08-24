
import java.io.Serializable;



class administrator extends person implements Serializable{

protected String rank;
    protected date date_of_joining;
    protected double salary;

    public administrator() {
    }

    public administrator(String firstname, String lastnamme, int age, String CNIC, String mobile, String email, String address, int id, String password, String rank, date date_of_joining, double salary) {
        super(firstname, lastnamme, age, CNIC, mobile, email, address, id, password);
        this.rank = rank;
        this.date_of_joining = date_of_joining;
        this.salary = salary;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public date getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(date date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
