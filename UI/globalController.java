package UI;
import Model.order;

public class globalController {
    private static globalController globalcontroller;
    private order Order;
    private boolean loggedIn;

    //private constructor to prevent instantiation of the object from the outside. This helps create only one instance of the object at a time.
    private globalController() {
        loggedIn = false;
        Order = new order(0, 0, 0, 0);
    }

    //make sure that there is only one instantiation at a time. Ensures only one user can use the application at a time.
    public static globalController instantiateGlobalController() {
        if (globalcontroller == null)
            globalcontroller = new globalController();
        return globalcontroller;
    }
    
    //method to return the login status
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    //method to update if a customers logs in or logs out
    public void changeLoggedIn(boolean updatedLoggedIn) {
        loggedIn = updatedLoggedIn;
    }

    //method to return the order that is associated with the customer.
    public order getOrder() {
        return Order;
    }
}
