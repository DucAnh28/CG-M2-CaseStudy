package Model.Product;

import java.io.Serializable;

public class Book extends Product implements Serializable {
    private String author;

    public Book() {
    }

    public Book(String ID, String name, double price,String author) {
        super(ID, name, price);
        this.author = author;

    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void display() {
        System.out.print("Book_");
        System.out.print("[ID: " + getID()+", ");
        System.out.print("name: " + getName() +", ");
        System.out.print("price: " + getPrice()+", ");
        System.out.print("author: " + getAuthor()+"]\n");
    }
}
