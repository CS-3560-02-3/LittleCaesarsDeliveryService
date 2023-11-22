package Model;

public class menuItems {
    //private global varibles
    private int itemID;
    private String name;
    private double itemPrice;

    //constructor to define the private variables
    public menuItems(int itemID, String name, double itemPrice) {   
        this.itemID = itemID;
        this.name = name;
        this.itemPrice = itemPrice;
    }

    //method to get the item ID
    public int getItemID() {
        return itemID; 
    }

    //method to get item name
    public String getName() {
        return name;
    }

    //method to get item price
    public double getPrice() {
        return itemPrice;
    }
}