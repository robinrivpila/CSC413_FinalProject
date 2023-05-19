/**
 * The Food class implements the IRestaurantItem
 * interface. It stores important information about
 * a food item, such as its name, price and notes.
 * It provides methods that allow other classes to
 * access the member variables that are private.
 */
public class Food implements IRestaurantItem{
    private String name;
    private double price;
    private String notes;

    /**
     * Class constructor that initializes the
     * name, price, and notes of the Food
     * object
     * @param name
     * @param price
     * @param notes
     */
    public Food(String name,double price,  String notes){
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

    String getNotes(){
        return notes;
    }

    void setName(String newName){
        this.name = name;
    }

    void setPrice(double newPrice){
        this.price = price;
    }

    void setNotes(String newNotes){
        this.notes = notes;
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
     * the name of the food and its price.
     */
    @Override
    public void printGeneralInfo(){
        System.out.print(name + " " + "$" + price + "\n");
    }
}
