import java.util.ArrayList;

public class Cart {
    private ArrayList<IRestaurantItem> cart;
    private double subtotal;
    private double total;
    private double tip;

    public Cart(){
        subtotal = 0;
        total = 0;
        tip = 0;
        cart = new ArrayList<IRestaurantItem>();
    }

    public void addItem(IRestaurantItem newItem){
        cart.add(newItem);
        subtotal += newItem.getPrice();
    }

    public double getSubtotal(){
        return subtotal;
    }

    public double getTip(){
        return tip;
    }

    public double getTotal(){
        return total;
    }
    public void setTip(double newTip){
        this.tip = newTip;
    }

    public double calculateCartTotal(){
        total = subtotal + tip;
        return total;
    }


    public void printCartContents(){
        System.out.println("----------CART ITEM(S)----------");
        for(int i = 0; i < cart.size(); i ++){
            cart.get(i).printItemInfo();

        }

        System.out.println("SUBTOTAL: " + subtotal );
        System.out.println("--------------------------------");
    }

    public void printBill(){
        printCartContents();
        System.out.println("TIP: " + tip);
        System.out.println("--------------------------------");
        System.out.println("TOTAL: " +  calculateCartTotal());
    }

    public double calculateTip(double percent){
        double percentToDecimal = percent * .01;
        tip = subtotal*percentToDecimal;
        return tip;
    }



}
