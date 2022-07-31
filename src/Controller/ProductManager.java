package Controller;

import Model.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public static List<Product> list = new ArrayList<>();

    public void displayProduct(){

    }

    public void addProduct(Product product){
        list.add(product);
    }
    public void editProduct(int id,Product product){
        list.set(id,product);
    }
    public void removeProduct(Product product){
        list.remove(product);
    }
}
