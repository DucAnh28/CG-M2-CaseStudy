package Model.Product;

import java.io.Serializable;

public class BeautiStuff extends Product implements Serializable {

    public BeautiStuff() {
    }

    public BeautiStuff(String ID, String name, double price) {
        super(ID, name, price);
    }

    @Override
    public void display() {
        System.out.print("BeautiStuff_");
        System.out.print("[ID: " + getID()+", ");
        System.out.print("name: " + getName() +", ");
        System.out.print("price: " + getPrice()+"]\n");
    }
}
