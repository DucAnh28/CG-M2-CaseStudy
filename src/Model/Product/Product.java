package Model.Product;

import java.io.Serializable;

public class Product implements Serializable {
    private String ID;
    private String name;
    private double price;

    public Product() {
    }

    public Product(String ID, String name, double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display(){
        System.out.printf("%-4s%-4s%-10d", "", "id:", getID());
        System.out.printf("%-9s", getName());
        System.out.printf("%-7s%-10d", "price:", getPrice());
    }
}
