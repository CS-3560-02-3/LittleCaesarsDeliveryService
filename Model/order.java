package Model;
import java.util.ArrayList;

public class order extends customer {

    // attributes
    private int orderID;
    private int dateOrdered;
    private double totalCost;
    private double tip;
    private ArrayList<menuItems> orderList; // Data structure for the order
    private delivery Delivery;

    // constructor for order class
    public order(int customerID, String username, String password, String name, String deliveryAddress, String emailAddress, int cardNumber, int cardDate, int cardCVV, int orderID, int dateOrdered, double totalCost, double tip) {
        super(customerID, username, password, name, deliveryAddress, emailAddress, cardNumber, cardDate, cardCVV);
        this.orderID = orderID;
        this.dateOrdered = dateOrdered;
        this.totalCost = totalCost;
        this.tip = tip;
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
} // end order class
