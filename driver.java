public class driver {
    
    //private variables
    private String name;
    private String birthday;
    private String driverLicense;

    //constructor
    public driver(String name, String birthday, String driverLicense) {
        this.name = name;
        this.birthday = birthday;
        this.driverLicense = driverLicense;
    }

    //gets the driver's name
    public String name() {
        return this.name;
    }

    //gets the driver's birthday
    public String birthday() {
        return this.birthday;
    }

    //gets the driver's license id
    public String driverLicense() {
        return this.driverLicense;
    }
}
