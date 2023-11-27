package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class delivery {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    // static final String PASSWORD = "littleCaesars";
    static final String PASSWORD = "ilovemysql123";

    //private global variables
    private int deliveryID;
    private int estimatedTime;
    private String deliveryStatus;
    private int deliveryDate;    
    private driver Driver;

    //constructor method to define the delivery number and the approximate time it will take to get to the customer's house
    public delivery (int deliveryID, int estimatedTime, String deliveryStatus, int deliveryDate) {
        this.deliveryID = deliveryID;
        this.estimatedTime = estimatedTime;
        this.deliveryStatus = deliveryStatus;
        this.deliveryDate = deliveryDate;
    } //end constructor

    public delivery(int deliveryID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM delivery WHERE deliveryID = ?");
            preparedStatement.setInt(1, deliveryID);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                estimatedTime = resultSet.getInt("estimatedTime");
                deliveryStatus = resultSet.getString("deliveryStatus");
            }
        }
        catch (Exception e) {
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

    //Gets the delivery number
    public int getDeliveryID() {
        return deliveryID;
    } //end getDeliveryNumber

    //Gets the delivery status
    public String getDeliveryStatus() {
        return deliveryStatus;
    } //end getDeliveryStatus

    //Gets the delivery date of the order;
    public int getDeliveryDate() {
        return deliveryDate;
    } //end getDeliveryDate

    //gets the estimated time (in minutes) that it will take to get to the customer's house.
    public int getEstimatedTime() {
        return estimatedTime;
    } //end calculateEstimatedTime

    //method to mark a delivery as delivered. Will only do something if the deliveryStatus is false
    public void markAsDelivered(boolean deliveryStatus) {
        if (deliveryStatus == false)
            deliveryStatus = true;
    } //end markAsDelivered

    //method to calculate the estimated time that an order will take
    public void calculateEstimatedTime(int numberOfOrdersBeingMade) {
        estimatedTime = 7 * numberOfOrdersBeingMade; //random time
    } //end calculateEstimatedTime

    //method to assign a driver to a delivery
    public void assignDriver(driver Driver) {
        this.Driver = Driver;
    } //end assignDriver

    //method to get the assigned driver
    public driver getAssignedDriver() {
        return Driver;
    } //end getAssignedDriver
} //end delivery class
