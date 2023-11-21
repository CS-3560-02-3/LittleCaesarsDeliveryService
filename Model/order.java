package Model;
import java.util.ArrayList;

public class order extends customer {

    // attributes
    private int orderID;
    private int dateOrdered;
    private double totalCost;
    private double tip;
    private ArrayList<String> orderList; // Data structure for the order

    // constructor for order class
    public order(int customerID, String username, String password, String name, String deliveryAddress, String emailAddress, String bilingInformation, int orderID, int dateOrdered, double totalCost, double tip) {
        super(customerID, username, password, name, deliveryAddress, emailAddress, bilingInformation);
        this.orderID = orderID;
        this.dateOrdered = dateOrdered;
        this.totalCost = totalCost;
        this.tip = tip;
    }

    // get methods for order ID
    public int getOrderID() {
        return orderID;
    }

    // get method for getting the data ordered
    public int getDateOrdered() {
        return dateOrdered;
    }

    // get method for getting the total cost
    public double getTotalCost() {
        return totalCost;
    }

    // get method for getting the tip
    public double getTip() {
        return tip;
    }
} // end order class
