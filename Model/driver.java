package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class driver {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";
    //static final String PASSWORD = "ilovemysql";

    //private global variables
    private int driverID;
    private String username;
    private String password;
    private String name;
    private String licensePlateNumber;
    

    //constructor to define the private variables
    public driver(int driverID, String username, String password, String name, String licensePlateNumber) {
        this.driverID = driverID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.licensePlateNumber = licensePlateNumber;
    } //end driver constructor

    public driver(int driverID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM driver WHERE driverID = ?");
            preparedStatement.setInt(1, driverID);
            resultSet = preparedStatement.executeQuery();

            username = resultSet.getString("username");
            password = resultSet.getString("password");
            name = resultSet.getString("name");
            licensePlateNumber = resultSet.getString("licensePlateNumber");
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

    //method to get the driver ID
    public int getdriverID() {
        return driverID; 
    } //end getdriverID

    //method to get the driver's username
    public String getUsername() {
        return username;
    } //end getUsername

    //method to get the driver's password
    public String getPassword() {
        return password;
    } //end getPassword

    //method to get the driver's name
    public String getName() {
        return name;
    } //end getName

    //gets the driver's license plate
    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }
}
