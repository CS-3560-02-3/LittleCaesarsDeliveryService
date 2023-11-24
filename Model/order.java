package Model;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class order{
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    // attributes
    private int orderID;
    private int dateOrdered;
    private double totalCost;
    private double tip;
    private ArrayList<menuItems> orderList; // Data structure for the order
    private delivery Delivery;
    private customer Customer;

    // constructor for order class
    public order(int orderID, int dateOrdered, double totalCost, double tip) {
        this.orderID = orderID;
        this.dateOrdered = dateOrdered;
        this.totalCost = totalCost;
        this.tip = tip;
    }

    public order(int orderID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM order WHERE orderID = ?");
            preparedStatement.setInt(1, orderID);
            resultSet = preparedStatement.executeQuery();

            dateOrdered = resultSet.getInt("dateOrdered");
            totalCost = resultSet.getDouble("totalCost");
            tip = resultSet.getInt("tip");
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

    //get methods for order ID
    public int OrderID() {
        return orderID;
    }

    //get method for getting the data ordered
    public int getDateOrdered() {
        return dateOrdered;
    }

    //get method for getting the total cost
    public double getTotalCost() {
        return totalCost;
    }

    //get method for getting the tip
    public double getTip() {
        return tip;
    }

    //method to calculate the total cost of the item
    public void calculateTotalCost(orderItem OrderItem) {
        for (menuItems item : orderList) {
            totalCost += OrderItem.calculateItemCost(item);
        }
    } //end calculateTotalCost

    //method to add an menu-item object to the order 
    public void addItemToCart(menuItems item) {
        orderList.add(item);
    } //end addItemToCart

    //method to assign the order to a delivery object
    public void assignDelivery(delivery Delivery) {
        this.Delivery = Delivery;
    }

    //method to get the Delivery from the order
    public delivery getDelivery() {
        return Delivery;
    }

    public void assignCustomer(customer Customer) {
        this.Customer = Customer;
    }

    public customer getCustomer() {
        return Customer;
    }
} // end order class
