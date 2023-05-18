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
     * Class constructor
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
    @Override
    public void printItemInfo() {
        System.out.println("\n" + name +
                " $" + price +
                "\n"  + "\t-" + sweetnessLevel + "%" + " sweetness"
        );
    }

    @Override
    public void printGeneralInfo(){
        System.out.print(name + " " + "$" + price + "\n");
    }

}
