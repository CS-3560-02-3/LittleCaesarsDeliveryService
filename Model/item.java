package Model;
public class item {
    //varibles
    private String name;
    private String description;
    private double price;

    public item(String name, String description, double price) {   
        //the items attributes 
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //getters 
     
    //gets item name
    public String name() {
        return this.name;
    }

    //gets description
    public String description() {
        return this.description;
    }

    //gets price
    public double getPrice() {
        return this.price;
    }

}