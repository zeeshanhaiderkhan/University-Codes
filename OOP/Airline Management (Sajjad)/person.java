
import java.io.Serializable;

public class person implements Serializable{
    protected String firstname;
    protected String lastnamme;
    protected int age;
    protected String CNIC;
    protected String mobile;
    protected String email;
    protected String address;
    protected int id;
    protected String password;

    public person() {
    }

    public person(String firstname, String lastnamme, int age, String CNIC, String mobile, String email, String address, int id, String password) {
        this.firstname = firstname;
        this.lastnamme = lastnamme;
        this.age = age;
        this.CNIC = CNIC;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.id = id;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastnamme() {
        return lastnamme;
    }

    public void setLastnamme(String lastnamme) {
        this.lastnamme = lastnamme;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    void display(){

    }
}
