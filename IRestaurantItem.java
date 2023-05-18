/**
 * The IRestaurantItem interface has the printItemInfo()
 * method, the printGeneralInfo() method, and the
 * getPrice() method. It is meant to be implemented
 * with a class that is considered a restaurant item,
 * such as food, beverage, and dessert.
 */
public interface IRestaurantItem {
            /**
             * This method prints out all of the details of
             * each IRestaurantItem
             */
    public void printItemInfo();

            /**
             * This method is meant to print out only the
             * name of an IRestaurantItem and its price.
             */
    public void printGeneralInfo();

            /**
             * This method is meant to give public access
             * to the value of the price of an IRestaurantItem.
             * @return double This returns the price of the
             * IRestaurantItem object.
             */
    public double getPrice();

}
