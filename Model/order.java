package Model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class order {
    //JDBC connection
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    // static final String PASSWORD = "littleCaesars";
    static final String PASSWORD = "ilovemysql23";

    //attributes
    private int orderID;
    private int dateOrdered;
    private double totalCost;
    private int tip;
    private ArrayList<menuItems> orderList; // Data structure for the order
    private delivery Delivery;
    private customer Customer;

    //counter variables
    private int cheeseCounter;
    private int pepperoniCounter;
    private int meatCounter;
    private int veggieCounter;
    private int deepDishCounter;
    private int wingsCounter;
    private int crazyBreadCounter;
    private int sodaCounter;


    //constructor for order class
    public order(int orderID, int dateOrdered, double totalCost, int tip) {
        this.orderID = orderID;
        this.dateOrdered = dateOrdered;
        this.totalCost = totalCost;
        this.tip = tip;
        this.orderList = new ArrayList<>();
        this.cheeseCounter = 0;
        this.pepperoniCounter = 0;
        this.meatCounter = 0;
        this.veggieCounter = 0;
        this.deepDishCounter = 0;
        this.wingsCounter = 0;
        this.crazyBreadCounter = 0;
        this.sodaCounter = 0;

        //sql insert statements

    } //end constructor
    
    //constructor to add values through the SQL database
    public order(int orderID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM order WHERE orderID = ?");
            preparedStatement.setInt(1, orderID);
            resultSet = preparedStatement.executeQuery();

            dateOrdered = resultSet.getInt("dateOrdered");
            totalCost = 0;
            tip = resultSet.getInt("tip");
            this.orderList = new ArrayList<>();
            this.cheeseCounter = 0;
            this.pepperoniCounter = 0;
            this.meatCounter = 0;
            this.veggieCounter = 0;
            this.deepDishCounter = 0;
            this.wingsCounter = 0;
            this.crazyBreadCounter = 0;
            this.sodaCounter = 0;
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
    } //end Constuctor

    //get methods for order ID
    public int getOrderID() {
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
    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
    
    //method to get the orderList
    public ArrayList<menuItems> getOrderList() {
        return orderList;
    }

    //method to calculate the total cost of the item
    public void calculateTotalCost() {
        ArrayList<menuItems> duplicates = new ArrayList<>();
        totalCost = 0;
        for (menuItems item : orderList) {
            if (!duplicates.contains(item)) {
                totalCost += item.getPrice() * getCounterValue(item);
                duplicates.add(item);
            }
        }
    } //end calculateTotalCost
    
    //method to add an menu-item object to the order 
    public void addItemToCart(menuItems item) {
        orderList.add(item);
    } //end addItemToCart
    
    //method to remove a menu-item obejct from the order
    public void removeItemFromCart(menuItems item) {
        orderList.remove(item);
    } //end removeItemFromCart
    
    //method to update the orderlist when a new item is added or a previous item is removed
    public void updateOrderList(ArrayList<menuItems> newOrderList) {
        this.orderList = newOrderList;
    } //end updateOrderList

    //method to update the counter in the backend
    public void updateCounter(menuItems item, int value) {
        switch(item.getName()) {
            case "cheese pizza":
                cheeseCounter = value;
                break;
            case "pepperoni pizza":
                pepperoniCounter = value;
                break;
            case "three meat treat":
                meatCounter = value;
                break;
            case "veggie pizza":
                veggieCounter = value;
                break;
            case "deep dish pizza":
                deepDishCounter = value;
                break;
            case "caesar wings":
                wingsCounter = value;
                break;
            case "crazy bread":
                crazyBreadCounter = value;
                break;
            case "two liter soda":
                sodaCounter = value;
                break;
        }
    } //end updateCounter

    //method to get the current counter value
    public int getCounterValue(menuItems item) {
        switch(item.getName()) {
            case "cheese pizza":
                return cheeseCounter;
            case "pepperoni pizza":
                return pepperoniCounter;
            case "three meat treat":
                return meatCounter;
            case "veggie pizza":
                return veggieCounter;
            case "deep dish pizza":
                return deepDishCounter;
            case "caesar wings":
                return wingsCounter;
            case "crazy bread":
                return crazyBreadCounter;
            case "two liter soda":
                return sodaCounter;
            default:
                return 0;
        }
    } //end getCounterValue
    
    //method to display the carts in the terminal
    public void displayItemsInCart() {
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i).getName());
        }
        System.out.println();
    } //end displayItemsInCart

    //method to assign the order to a delivery object
    public void assignDelivery(delivery Delivery) {
        this.Delivery = Delivery;
    }
    
    //method to get the Delivery from the order
    public delivery getDelivery() {
        return Delivery;
    }
    
    public void assignCustomer(customer Customer) {
        this.Customer = Customer;
    }
    
    public customer getCustomer() {
        return Customer;
    }
} // end order class
