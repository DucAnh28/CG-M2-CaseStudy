package Controller;

import CrawlData.ListOfProduct.ListDataCrawlProduct;
import Model.Product.Product;
import Storage.ReadWriteData;
import Storage.ReadWriteDataBinaryFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements Serializable {
    private ReadWriteData readWriteData = ReadWriteDataBinaryFile.getInstance();
    private String path1 ;
    private List<Product> list = readWriteData.readData(path1);

    public int checkID(String ID) {
        int check = 0;
        for (int i = 0; i < list.size(); i++) {
            if (ID.equalsIgnoreCase(list.get(i).getID()))
                check = i;
        }
        return check;
    }

    public void displayProduct() {
        for (Product x : list
        ) {
            x.display();
        }
    }

    public void addProduct(Product products, String path) {
        list.add(products);
        readWriteData.writeData(list, path);
    }

    public void editProduct(int id, Product product, String path) {
        list.set(id, product);
        readWriteData.writeData(list, path);
    }

    public void removeProduct(Product product, String path) {
        list.remove(product);
        readWriteData.writeData(list, path);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product x : list
        ) {
            total += x.getPrice();
        }
        return total;
    }
}
