public class Beverage implements IRestaurantItem{
    private String name;
    private int sweetnessLevel;
    private IceLevel iceLevel;
    private float price;

    public Beverage(String name, int sweetnessLevel, IceLevel iceLevel, float price){
        this.name = name;
        this.sweetnessLevel = sweetnessLevel;
        this.iceLevel = iceLevel;
        this.price = price;
    }


    @Override
    public void printItemInfo() {

    }

    @Override
    public String getType() {
        return null;
    }
}
