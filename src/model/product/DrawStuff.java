package model.product;

import java.io.Serializable;

public class DrawStuff extends Product implements Serializable {

    public DrawStuff() {
    }

    public DrawStuff(String ID, String name, double price) {
        super(ID, name, price);
    }

    @Override
    public void display() {
        System.out.print("DrawStuff_");
        System.out.print("[ID: " + getID()+", ");
        System.out.print("name: " + getName() +", ");
        System.out.print("price: " + getPrice()+"]\n");
    }
}
