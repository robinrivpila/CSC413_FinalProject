import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    Food foodItem1 = new Food("Burger" , 5.50, "");
    Food foodItem2 = new Food("Ramen", 9.25, "");
    Food foodItem3 = new Food("Medium Pizza",10.75, "" );
    Food foodItem4 = new Food("California roll", 8.45, "" );
    Food foodItem5 = new Food("Whole Fried Chicken", 20.60, "");
    Beverage bevItem1 = new Beverage("Ice Tea", 0, IceLevel.REGULAR, 1.50);
    Beverage bevItem2 = new Beverage("Mango Lemonade", 0, IceLevel.REGULAR, 2.50);
    Beverage bevItem3 = new Beverage("Thai Ice Tea w/ Boba", 0, IceLevel.REGULAR, 4.50);
    Beverage bevItem4 = new Beverage("Coffee", 0, IceLevel.REGULAR, 1.25);
    Beverage bevItem5 = new Beverage("Water", 0, IceLevel.REGULAR, 0.00);
    Dessert dessertItem1 = new Dessert("Pizookie", 9.50, "");
    Dessert dessertItem2 = new Dessert("Chocolate Cake slice" , 5.00, "" );
    Dessert dessertItem3 = new Dessert("Original Cheese Cake Slice",7.50, "" );
    Dessert dessertItem4 = new Dessert("Ice Cream", 2.70, "");
    Dessert dessertItem5 = new Dessert("Lava Brownie Cake", 8.50, "");
    private Food[] foodArrMenu = {foodItem1, foodItem2, foodItem3, foodItem4, foodItem5};
    private Beverage[] bevArrMenu = {bevItem1, bevItem2, bevItem3, bevItem4,bevItem5};
    private Dessert[] dessertArrMenu = {dessertItem1, dessertItem2, dessertItem3, dessertItem4, dessertItem5};


    private Cart cart =  new Cart();
    private ArrayList<Cart> carts = new ArrayList<Cart>();


    public void mainMenu(){
        boolean isInUse = true;
        try{
            while(isInUse){
                System.out.println("Select an option: ");
                System.out.println("1)View menu");
                System.out.println("2)Add item to cart");
                System.out.println("3)View cart");
                System.out.println("4)Checkout and Exit");
                System.out.println("5)View daily revenue");
                System.out.println("6)Exit");

                int userInput = scan.nextInt();

                switch (userInput){
                    case 1:
                        System.out.println("Food Menu: ");
                        printMenu(foodArrMenu);
                        System.out.println("Beverage Menu:");
                        printMenu(bevArrMenu);
                        System.out.println("Dessert Menu");
                        printMenu(dessertArrMenu);
                        break;
                    case 2:
                        //Cart newCart = createCart();
                        //carts.add(newCart);
                        addItemToCart();
                        break;
                    case 3:
                        viewCart();
                        break;
                    case 4:
                        checkOut();
                        break;
                    case 5:
                        break;
                    case 6:
                        //MAKE A "ARE YOU SURE YOU WANT TO EXIT" METHOD
                        isInUse = false;
                        break;
                }

            }
        }catch(Exception e){

        }


    }

    public void printMenu(IRestaurantItem[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print((i+1) + ". " );
            array[i].printGeneralInfo();

        }
    }

    public void addItemToCart(){
        try {
            RestaurantItemFactory factory = new RestaurantItemFactory();
            System.out.println("What type of item would you like to order(food/beverage/dessert)?");
            String foodType = scan.next();
            IRestaurantItem restaurantItem = null;
            switch (foodType.toLowerCase()){
                case "food":
                    printMenu(foodArrMenu);
                   restaurantItem = factory.createRestaurantItem(foodType.toLowerCase(),foodArrMenu);
                    break;
                case "beverage" :
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
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void viewCart(){
        cart.printCartContents();
    }

    public void checkOut(){
        System.out.println("Would you like to checkout? (yes/no)");
        String userCheckoutChoice = scan.next();
        System.out.println("Users choice: " + userCheckoutChoice);
        if(userCheckoutChoice.equals("yes")) {
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

    public Cart createCart(){
        Cart newCart = new Cart();
        return newCart;
    }




}