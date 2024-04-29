public class Address {
    
    private String street;
    private String city;
    private String postalCode;

    
    public Address(String city, String street, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
    
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    
}
