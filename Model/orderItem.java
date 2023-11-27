package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orderItem {
    static final String DB_URL = "jdbc:mysql://localhost:3306/littlecaesars";
    static final String USER = "root";
    //change the password so you can view it. It is the password for your SQL login
    // static final String PASSWORD = "littleCaesars";
    static final String PASSWORD = "ilovemysql23";
    
    private int orderID;
    private int itemID;
    private int quantity;
    private order Order;
    private menuItems menuItem;

    public orderItem(int orderID, int itemID, int quantity) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.quantity = quantity;
    }

    public orderItem(int itemID, int orderID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM order_item WHERE orderID = ? AND itemID = ?");
            preparedStatement.setInt(1, orderID);
            preparedStatement.setInt(2, itemID);
            resultSet = preparedStatement.executeQuery();
            
            this.quantity = resultSet.getInt("quantity");
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

    // method to get order ID
    public int getOrderID() {
        return orderID;
    }

    // method to get item ID
    public int getItemID() {
        return itemID;
    }

    // method to get item quantity
    public int getQuantity() {
        return quantity;
    }

    // method to set item quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void updateQuantity(int newQuantity) {
        quantity = newQuantity;
    }
    
    public menuItems getMenuItem() {
        return menuItem;
    }

    public order getOrder() {
        return Order;
    }

    public double calculateItemCost(menuItems menuItem) {
        return quantity * menuItem.getPrice();
    }
}
