import java.util.Scanner;

public class RestaurantItemFactory {
    public static IRestaurantItem createRestaurantItem(String type){
        Scanner scan = new Scanner(System.in);

        switch(type){
            case "Food":
                System.out.println();
                break;
            case "Beverage" :
                break;
            case "Dessert" :
                break;
        }
        return null;
    }

    public static void getDetailedMessage(String type){
        System.out.println("What kind of item are you ordering (food/beverage/dessert)");
    }

}
