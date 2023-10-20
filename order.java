import java.util.List;

public class order {

    // attributes
    private int orderID;
    private boolean orderStatus; // shipped or delivered status
    private int arrivalTime;

    private List orderList; // Data structure for the order

    // constructor for order class
    public order(int orderID, boolean orderStatus, int arrivalTime) {
        
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.arrivalTime = arrivalTime;
    }

    // return nothing
    public static void placeOrder() {
        // code
    }


    // get methods for order ID
    public int getOrderID() {
        return orderID;
    }

    // get method for order status
    public boolean getOrderStatus() {
        return orderStatus;
    }

    // get method for arrival time
    public int getArrivalTime() {
        return arrivalTime;
    }
} // end order class
