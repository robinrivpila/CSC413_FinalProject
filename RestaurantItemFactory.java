import java.sql.SQLOutput;
import java.util.Scanner;

public class RestaurantItemFactory {
    public static IRestaurantItem createRestaurantItem(String type, IRestaurantItem[] menuArray){
        Scanner scan = new Scanner(System.in);

        switch(type.toLowerCase()){
            case "food":
                System.out.println("Which item number would you like to add to cart? ");
                int foodItemNum = scan.nextInt();
                System.out.println("Do you have any specific preferences for your food item? ");
                scan.nextLine();
                String notes = scan.nextLine();
                Food newFood = new Food(((Food)menuArray[foodItemNum-1]).getName(),((Food)menuArray[foodItemNum-1]).getPrice(), notes);
                return newFood;
            case "beverage" :
                System.out.println("Which item number would you like to add to cart? ");
                int bevItemNum = scan.nextInt();
                System.out.println("Sweetness level? (0-100)");
                int sweetnessLvl = scan.nextInt();
                System.out.println("Ice level? (LESS/REGULAR/EXTRA) ");
                scan.next();
                String iceLevel = scan.nextLine();
                IceLevel iceLevelActual;
                if(iceLevel.equalsIgnoreCase("regular")){
                    iceLevelActual = IceLevel.REGULAR;
                }else if(iceLevel.equalsIgnoreCase("less")){
                    iceLevelActual = IceLevel.LESS;
                }else{
                    iceLevelActual = IceLevel.EXTRA;
                }
                Beverage newBev = new Beverage(((Beverage)menuArray[bevItemNum-1]).getName(), sweetnessLvl, iceLevelActual, ((Beverage)menuArray[bevItemNum-1]).getPrice());
                return newBev;
            case "dessert" :
                System.out.println("Which item number would you like to add to cart? ");
                int dessertItemNum = scan.nextInt();
                System.out.println("Do you have any specific preferences for your dessert item? ");
                scan.next();
                notes = scan.nextLine();
                Dessert newDessert = new Dessert(((Dessert)menuArray[dessertItemNum-1]).getName(),((Dessert)menuArray[dessertItemNum-1]).getPrice(), notes );
                return newDessert;
        }
        return null;
    }




}
