import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    private String[] foodArrMenu = {"Burger", "Ramen", "Pizza", "Sushi", "Fried Chicken"};
    private Cart cart =  new Cart();


    public void mainMenu(){
        boolean isInUse = true;
        try{
            while(isInUse){
                System.out.println("Select an option: ");
                System.out.println("1)View menu");
                System.out.println("2)Add item to cart");
                System.out.println("3)View cart");
                System.out.println("4)View monthly revenue");
                System.out.println("5)Checkout and Exit");
                System.out.println("6)Exit");

                int userInput = scan.nextInt();

                switch (userInput){
                    case 1:
                        System.out.println("Food Menu: ");
                        printMenu(foodArrMenu);
                        break;
                    case 2:
                        addItemToCart();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        isInUse = false;
                        break;
                }

            }
        }catch(Exception e){

        }


    }

    public void printMenu(String[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println((i+1) + ". " + array[i]);
        }
    }

    public void addItemToCart(){
        try {
            RestaurantItemFactory factory = new RestaurantItemFactory();
            System.out.println("What type of item would you like to order(food/beverage/dessert)?");
            String foodType = scan.next();
            switch (foodType){
                case "food":
                    printMenu(foodArrMenu);
                    break;
                case "beverage" :
                    break;
                case "dessert":
                    break;
            }
            IRestaurantItem restaurantItem = factory.createRestaurantItem(foodType.toLowerCase());
            cart.addItem(restaurantItem);
        }catch (Exception e){
            e.getMessage();
        }
    }


}