import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);

    //FOOD PORTION OF THE MENU
    private final Food foodItem1 = new Food("Burger" , 5.50, "");
    private final Food foodItem2 = new Food("Ramen", 9.25, "");
    private final Food foodItem3 = new Food("Medium Pizza",10.75, "" );
    private final Food foodItem4 = new Food("California roll", 8.45, "" );
    private final Food foodItem5 = new Food("Whole Fried Chicken", 20.60, "");
    private final Food[] foodArrMenu = {foodItem1, foodItem2, foodItem3, foodItem4, foodItem5};

    //BEVERAGE PORTION OF MENU
    private final Beverage bevItem1 = new Beverage("Ice Tea", 0,  1.50);
    private final Beverage bevItem2 = new Beverage("Mango Lemonade", 0,  2.50);
    private final Beverage bevItem3 = new Beverage("Thai Ice Tea w/ Boba", 0,  4.50);
    private final Beverage bevItem4 = new Beverage("Coffee", 0,  1.25);
    private final Beverage bevItem5 = new Beverage("Water", 0,  0.00);
    private final Beverage[] bevArrMenu = {bevItem1, bevItem2, bevItem3, bevItem4,bevItem5};

    //DESSERT PORTION OF MENU
    private final Dessert dessertItem1 = new Dessert("Pizookie", 9.50, "");
    private final Dessert dessertItem2 = new Dessert("Chocolate Cake slice" , 5.00, "" );
    private final Dessert dessertItem3 = new Dessert("Original Cheese Cake Slice",7.50, "" );
    private final Dessert dessertItem4 = new Dessert("Ice Cream", 2.70, "");
    private final Dessert dessertItem5 = new Dessert("Lava Brownie Cake", 8.50, "");
    private final Dessert[] dessertArrMenu = {dessertItem1, dessertItem2, dessertItem3, dessertItem4, dessertItem5};

    private Cart cart =  new Cart();    //STORES ALL CARTS FROM ALL PEOPLES ORDERS
    private ArrayList<Cart> carts = new ArrayList<Cart>(); //STORES CURRENT USERS CART


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
                System.out.println("6)Exit");

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

    private void printMenu(IRestaurantItem[] array){
        //RUNS THROUGH ALL OF ITEMS IN CART ARRAY
        //AND PRINTS OUT GENERAL INFO
        for(int i = 0; i < array.length; i++){
            System.out.print((i+1) + ". " );
            array[i].printGeneralInfo();
        }
    }

    private void addItemToCart(){
        try {
            boolean isTrue = true;
            RestaurantItemFactory factory = new RestaurantItemFactory();
            while(isTrue) {
                System.out.println("What type of item would you like to order(food/beverage/dessert)?");
                String foodType = scan.next();
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
                    cart.addItem(restaurantItem);
                    isTrue = false;
                }else{
                    invalidMessage();
                }
            }

        }catch (Exception e){
            e.getMessage();
        }
    }

    private void viewCart(){
        cart.printCartContents();
    }

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

    private Cart createCart(){
        Cart newCart = new Cart();
        return newCart;
    }

    private void showCarts(){
        for(Cart cart: carts){
            System.out.println("CART: ");
            cart.printBill();
        }
    }

    private Cart copyCartContents(Cart cart){
        Cart newCart = new Cart();
        newCart.setCart(cart.getCart());
        newCart.setSubtotal(cart.getSubtotal());
        newCart.setTotal(cart.getTotal());
        newCart.setTip(cart.getTip());
        return newCart;
    }



    private double calculateMonthlyTotal(int month){
        double monthlyTotal = 0;
        for(int i = 0; i < carts.size(); i++){
            if(carts.get(i).getMonth().getValue() == month){
                monthlyTotal += carts.get(i).getTotal();
            }
        }
        return monthlyTotal;
    }

    private double calculateMonthlyTips(int month){
        double monthlyTips = 0;
        for(int i = 0; i < carts.size(); i++){
            if(carts.get(i).getMonth().getValue() == month){
                monthlyTips += carts.get(i).getTip();
            }
        }
        return monthlyTips;
    }

    private void invalidMessage(){
        System.out.println("Sorry that is not valid input-");
    }

    private boolean isValidAnswer(int userInput){
        if(userInput == 1 || userInput == 2|| userInput == 3|| userInput ==4||userInput ==5|| userInput == 6){
            return true;
        }else{
            return false;
        }
    }

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