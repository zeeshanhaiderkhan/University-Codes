
import java.io.Serializable;

public class passenger extends person implements Serializable{
    protected String passport_no;
    protected ticket t;

    public passenger() {
    }

    public passenger(String firstname, String lastnamme, int age, String CNIC, String mobile, String email, String address, int id, String password, String passport_no, ticket t) {
        super(firstname, lastnamme, age, CNIC, mobile, email, address, id, password);
        this.passport_no = passport_no;
        this.t = t;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public ticket getT() {
        return t;
    }

    public void setT(ticket t) {
        this.t = t;
    }
    public boolean compare_passport_no(String passport_no){
        return(this.passport_no.equals(passport_no));
    }

}
