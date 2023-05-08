public class Food implements IRestaurantItem{
    private String name;
    private Size size;
    private double price;
    private String notes;

    public Food(String name, Size size, double price, String notes){
        this.name = name;
        this.size = size;
        this.price = price;
        this.notes = notes;
    }



    @Override
    public void printItemInfo() {

    }

    @Override
    public String getType() {
        return null;
    }
}
