package Model.Product;

public class Book extends Product implements ProductStuff {
    private String ID;
    private String name;
    private String author;
    private double price;

    public Book() {
    }

    public Book(String ID, String name, double price) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void display() {
        System.out.printf("%-4s%-4s%-10d", "", "id:", getName());
        System.out.printf("%-4s%-4s%-10d", "", "id:", getAuthor());
        System.out.printf("%-9s", getID());
        System.out.printf("%-7s%-10d", "price:", getPrice());
    }
}
