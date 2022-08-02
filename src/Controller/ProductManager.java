package Controller;

import CrawlData.ListOfProduct.ListDataCrawlProduct;
import Model.Product.Product;
import Storage.ReadWriteData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements Serializable {
    private ReadWriteData readWriteData =
    public static List<Product> listCrawlData = ListDataCrawlProduct.getListData();
    public static List<Product> list = ReadWriteData.read;

    public void displayProduct(){
        for (Product x: list
             ) {
            x.display();
        }
    }

    public void addProduct(List<Product> products,String path){
        list.add(products);


    }
    public void editProduct(int id,Product product){
        list.set(id,product);
    }
    public void removeProduct(Product product){
        list.remove(product);
    }
}
