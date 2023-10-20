public class item {
    String name;
    String description;
    double price;

    public item(String name, String description, double price) {
        //the items attributes 
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //getters  
    public String itemName() {
        return this.name;
    }

    public String description() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

}
