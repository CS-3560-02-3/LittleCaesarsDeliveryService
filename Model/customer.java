package Model;
import java.util.Random;
public class customer {
    //Attributes of customer
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String bankInformation;
    private int userId;
    //Constructor that creates the customer class
    public customer(String name, String phoneNumber, String emailAddress, String bankInformation){
        Random random = new Random();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.bankInformation = bankInformation;
        userId = random.nextInt(10000);
    }
    //returns name 
    public String name(){
        System.out.print("hi");
        return name;
    }
    //returns phone number
    public String phone(){
        return phoneNumber;
    }
    //returns email
    public String email(){
        return emailAddress;
    }
    //returns bank information
    public String bank(){
        return bankInformation;
    }
    //returns userId
    public int user(){
        return userId;
    }

}
