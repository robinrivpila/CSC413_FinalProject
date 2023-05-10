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

    double getPrice(){
        return price;
    }
    @Override
    public void printItemInfo() {
        //NEED TO REFORMAT THE SAME WAY I DID FOR FOOD
        System.out.println("\nName: " + name +
                            "\nSweetness: " + sweetnessLevel +
                            "\nIce Level: " + iceLevel.name() +
                            "\nPrice: " + price);
    }

    @Override
    public void printGeneralInfo(){
        System.out.print(name + " " + "$" + price + "\n");
    }

}
