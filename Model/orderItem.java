package Model;

public class orderItem {
    
    private int itemID;
    private int orderID;
    private int quantity;

    public orderItem(int itemID, int orderID, int quantity) {

        this.itemID = itemID;
        this.orderID = orderID;
        this.quantity = quantity;
    }

    // method to get item ID
    public int getItemID() {
        return itemID;
    }

    // method to get order ID
    public int getOrderID() {
        return orderID;
    }

    // method to get item quantity
    public int getQuantity() {
        return quantity;
    }

    // method to set item quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }





}
