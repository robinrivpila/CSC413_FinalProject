import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * The Cart class has an array list that holds
 * all of the IRestaurantItem objects that a
 * user adds to their cart. It also stores the
 * subtotal, total, and a tip that the user
 * chooses.
 */
public class Cart {
    private ArrayList<IRestaurantItem> cart;
    private double subtotal;
    private double total;
    private double tip;
    private LocalDate date;

    /**
     * Class constructor that initializes the
     * subtotal, total, and tip to 0 every
     * time that a cart is created. It also
     * initializes the array list that holds the
     * IRestaurantItem objects aswell as the
     * current date that the cart was made.
     */
    public Cart(){
        subtotal = 0;
        total = 0;
        tip = 0;
        cart = new ArrayList<IRestaurantItem>();
        date = LocalDate.now();
    }

    /**
     * The addItem() method adds an item to the
     * cart ArrayList and also adds the amount of the
     * new item to the subtotal of the cart.
     * @param newItem IRestaurantItem holds the
     *                data of the new restaurant
     *                item that will be added to
     *                the current cart.
     */
    public void addItem(IRestaurantItem newItem){
        cart.add(newItem);
        subtotal += newItem.getPrice();
    }

    public ArrayList<IRestaurantItem> getCart(){
        return cart;
    }
    public double getSubtotal(){
        return subtotal;
    }

    public double getTip(){
        return tip;
    }

    public LocalDate getDate(){
        return date;
    }

    public Month getMonth(){
        return date.getMonth();
    }
    public double getTotal(){
        return total;
    }
    public void setTip(double newTip){
        this.tip = newTip;
    }

    public void setCart(ArrayList<IRestaurantItem> newCart){
        this.cart = newCart;
    }

    public void setSubtotal(double newSubtotal){
        this.subtotal = newSubtotal;
    }

    public void setTotal(double newTotal){
        this.total = newTotal;
    }

    /**
     * The calculateCartTotal() method computes the
     * sum of the subtotal and tip.
     * @return double the cart total.
     */
    public double calculateCartTotal(){
        total = subtotal + tip;
        return total;
    }

    /**
     * The resetCart() method clears the cart
     * arraylist as well as resets the subtotal,
     * total, and tip value to 0.
     */
    public void resetCart() {
        cart.clear();
        subtotal = 0;
        total = 0;
        tip = 0;
    }

    /**
     * The printCartContents() method prints
     * out the Date that the cart was opened.
     * It also prints out all of the cart
     * contents, the subtotal, tip, and total.
     */
    public void printCartContents(){
        System.out.println("DATE: " + date);
        System.out.println("----------CART ITEM(S)----------");
        for(int i = 0; i < cart.size(); i ++){
            cart.get(i).printItemInfo();

        }

        System.out.printf("SUBTOTAL: $%.2f\n", subtotal );
        System.out.println("--------------------------------");
    }

    /**
     * The printBill() method prints out the
     * full carts contents, the tip, and the
     * full carts totals.
     */
    public void printBill(){
        printCartContents();
        System.out.printf("TIP: %.2f\n", tip );
        System.out.println("--------------------------------");
        System.out.printf("TOTAL: %.2f\n",  calculateCartTotal());
        System.out.println("--------------------------------");
    }

    /**
     * The calculateTip method takes a double
     * input and converts it to the decimal
     * equivalent and uses this to calculate
     * the desired tip amount and returns the
     * value.
     * @param percent is a double value of the
     *                tip percentage that the
     *                user chooses.
     * @return double tip and returns the double
     * value of the tip.
     */
    public double calculateTip(double percent){
        double percentToDecimal = percent * .01;
        tip = subtotal*percentToDecimal;
        return tip;
    }







}

