import java.util.ArrayList;

public class Cart {
    private ArrayList<IRestaurantItem> cart = new ArrayList<IRestaurantItem>();
    private double subtotal;
    private double total;
    private double tip;

    public Cart(){

    }

    void addItem(IRestaurantItem newItem){
        cart.add(newItem);
        subtotal += newItem.getPrice();
    }

    void printCartContents(){
        System.out.println("----------CART ITEM(S)----------");
        for(int i = 0; i < cart.size(); i ++){
            cart.get(i).printItemInfo();

        }

        System.out.println("SUBTOTAL: " + subtotal );
        System.out.println("--------------------------------");
    }




}
