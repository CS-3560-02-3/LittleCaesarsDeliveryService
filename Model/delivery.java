package Model;
public class delivery {
    //private global variables
    private int deliveryNumber;
    private int approximateTime;

    //constructor method to define the delivery number and the approximate time it will take to get to the customer's house
    public delivery (int deliveryNumber, int approximateTime) {
        this.deliveryNumber = deliveryNumber;
        this.approximateTime = approximateTime;
    } //end constructor

    //Gets the delivery number
    public int getDeliveryNumber() {
        return deliveryNumber;
    } //end getDeliveryNumber

    //gets the approximate time (in minutes) that it will take to get to the customer's house
    public int getApproximateTime() {
        return approximateTime;
    } //end getApproximateTime

    //method to change the approximate time just in case the delivery driver is late due to reasons
    public void changeApproximateTime(int newTime) {
        approximateTime = newTime;
    } //end changeApproximateTime
} //end delivery class
