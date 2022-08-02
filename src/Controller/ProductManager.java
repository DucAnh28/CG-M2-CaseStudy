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
    public static List<Product> list = new ArrayList<>();

    public void displayProduct(){
        for (Product x: list
             ) {
            x.display();
        }
    }

    public void addProduct(Product products,String path){
        list.add(products);
        readWriteData.writeData(list,path);
    }
    public void editProduct(int id,Product product){
        list.set(id,product);
    }
    public void removeProduct(Product product){
        list.remove(product);
    }
}
