import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Menu class is the restaurant user interface.
 * It is meant to let a user have simpler interactions
 * in order to get their order items without having
 * to see any unnecessary behind the scenes actions.
 */
public class Menu {
    Scanner scan = new Scanner(System.in);
    /**
     * The following Food objects are apart of the food menu and are final
     * because they do not chance throughout the whole program.
     */
    private final Food foodItem1 = new Food("Burger" , 5.50, "");
    private final Food foodItem2 = new Food("Ramen", 9.25, "");
    private final Food foodItem3 = new Food("Medium Pizza",10.75, "" );
    private final Food foodItem4 = new Food("California roll", 8.45, "" );
    private final Food foodItem5 = new Food("Whole Fried Chicken", 20.60, "");
    private final Food[] foodArrMenu = {foodItem1, foodItem2, foodItem3, foodItem4, foodItem5};

    /**
     * The following Beverage objects are apart of the beverage meny
     */
    private final Beverage bevItem1 = new Beverage("Ice Tea", 0,  1.50);
    private final Beverage bevItem2 = new Beverage("Mango Lemonade", 0,  2.50);
    private final Beverage bevItem3 = new Beverage("Thai Ice Tea w/ Boba", 0,  4.50);
    private final Beverage bevItem4 = new Beverage("Coffee", 0,  1.25);
    private final Beverage bevItem5 = new Beverage("Water", 0,  0.00);
    private final Beverage[] bevArrMenu = {bevItem1, bevItem2, bevItem3, bevItem4,bevItem5};

    /**
     * The following Dessert objects are a part of the dessert menu
     */
    private final Dessert dessertItem1 = new Dessert("Pizookie", 9.50, "");
    private final Dessert dessertItem2 = new Dessert("Chocolate Cake slice" , 5.00, "" );
    private final Dessert dessertItem3 = new Dessert("Original Cheese Cake Slice",7.50, "" );
    private final Dessert dessertItem4 = new Dessert("Ice Cream", 2.70, "");
    private final Dessert dessertItem5 = new Dessert("Lava Brownie Cake", 8.50, "");
    private final Dessert[] dessertArrMenu = {dessertItem1, dessertItem2, dessertItem3, dessertItem4, dessertItem5};

    /**
     * The cart stores a current users order items
     */
    private Cart cart =  new Cart();
    /**
     * The carts arraylist stores all of the carts that
     * previous users have used and checkouted with.
     */
    private ArrayList<Cart> carts = new ArrayList<Cart>();


    /**
     * The mainMenu method gives the users options
     * and takes in those responses and executes the
     * corresponding action. Actions that are included
     * in this are, viewing the menu, adding items to
     * the cart, view cart, checkout and exit, view
     * monthly revenue, and exit and save contents.
     */
    public void mainMenu(){

        boolean isInUse = true;

        try {
            while (isInUse) {

                System.out.println("Select an option: ");
                System.out.println("1)View menu");
                System.out.println("2)Add item to cart");
                System.out.println("3)View cart");
                System.out.println("4)Checkout and Exit");
                System.out.println("5)View monthly revenue");
                System.out.println("6)Exit and Save");

                int userInput = scan.nextInt();

                if (isValidAnswer(userInput)) {

                    switch (userInput) {
                        case 1:
                            System.out.println("Food Menu: ");
                            printMenu(foodArrMenu);

                            System.out.println("Beverage Menu:");
                            printMenu(bevArrMenu);

                            System.out.println("Dessert Menu");
                            printMenu(dessertArrMenu);
                            break;
                        case 2:
                            addItemToCart();
                            break;
                        case 3:
                            viewCart();
                            break;
                        case 4:
                            checkOut();

                            Cart newCart = copyCartContents(cart); //makes new cart with current cart contents
                            carts.add(newCart);                     //adds new cart to the carts that store all ppls orders
                            cart.resetCart();                       //empties the original cart
                            break;
                        case 5:
                            viewMonthlyRevenue();
                            break;
                        case 6:
                            saveAsCSV();

                            isInUse = false;
                            break;
                    }
                }else{
                    invalidMessage();
                }
            }
        }catch(Exception e){
            e.getMessage();
        }
    }

    /**
     * The printMenu method takes in an array of
     * type IRestaurantItem and prints out its
     * contents
     * @param array IRestaurantItem[] is either
     *              the Food menu, Dessert menu,
     *              or the Beverage menu.
     */
    private void printMenu(IRestaurantItem[] array){
        /*Runs through the whole array of menu items and prints out general info*/
        for(int i = 0; i < array.length; i++){
            System.out.print((i+1) + ". " );
            array[i].printGeneralInfo();
        }
    }

    /**
     * The addItemToCart method asks a user what
     * kind of item they would like, and they give
     * the user 3 options. Afterwords, it calls
     * the createRestaurantItem method that is in
     * the RestaurantItemFactory class and it
     * returns an IRestaurantItem object and adds
     * the item to the cart. If the user inputs an
     * incorrect input, it should reask the user
     * the question.
     */

    private void addItemToCart(){

        try {

            boolean isTrue = true;
            RestaurantItemFactory factory = new RestaurantItemFactory();

            while(isTrue) {

                System.out.println("What type of item would you like to order(food/beverage/dessert)?");
                String foodType = scan.next();

                /* Checks the users input to see if it matches one of the food types */
                if (foodType.equalsIgnoreCase("food") || foodType.equalsIgnoreCase("beverage") || foodType.equalsIgnoreCase("dessert")) {

                    IRestaurantItem restaurantItem = null;
                    switch (foodType.toLowerCase()) {
                        case "food":
                            printMenu(foodArrMenu);
                            restaurantItem = factory.createRestaurantItem(foodType.toLowerCase(), foodArrMenu);
                            break;
                        case "beverage":
                            printMenu(bevArrMenu);
                            restaurantItem = factory.createRestaurantItem(foodType.toLowerCase(), bevArrMenu);
                            break;
                        case "dessert":
                            printMenu(dessertArrMenu);
                            restaurantItem = factory.createRestaurantItem(foodType.toLowerCase(), dessertArrMenu);
                            break;
                        default:
                    }

                    /* After successfully making a restaurant object it is added to the current user cart */
                    cart.addItem(restaurantItem);
                    isTrue = false; /* After adding an item, it exits the user out of this block */
                }else{
                    /* If user does not enter a valid food type then they will be given an invalid input msg */
                    invalidMessage();
                }
            }

        }catch (Exception e){
            e.getMessage();
        }
    }

    /**
     * The viewCart method prints out all of the
     * items that are currently in the users cart.
     */
    private void viewCart(){
        cart.printCartContents();
    }

    /**
     * The checkOut method asks the user if they
     * are ready to checkout and facilitates the
     * actions of asking if a user would like to give
     * a tip. It gets the users input and calls the
     * function that calculates the amount of tip
     * and lastly, prints out the bill.
     */

    private void checkOut(){

        System.out.println("Would you like to checkout? (y/n)");
        String userCheckoutChoice = scan.next();

        if(userCheckoutChoice.equals("y")) {

            System.out.println("Would you like to tip? (y/n)");
            String userTipQ = scan.next();

            if (userTipQ.equals("y")) {
                System.out.println("What percentage would you like to tip?(0-100)");
                double userTipPercent = scan.nextDouble();

                cart.calculateTip(userTipPercent);
                cart.printBill();

                System.out.println("Thank you for coming! Hope you enjoyed your meal!");

            }else{
                cart.printBill();
            }
        }
    }

    /**
     * The viewMonthlyRevenue method asks a user for a
     * password that should only be known by a staff
     * members. If the user gives the correct password
     * then they are asked what month's revenue they
     * want to view. Once they answer, the revenue and
     * tip for that month is printed out.
     */
    private void viewMonthlyRevenue(){

        String password = "password";
        boolean isTrue = true;

        while(isTrue) {

            System.out.println("To view monthly revenue you must input the staff password:");
            scan.nextLine();
            String userInputPassword = scan.nextLine();

            if (userInputPassword.equals(password)) {
                System.out.println("What months revenue would you like to view? ");
                System.out.println("Please enter a numerical value between 1-12");
                int monthNum = scan.nextInt();

                System.out.printf("Monthly Total Revenue: $%.2f\n",  calculateMonthlyTotal(monthNum));
                System.out.printf("Monthly Tip Revenue: $%.2f\n",  calculateMonthlyTips(monthNum));

                isTrue = false;
            } else {
                invalidMessage();
            }
        }
    }

    /**
     * The copyCartContents method copies the current
     * carts contents, subtotal, tip, and total to
     * a new cart and returns it.
     * @param cart Cart the cart that we want to be
     *             copied.
     * @return Cart a new cart that holds the
     *         current carts contents; a copy.
     */
    private Cart copyCartContents(Cart cart){

        Cart newCart = new Cart();
        /*
        * sets all of the new carts info to the info
        * of the desired cart that we want to copy
        */
        newCart.setCart(cart.getCart());
        newCart.setSubtotal(cart.getSubtotal());
        newCart.setTotal(cart.getTotal());
        newCart.setTip(cart.getTip());

        return newCart;
    }

    /**
     * The calculateMonthlyTotal method computes
     * the monthly revenue by looping through all
     * of the carts that are from that particular
     * month and adds up the total revenue for that
     * month.
     * @param month int the users desired month to
     *              know the total revenue
     * @return double gives the months total revenue.
     */
    private double calculateMonthlyTotal(int month){

        double monthlyTotal = 0;

        for(int i = 0; i < carts.size(); i++){

            if(carts.get(i).getMonth().getValue() == month){
                monthlyTotal += carts.get(i).getTotal();
            }

        }
        return monthlyTotal;
    }

    /**
     * The calculateMonthlyTip method computes
     * the monthly amount of tips by looping through
     * all of the carts that are from that particular
     * month and adds up the total amount of tips for
     * that month.
     * @param month int the users desired month to
     *              know the total tip amount
     * @return double gives the months total tip
     *          amount.
     */
    private double calculateMonthlyTips(int month){

        double monthlyTips = 0;

        for(int i = 0; i < carts.size(); i++){

            if(carts.get(i).getMonth().getValue() == month){
                monthlyTips += carts.get(i).getTip();
            }

        }

        return monthlyTips;
    }

    /**
     * The invalidMessage method prints out a message
     * that lets the user know that the input that they
     * put in was invalid.
     */
    private void invalidMessage(){
        System.out.println("Sorry that is not valid input-");
    }

    /**
     * The isValidAnswer method takes in a parameter
     * of type int and using logic, determines if the
     * users answer was a valid input.
     * @param userInput int the users input
     * @return boolean true if the users input is
     *          valid and false if it is invalid.
     */
    private boolean isValidAnswer(int userInput){

        if(userInput == 1 || userInput == 2|| userInput == 3|| userInput ==4||userInput ==5|| userInput == 6){
            return true;
        }else{
            return false;
        }

    }

    /**
     * The saveAsCSV method saves all of the the years
     * monthly revenues and all of the carts from each
     * month in a csv, along with their total tips.
     * @throws FileNotFoundException
     */
    public void saveAsCSV() throws FileNotFoundException {

        File csvFile = new File("restaurantMonthRevenue.csv");
        PrintWriter out = new PrintWriter(csvFile);

        out.println("date, subtotal, tip, total, monthly-revenue, monthly-tip");

        for(Cart cart: carts){
            out.printf( "%s, %.2f, %.2f, %.2f,,,\n" , cart.getDate().toString(), cart.getSubtotal(), cart.getTip(), cart.getTotal());
        }

        out.printf(",,,,%.2f,%.2f", calculateMonthlyTotal(cart.getDate().getMonth().getValue()),calculateMonthlyTips(cart.getDate().getMonth().getValue()));

        out.close();
    }
}