public class Dessert implements IRestaurantItem{
    private String name;

    private double price;
    private String notes;

    public Dessert(String name, double price, String notes){
        this.name = name;
        this.price = price;
        this.notes = notes;
    }

    String getName(){
        return name;
    }

    @Override
    public double getPrice(){
        return price;
    }

    void setName(String newName){
        this.name = newName;
    }

    void setPrice(double newPrice){
        this.price = newPrice;
    }
    @Override
    public void printItemInfo() {
        System.out.println("\n" + name +
                " $" + price +
                "\n"  + "\t-" + notes);
    }

    @Override
    public void printGeneralInfo() {
        System.out.print(name + " " + "$" + price + "\n");
    }
}
