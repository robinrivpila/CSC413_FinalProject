import java.util.ArrayList;

public class Cart {
    private ArrayList<IRestaurantItem> cart = new ArrayList<IRestaurantItem>();

    public Cart(){

    }

    void addItem(IRestaurantItem newItem){
        cart.add(newItem);
    }



}
