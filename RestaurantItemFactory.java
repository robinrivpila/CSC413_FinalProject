
import java.util.Scanner;

/**
 * The RestaurantItemFactory class is where
 * restaurant item objects, such as, food, beverage,
 * and dessert are created. This is to hide the
 * complexity of some of the creations and also
 * to centralize the making of objects to one
 * class.
 */
public class RestaurantItemFactory {
    /**
     * The createRestaurantItem method takes in a users input for
     * the type of food that they want to create and also the menu
     * array that corresponds to the restaurant item type. It
     * asks the users for their preferences on the food items
     * and then returns the fully created items.
     * @param type String the type of restaurant item that the
     *             user wants.
     * @param menuArray IRestaurantItem[] is the array that
     *                  corresponds with the type.
     * @return IRestaurantItem object that the user requested.
     */
    public static IRestaurantItem createRestaurantItem(String type, IRestaurantItem[] menuArray){

        Scanner scan = new Scanner(System.in);
        boolean isTrue = true;

        switch(type.toLowerCase()){
            case "food":
                /*
                if user gives an invalid answer, the program will
                keep asking the user which item number they would
                like
                 */
                while(isTrue){
                    itemNumberMessage();
                    int foodItemNum = scan.nextInt();

                    /*
                    if user input is valid, then the process of asking
                        for the users other preferences resumes
                     */
                    if(isValidAnswer(foodItemNum)) {
                        itemPreferenceMsg(type);
                        scan.nextLine();
                        String notes = scan.nextLine();
                        Food newFood;

                        /*Food objects are created with either notes or no notes*/
                        if (notes.equalsIgnoreCase("no")) {
                            newFood = new Food(((Food) menuArray[foodItemNum - 1]).getName(), ((Food) menuArray[foodItemNum - 1]).getPrice(), "");
                        } else {
                            newFood = new Food(((Food) menuArray[foodItemNum - 1]).getName(), ((Food) menuArray[foodItemNum - 1]).getPrice(), notes);
                        }

                        isTrue = false; /*ends the while loop once Food item is successfully made*/
                        return newFood;
                    }else{
                        invalidMessage();   /*prints out an invalid msg if user enteres an invalid item number*/
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

    /**
     * The isValidAnswer method takes in a parameter
     * of type int and using logic, determines if the
     * users answer was a valid input.
     * @param userInput int the users input
     * @return boolean true if the users input is
     *          valid and false if it is invalid.
     */
    private static boolean isValidAnswer(int userInput){
        if(userInput == 1 || userInput == 2|| userInput == 3|| userInput ==4||userInput ==5){
            return true;
        }else{
            return false;
        }
    }
    /**
     * The invalidMessage method prints out a message
     * that lets the user know that the input that they
     * put in was invalid.
     */
    private static void invalidMessage(){
        System.out.println("Sorry that is not valid input-");
    }

    /**
     * A method that prints out the prompt for the user
     * to answer for which item number they would like
     * to add to the cart.
     */
    private static void itemNumberMessage(){
        System.out.println("Which item number would you like to add to cart? ");
    }
    /**
     * The itemPreferenceMsg method prompts the
     * user to input any specific preferences or
     * allergy concerns that they may have for their
     * restaurant item.
     * @param type String the type of restaurant item
     *             the user is ordering.
     */
    private static void itemPreferenceMsg(String type){
        System.out.println("Do you have any specific preferences for your " + type + " item?");
    }



}
