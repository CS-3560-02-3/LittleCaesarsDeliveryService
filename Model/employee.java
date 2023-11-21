package Model;

public class employee {
    //private global variables
    private int employeeID;
    private String username;
    private String password;
    private String name;

    //constructor to define the private variables
    public employee(int employeeID, String username, String password, String name) {
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
        this.name = name;
    } //end employee constructor

    //method to get the employee ID
    public int getEmployeeID() {
        return employeeID; 
    } //end getEmployeeID

    //method to get the employee's username
    public String getUsername() {
        return username;
    } //end getUsername

    //method to get the employee's password
    public String getPassword() {
        return password;
    } //end getPassword

    //method to get the employee's name
    public String getName() {
        return name;
    } //end getName
} //end employee
