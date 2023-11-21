package Model;

public class employee {
    //private global variables
    private int employeeID;
    private String username;
    private String password;
    private String name;

    public employee(int employeeID, String username, String password, String name) {
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public int getEmployeeID() {
        return employeeID; 
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
