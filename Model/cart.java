package Model;
public class cart {

    // attributes
    private item Item;
    private int numOfItems;
    private boolean cartStatus; // open or closed state for the status of the cart 
    private int totalCost;

    // constructor
    public cart(item Item, int numOfItems, boolean cartStatus, int totalCost) {
        
        this.Item = Item;
        this.numOfItems = numOfItems;
        this.cartStatus = cartStatus;
        this.totalCost = totalCost;
    }

    // add item use case
    public static void addItem(item newItem) {
        // code
        // add new item to the end of the array or list
    }

    public static void removeItem(item newItem) {
        // code
        // the way our code would implement the cart is by a bag data structure
        // we would pass in the item needed to be removed, search for it, and remove it
    }


    // get methods for each attribute
    public int getTotalCost() {
        return totalCost;
    }

    // get method for item in cart
    public item getItem() {
        return Item;
    }

    // get method for number of items
    public int getNumberOfItems() {
        return numOfItems;
    }

    // get method for cart status
    public boolean getcartStatus() {
        return cartStatus;
    }
    
} // end cart class