package UI;
import Model.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.customer;

public class globalController {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    // static final String PASSWORD = "littleCaesars";
    static final String PASSWORD = "ilovemysql23";

    private static globalController globalcontroller;
    private order Order;
    private boolean loggedIn;
    private static customer Customer;
    private static final globalController GlobalController = new globalController();
    private int customerID;
    private customer currentCustomer;

    //private constructor to prevent instantiation of the object from the outside. This helps create only one instance of the object at a time.
    /* private globalController() {
        loggedIn = false;
        Order = getCurrentOrder();
    } */
    
    public static globalController getGlobalController() {
        return GlobalController;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public order getOrder() {
        return Order;
    }

    public void setOrder(order Order) {
        this.Order = Order;
    }



    //make sure that there is only one instantiation at a time. Ensures only one user can use the application at a time.
    public static globalController instantiateGlobalController() {
        if (globalcontroller == null)
            globalcontroller = new globalController();
        return globalcontroller;
    }
    
    //method to return the login status
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    //method to update if a customers logs in or logs out
    public void changeLoggedIn(boolean updatedLoggedIn) {
        loggedIn = updatedLoggedIn;
    }

    //method to return the order that is associated with the customer.
    public order getCurrentOrder() {
        if (Order == null) {
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT orderID FROM `order` WHERE orderID = (SELECT MAX(orderID) FROM `order`)");
                

                if (resultSet.next()) {
                    int orderID = resultSet.getInt("orderID") + 1;
                    Order = new order(orderID, 1127, 0, 0);
                }
                else {
                    System.out.println("No Order ID found in Database");
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
                if (statement != null) {
                    try {
                        statement.close();
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
        return Order;
    }

    public static void setCustomer(customer Customer) {
        globalController.Customer = Customer;
    }

    public static customer getCustomer() {
        return globalController.Customer;
    }
}
