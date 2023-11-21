package Model;
public class delivery {
    //private global variables
    private int deliveryID;
    private int estimatedTime;
    private boolean deliveryStatus;
    private int deliveryDate;    

    //constructor method to define the delivery number and the approximate time it will take to get to the customer's house
    public delivery (int deliveryID, int estimatedTime, boolean deliveryStatus, int deliveryDate) {
        this.deliveryID = deliveryID;
        this.estimatedTime = estimatedTime;
        this.deliveryStatus = deliveryStatus;
        this.deliveryDate = deliveryDate;
    } //end constructor

    //Gets the delivery number
    public int getDeliveryID() {
        return deliveryID;
    } //end getDeliveryNumber

    //Gets the delivery status
    public boolean getDeliveryStatus() {
        return deliveryStatus;
    } //end getDeliveryStatus

    //Gets the delivery date of the order;
    public int getDeliveryDate() {
        return deliveryDate;
    } //end getDeliveryDate

    //gets the estimated time (in minutes) that it will take to get to the customer's house.
    public int getEstimatedTime() {
        return estimatedTime;
    } //end calculateEstimatedTime

    //method to mark a delivery as delivered. Will only do something if the deliveryStatus is false
    public void markAsDelivered(boolean deliveryStatus) {
        if (deliveryStatus == false)
            deliveryStatus = true;
    } //end markAsDelivered
} //end delivery class
