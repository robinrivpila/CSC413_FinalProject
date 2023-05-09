import java.sql.SQLOutput;
import java.util.Scanner;

public class RestaurantItemFactory {
    public static IRestaurantItem createRestaurantItem(String type){
        Scanner scan = new Scanner(System.in);

        switch(type.toLowerCase()){
            case "food":
                System.out.println("Which item would you like to add to cart? ");
                String foodItem = scan.next();
                System.out.println("Do you have any specific preferences for your food item? ");
                scan.nextLine();
                String notes = scan.nextLine();
                Food newFood = new Food(foodItem, notes);
                return newFood;
            case "beverage" :
                System.out.println("Which item would you like to add to cart? ");
                String bevItem = scan.nextLine();
                System.out.println("Sweetness level? (0-100)");
                int sweetnessLvl = scan.nextInt();
                System.out.println("Ice level? ()");
                //WOW HOW SHOULD I PARSE THIS

                break;
            case "dessert" :
                break;
        }
        return null;
    }




}
