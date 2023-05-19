/**
 * The Dessert class implements the IRestaurantItem
 * interface. It stores important information about a
 * dessert, such as its name, price, and a users specific
 * preferences on a dessert(such as an allergy of peanuts).
 * It provides methods that allow other classes to access the
 * member variables that are private.
 */
public class Dessert implements IRestaurantItem{
    private String name;
    private double price;
    private String notes;

    /**
     * Class constructor that initialzes the
     * name, price, and notes of the Dessert
     * object
     * @param name
     * @param price
     * @param notes
     */
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
    /**
     * This method prints out the specifics
     * of the beverage method that includes
     * its name, price, and notes
     */
    @Override
    public void printItemInfo() {
        System.out.println("\n" + name +
                " $" + price +
                "\n"  + "\t-" + notes);
    }

    /**
     * This method prints out the general information
     * about the object, and that includes only
     * the name of the beverage and its price.
     */
    @Override
    public void printGeneralInfo() {
        System.out.print(name + " " + "$" + price + "\n");
    }
}
