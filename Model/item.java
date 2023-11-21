package Model;

public class item {
    //private global varibles
    private int itemID;
    private int orderID;
    private String name;
    private double itemPrice;


    //constructor to define the private variable
    public item(int itemID, int orderID, String name, double itemPrice) {   
        this.itemID = itemID;
        this.orderID = orderID;
        this.name = name;
        this.itemPrice = itemPrice;
    }

    //method to get the item ID
    public int getItemID() {
        return itemID; 
    } 

    //method to get the employee ID
    public int getOrderID() {
        return orderID; 
    } 

    //method to get item name
    public String name() {
        return name;
    }

    //method to get item price
    public double getPrice() {
        return itemPrice;
    }
    
}