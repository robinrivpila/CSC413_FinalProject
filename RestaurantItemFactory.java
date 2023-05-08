import java.util.Scanner;

public class RestaurantItemFactory {
    public static IRestaurantItem createRestaurantItem(String type){
        Scanner scan = new Scanner(System.in);

        switch(type.toLowerCase()){
            case "food":
                System.out.println("");
                break;
            case "beverage" :
                break;
            case "dessert" :
                break;
        }
        return null;
    }




}
