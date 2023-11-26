package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customer {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    //Attributes of customer
    private int customerID;
    private String username;
    private String password;
    private String name;
    private String deliveryAddress;
    private String emailAddress;
    private String cardNumber;
    private String cardDate;
    private String cardCVV;
    private static String currentCustomer;

    //Constructor that creates the customer class
    public customer(int customerID, String username, String password, String name, String deliveryAddress, String emailAddress, String cardNumber, String cardDate, String cardCVV) {
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

    public customer(String username, String password) {
        
        this.username = username;
        this.password = password;
    }

    public customer(int customerID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE customerID = ?");
            preparedStatement.setInt(1, customerID);
            resultSet = preparedStatement.executeQuery();

            name = resultSet.getString("name");
            username = resultSet.getString("username");
            password = resultSet.getString("password");
            deliveryAddress = resultSet.getString("deliveryAddress");
            emailAddress = resultSet.getString("emailAddress");
            cardNumber = resultSet.getString("cardNumber");
            cardDate = resultSet.getString("cardDate");
            cardCVV = resultSet.getString("cardCVV");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
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
    public String getCardNumber() {
        return cardNumber;
    }

    //method to get the customer's card expiration date
    public String getCardDate() {
        return cardDate;
    }

    //method to get the customer's card's CVV
    public String getCardCVV() {
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
    public void updateCardNumber(String newCardNumber) {
        cardNumber = newCardNumber;
    }

    //method to update the customer's card expiration date
    public void updateCardDate(String newCardDate) {
        cardDate = newCardDate;
    }

    //method to update the customer's card's CVV
    public void updateCardCVV(String newCardCVV) {
        cardCVV = newCardCVV;
    }

    public static String getCurrentCustomer() {
        return currentCustomer;
    }

} //end customer
