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
    public customer(String username, String password, String name, String deliveryAddress, String emailAddress, String bilingInformation, int customerID){
        this.name = name;
        this.username = username;
        this.password = password;
        this.deliveryAddress = deliveryAddress;
        this.emailAddress = emailAddress;
        this.customerID = customerID;
    }
    //returns name 
    public String name(){
        return name;
    }
    //return customerID
    public int customerID(){
        return customerID;
    }
    //return username
    public String username(){
        return username;
    }
    //return password
    public String password(){
        return password;
    }
    //return deliveryAddess
    public String deliveryAddress(){
        return deliveryAddress;
    }
    //return emailAddress
    public String emailAddress(){
        return emailAddress;
    }
    //return billingInformation
    public String billingInformation(){
        return billingInformation;
    }
    
    

}
