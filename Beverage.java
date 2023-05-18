import java.time.LocalDate;

/**
 *The Beverage class implements the IRestaurantItem
 * interface. It stores important information about
 * a beverage, such as its name, sweetness level,
 * and its price. It provided methods that allow
 * other classes to access the member variables that
 * are private.
 */
public class Beverage implements IRestaurantItem{
    private String name;
    private int sweetnessLevel;
    private double price;

    /**
     * Class constructor that initializes
     * the name, the sweetness level, and
     * the price of the beverage object
     * @param name
     * @param sweetnessLevel
     * @param price
     */
    public Beverage(String name, int sweetnessLevel, double price){
        this.name = name;
        this.sweetnessLevel = sweetnessLevel;
        this.price = price;
    }

    String getName(){
        return name;
    }

    int getSweetnessLevel(){
        return sweetnessLevel;
    }

    @Override
    public double getPrice(){
        return price;
    }

    /**
     * This method prints out the specifics
     * of the beverage method that includes
     * its name, price, and sweetness percent
     */
    @Override
    public void printItemInfo() {
        System.out.println("\n" + name +
                " $" + price +
                "\n"  + "\t-" + sweetnessLevel + "%" + " sweetness"
        );
    }

    /**
     * This method prints out the general information
     * about the object, and that includes only
     * the name of the beverage and its price.
     */
    @Override
    public void printGeneralInfo(){
        System.out.print(name + " " + "$" + price + "\n");
    }

}
