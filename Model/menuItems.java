package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class menuItems {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

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

    public menuItems(int itemID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM item WHERE itemID = ?");
            preparedStatement.setInt(1, itemID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                name = resultSet.getString("name");
                itemPrice = resultSet.getDouble("price");
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

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        menuItems item = (menuItems) object;
        return Objects.equals(getName(), item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}