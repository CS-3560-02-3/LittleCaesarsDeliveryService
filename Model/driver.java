package Model;

public class driver extends employee {
    //private global variables
    private int licensePlateNumber;

    //constructor to define the private variables
    public driver(int employeeID, String username, String password, String name, int licensePlateNumber) {
        super(employeeID, username, password, name);
        this.licensePlateNumber = licensePlateNumber;
    }

    //gets the driver's license plate
    public int getLicensePlateNumber() {
        return licensePlateNumber;
    }
}
