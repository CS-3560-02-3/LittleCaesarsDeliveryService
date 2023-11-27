package UI;

import Model.order;
import Model.customer;
public class globalController {
    //JDBC connection
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";
    //static final String PASSWORD = "ilovemysql23";

    //Creation of the Data Singleton to make sure that only one instance of the data is present during a login session
    private static final globalController GlobalController = new globalController();
    private customer currentCustomer;
    private int customerID;
    private order Order;
    private boolean loggedIn;
    
    //constructor
    public static globalController getGlobalController() {
        return GlobalController;
    }

    //method to get the customer ID
    public int getCustomerID() {
        return customerID;
    }

    //method to set the customer ID
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    //method to get the current customer logged in
    public customer getCurrentCustomer() {
        return currentCustomer;
    }

    //method to set the current customer logged in
    public void setCurrentCustomer(customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    //method to get the order
    public order getOrder() {
        return Order;
    }

    //method to set the order
    public void setOrder(order Order) {
        this.Order = Order;
    }
    //method to delete the order when it has been placed so the customer can add another order
    public void deleteOrder() {
        Order = null;
    }
    
    //method to return the login status
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    //method to update if a customers logs in or logs out
    public void changeLoggedIn(boolean updatedLoggedIn) {
        loggedIn = updatedLoggedIn;
    }
} //end globalController
