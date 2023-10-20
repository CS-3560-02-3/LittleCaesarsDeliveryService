public class item {
    String itemName;
    String description;
    double price;

    public item(String item, String description, double price) {
        //the items attributes 
        this.itemName = item;
        this.description = description;
        this.price = price;
    }

    //getters 
    public String itemName() {
        return this.itemName;
    }

    public String description() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

}
