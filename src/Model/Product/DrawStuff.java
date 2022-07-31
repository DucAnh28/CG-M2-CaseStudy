package Model.Product;

public class DrawStuff extends Product implements ProductStuff{
    private String ID;
    private String name;
    private double price;

    public DrawStuff() {
    }

    public DrawStuff(String ID, String name, double price) {
        super(ID, name, price);
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void display() {
        super.display();
    }
}
