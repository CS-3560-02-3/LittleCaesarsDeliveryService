package Model;

public class driver {
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
