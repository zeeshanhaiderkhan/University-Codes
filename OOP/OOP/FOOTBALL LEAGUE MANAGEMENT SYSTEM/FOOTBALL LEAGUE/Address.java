public class Address{
    private String city,country,streetAddress,postCode;
    public Address(String streetAddress,String city,String country, String postCode){
        this.city= city;
        this.country = country;
        this.streetAddress =streetAddress;
        this.postCode = postCode;
    }
    
    public String toString(){
        return streetAddress+", "+city+", "+country+", "+postCode;
    }
}