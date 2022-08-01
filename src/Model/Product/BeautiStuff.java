package Model.Product;

import java.io.Serializable;

public class BeautiStuff extends Product implements ProductStuff, Serializable {
    private String ID;
    private String name;
    private double price;

    public BeautiStuff() {
    }

    public BeautiStuff(String ID, String name, double price) {
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
