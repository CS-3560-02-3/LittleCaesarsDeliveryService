public class account {

    private String userName;
    private String deliveryAddress;
    private String billingInfo;
    private int userID;
    private String passWord;


    public account(String userName, String deliveryAddress, String billingInfo, int userID, String passWord) {
        this.userName = userName;
        this.deliveryAddress = deliveryAddress;
        this.billingInfo = billingInfo;
        this.userID = userID;
        this.passWord = passWord;
    } 

    public String getUserName() {
        return userName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getBillingInfo() {
        return billingInfo;
    }

    public int getUserID() {
        return userID;
    }

    public String getPassWord() {
        return passWord;
    }
}
