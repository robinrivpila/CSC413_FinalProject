public class Food implements IRestaurantItem{
    private String name;
    private double price;
    private String notes;

    public Food(String name, String notes){
        this.name = name;
        price = 5.50;
        this.notes = notes;
    }

    String getName(){
        return name;
    }
    double getPrice(){
        return price;
    }

    String getNotes(){
        return notes;
    }

    void setName(String newName){
        this.name = name;
    }

    void setPrice(double newPrice){
        this.price = price;
    }

    void setNotes(String newNotes){
        this.notes = notes;
    }
    @Override
    public void printItemInfo() {
        System.out.println("\n" + name +
                            " $" + price +
                            "\n"  + "\t-" + notes);
    }

}
