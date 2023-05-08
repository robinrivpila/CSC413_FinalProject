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

    String getName(){
        return name;
    }
    Size getSize(){
        return size;
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

    void setSize(Size newSize){
        this.size = size;
    }

    void setPrice(double newPrice){
        this.price = price;
    }

    void setNotes(String newNotes){
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
