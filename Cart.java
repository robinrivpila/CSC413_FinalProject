import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Cart {
    private ArrayList<IRestaurantItem> cart;
    private double subtotal;
    private double total;
    private double tip;

    private LocalDate date;

    public Cart(){
        subtotal = 0;
        total = 0;
        tip = 0;
        cart = new ArrayList<IRestaurantItem>();
        date = LocalDate.now();
    }

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
    public double calculateCartTotal(){
        total = subtotal + tip;
        return total;
    }

    public void resetCart()
    {
        cart.clear();
        subtotal = 0;
        total = 0;
        tip = 0;
    }

    public void printCartContents(){
        System.out.println("DATE: " + date);
        System.out.println("----------CART ITEM(S)----------");
        for(int i = 0; i < cart.size(); i ++){
            cart.get(i).printItemInfo();

        }

        System.out.printf("SUBTOTAL: $%.2f\n", subtotal );
        System.out.println("--------------------------------");
    }

    public void printBill(){
        printCartContents();
        System.out.printf("TIP: %.2f\n", tip );
        System.out.println("--------------------------------");
        System.out.printf("TOTAL: %.2f\n",  calculateCartTotal());
        System.out.println("--------------------------------");
    }

    public double calculateTip(double percent){
        double percentToDecimal = percent * .01;
        tip = subtotal*percentToDecimal;
        return tip;
    }







}

