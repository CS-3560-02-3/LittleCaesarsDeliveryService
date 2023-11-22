package Model;
public class customer {
    //Attributes of customer
    private int customerID;
    private String username;
    private String password;
    private String name;
    private String deliveryAddress;
    private String emailAddress;
    private int cardNumber;
    private int cardDate;
    private int cardCVV;

    //Constructor that creates the customer class
    public customer(int customerID, String username, String password, String name, String deliveryAddress, String emailAddress, int cardNumber, int cardDate, int cardCVV) {
        this.customerID = customerID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.deliveryAddress = deliveryAddress;
        this.emailAddress = emailAddress;
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
        this.cardCVV = cardCVV;
    }

    //method to get the customer ID
    public int getCustomerID() {
        return customerID;
    }

    //method to get the customer's name
    public String getName() {
        return name;
    }

    //method to get get the customer's username
    public String getUsername() {
        return username;
    }

    //method to get the customer's password
    public String getPassword() {
        return password;
    }

    //method to get the customer's delivery address
    public String getdeliveryAddress() {
        return deliveryAddress;
    }

    //method to get the customer's email address
    public String getEmailAddress() {
        return emailAddress;
    }

    //method to get the customer's card number
    public int getCardNumber() {
        return cardNumber;
    }

    //method to get the customer's card expiration date
    public int getCardDate() {
        return cardDate;
    }

    //method to get the customer's card's CVV
    public int getCardCVV() {
        return cardCVV;
    }

    //method to update the customer's name
    public void updateName(String newName) {
        name = newName;
    }

    //method to update the customer's delivery address
    public void updateDeliveryAddress(String newDeliveryAddress) {
        deliveryAddress = newDeliveryAddress;
    }

    //method to update the customer's card number
    public void updateCardNumber(int newCardNumber) {
        cardNumber = newCardNumber;
    }

    //method to update the customer's card expiration date
    public void updateCardDate(int newCardDate) {
        cardDate = newCardDate;
    }

    //method to update the customer's card's CVV
    public void updateCardCVV(int newCardCVV) {
        cardCVV = newCardCVV;
    }
} //end customer
