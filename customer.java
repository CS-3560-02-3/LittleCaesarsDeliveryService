import java.util.Random;
public class customer {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String bankInformation;
    private int userId;

    public customer(String name, String phoneNumber, String emailAddress, String bankInformation){
        Random random = new Random();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.bankInformation = bankInformation;
        userId = random.nextInt(10000);
    }

    public String name(){
        return name;
    }

    public String phone(){
        return phoneNumber;
    }
    
    public String email(){
        return emailAddress;
    }
    public String bank(){
        return bankInformation;
    }
    public int user(){
        return userId;
    }

}
