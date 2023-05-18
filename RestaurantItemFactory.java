
import java.util.Scanner;

public class RestaurantItemFactory {
    public static IRestaurantItem createRestaurantItem(String type, IRestaurantItem[] menuArray){
        Scanner scan = new Scanner(System.in);
        boolean isTrue = true;
        switch(type.toLowerCase()){
            case "food":

                while(isTrue){
                    itemNumberMessage();
                    int foodItemNum = scan.nextInt();

                    if(isValidAnswer(foodItemNum)) {
                        itemPreferenceMsg(type);
                        scan.nextLine();
                        String notes = scan.nextLine();

                        Food newFood;
                        if (notes.equalsIgnoreCase("no")) {
                            newFood = new Food(((Food) menuArray[foodItemNum - 1]).getName(), ((Food) menuArray[foodItemNum - 1]).getPrice(), "");
                        } else {
                            newFood = new Food(((Food) menuArray[foodItemNum - 1]).getName(), ((Food) menuArray[foodItemNum - 1]).getPrice(), notes);
                        }
                        isTrue = false;
                        return newFood;
                    }else{
                        invalidMessage();
                    }
                }
            case "beverage" :
                while (isTrue) {
                    itemNumberMessage();
                    int bevItemNum = scan.nextInt();
                    if(isValidAnswer(bevItemNum)) {
                        System.out.println("Sweetness level? (0-100)");
                        int sweetnessLvl = scan.nextInt();
                        Beverage newBev = new Beverage(((Beverage) menuArray[bevItemNum - 1]).getName(), sweetnessLvl, ((Beverage) menuArray[bevItemNum - 1]).getPrice());
                        isTrue = false;
                        return newBev;
                    }else{
                        invalidMessage();
                    }
                }
            case "dessert" :
                while(isTrue) {
                    itemNumberMessage();
                    int dessertItemNum = scan.nextInt();
                    if(isValidAnswer(dessertItemNum)) {
                        itemPreferenceMsg(type);
                        scan.next();
                        String notes = scan.nextLine();
                        Dessert newDessert;
                        if (notes.equalsIgnoreCase("no")) {
                            newDessert = new Dessert(((Dessert) menuArray[dessertItemNum - 1]).getName(), ((Dessert) menuArray[dessertItemNum - 1]).getPrice(), "");
                        } else {
                            newDessert = new Dessert(((Dessert) menuArray[dessertItemNum - 1]).getName(), ((Dessert) menuArray[dessertItemNum - 1]).getPrice(), notes);
                        }
                        isTrue = false;
                        return newDessert;
                    }else{
                        invalidMessage();
                    }
                }
        }
        return null;
    }

    private static boolean isValidAnswer(int userInput){
        if(userInput == 1 || userInput == 2|| userInput == 3|| userInput ==4||userInput ==5){
            return true;
        }else{
            return false;
        }
    }

    private static void invalidMessage(){
        System.out.println("Sorry that is not valid input-");
    }

    private static void itemNumberMessage(){
        System.out.println("Which item number would you like to add to cart? ");
    }

    private static void itemPreferenceMsg(String type){
        System.out.println("Do you have any specific preferences for your " + type + " item?");
    }



}
