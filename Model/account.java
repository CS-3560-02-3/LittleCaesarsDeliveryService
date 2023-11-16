package Model;
public class account {
    //private global variables
    private String userName;
    private String deliveryAddress;
    private String billingInfo;
    private int userID;
    private String passWord;

    //constructor method to define the private variables
    public account(String userName, String deliveryAddress, String billingInfo, int userID, String passWord) {
        this.userName = userName;
        this.deliveryAddress = deliveryAddress;
        this.billingInfo = billingInfo;
        this.userID = userID;
        this.passWord = passWord;
    } 

    //method to get the customer's username
    public String getUserName() {
        return userName;
    } //end getUserName
    
    //method to get the customer's address
    public String getDeliveryAddress() {
        return deliveryAddress;
    } //end getDeliveryAddress
    
    //method to update the delivery address in case the customer changed addresses
    public void updateDeliveryAddress(String newDeliveryAddress) {
        deliveryAddress = newDeliveryAddress;
    } //end updateDeliveryAddress

    //method to get the customer's billing information
    public String getBillingInfo() {
        return billingInfo;
    } //end getBillingInfo
    
    //method to update the customer's billing information if they want to use a different form of payment
    public void updateBillingInfo(String newBillingInfo) {
        billingInfo = newBillingInfo;
    } //end updateBillingInfo

    //method to get the customer's user ID
    public int getUserID() {
        return userID;
    } //end getUserID

    //method to get the customer's password
    public String getPassWord() {
        return passWord;
    } //end getPassWord

    //method to update the customer's password if they want to change it
    public void updatePassWord(String newPassWord) {
        passWord = newPassWord;
    } //end updatePassWord
} //end account
