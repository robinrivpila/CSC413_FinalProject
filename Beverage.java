public class Beverage implements IRestaurantItem{
    private String name;
    private int sweetnessLevel;
    private IceLevel iceLevel;
    private double price;

    public Beverage(String name, int sweetnessLevel, IceLevel iceLevel, double price){
        this.name = name;
        this.sweetnessLevel = sweetnessLevel;
        this.iceLevel = iceLevel;
        this.price = price;
    }

    String getName(){
        return name;
    }

    int getSweetnessLevel(){
        return sweetnessLevel;
    }

    String getIceLevelString(){
        return iceLevel.name();
    }

    IceLevel getIceLevel(){
        return iceLevel;
    }

    @Override
    public double getPrice(){
        return price;
    }
    @Override
    public void printItemInfo() {
        System.out.println("\n" + name +
                " $" + price +
                "\n"  + "\t-" + sweetnessLevel + " sweetness" +
                "\n" + "\t-" + iceLevel.name() + " ice");
    }

    @Override
    public void printGeneralInfo(){
        System.out.print(name + " " + "$" + price + "\n");
    }

}
