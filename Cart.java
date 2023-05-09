import java.util.ArrayList;

public class Cart {
    private ArrayList<IRestaurantItem> cart = new ArrayList<IRestaurantItem>();

    public Cart(){

    }

    void addItem(IRestaurantItem newItem){
        cart.add(newItem);
    }

    void printCartContents(){
        for(int i = 0; i < cart.size(); i ++){
            cart.get(i).printItemInfo();

        }
    }



}
