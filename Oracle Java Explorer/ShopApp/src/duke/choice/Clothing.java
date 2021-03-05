package duke.choice;

public class Clothing implements Comparable<Clothing>{
    private String description;
    private double price;
    private String size = "M";
    public static final double MIN_PRICE = 10.0;
    public static final double TAX = 0.2;

    public Clothing(String description, double price, String size){
        setDescription(description);
        setPrice(price);
        setSize(size);
    }
    public Clothing(String description, double price){
        setDescription(description);
        setPrice(price);
    }

    @Override
    public String toString(){
        return(getDescription() + ", " + getPrice() + ", " + getSize());
    }

    public double getPrice() {
        return price * (1+TAX);
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public void setPrice(double price) {
        this.price = (price > MIN_PRICE) ? price : MIN_PRICE;
//        if(price>MIN_PRICE) {
//            this.price = price;
//        } else{
//            this.price=MIN_PRICE;
//        }
    }

    @Override
    public int compareTo(Clothing item){
        return (this.getDescription().compareTo(item.getDescription()));
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
