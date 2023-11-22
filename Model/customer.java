package Model;
public class customer {
    //Attributes of customer
    private int customerID;
    private String username;
    private String password;
    private String name;
    private String deliveryAddress;
    private String emailAddress;
    private String billingInformation;
    //Constructor that creates the customer class
    public customer(int customerID, String username, String password, String name, String deliveryAddress, String emailAddress, String billingInformation){
        this.customerID = customerID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.emailAddress = emailAddress;
        this.billingInformation = billingInformation;

    }
    //returns customerID
    public int customerID(){
        return customerID;
    }
    //returns username
    public String username(){
        return username;
    }
    //returns password
    public String password(){
        return password;
    }
    //returns name
    public String name(){
        return name;
    }
    //returns deliveryAddress
    public String deliveryAddress(){
        return deliveryAddress;
    }
    //return emailAddress
    public String emailAddress(){
        return emailAddress;
    }
    //return billingAddress
    public String billingInformation(){
        return billingInformation;
    }

}
