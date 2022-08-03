package controller;

import crawlData.ListOfProduct.ListDataCrawlProduct;
import model.product.Product;
import storage.ReadWriteData;
import storage.ReadWriteDataBinaryFile;

import java.io.Serializable;
import java.util.List;

public class ProductManager implements Serializable {
    private static final ProductManager instance = new ProductManager();
    private ListDataCrawlProduct listDataCrawlProduct;
    private ReadWriteData readWriteData = ReadWriteDataBinaryFile.getInstance();
    List<Product> listdatacrawl = listDataCrawlProduct.getListData();

    private ProductManager() {
        listDataCrawlProduct = new ListDataCrawlProduct();
    }

    public static ProductManager getInstance(){
        return instance;
    }
    private String nameOfUser;

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    private List<Product> listProductInCart = readWriteData.readData(nameOfUser);

    public void displayProductInShop(){
        for (Product x:
             listdatacrawl) {
           x.display();
        }
    }

    public int checkIdOfProductInShop(String id) {
        int check = -1;
        for (int i = 0; i < listdatacrawl.size(); i++) {
            if (id.equalsIgnoreCase(listdatacrawl.get(i).getID())) {
                check = i;
                return check;
            }
        }
        return -1;
    }

    public int checkIdOfCart(String id){
        int check = -1;
        for (int i = 0; i < listProductInCart.size(); i++) {
            if (id.equalsIgnoreCase(listProductInCart.get(i).getID())){
                check = i;
                return check;
            }
        }
        return -1;
    }

    public void addProduct(Product products,String path) {
        listProductInCart.add(products);
        readWriteData.writeData(listProductInCart, path);
    }

    public void editProduct(int id, Product product, String path) {
        listProductInCart.set(id, product);
        readWriteData.writeData(listProductInCart,path);
    }

    public void removeProduct(int id, String path) {
        listProductInCart.remove(id);
        readWriteData.writeData(listProductInCart, path);
    }

    public void removeAll(String path){
        listProductInCart.removeAll(listProductInCart);
        readWriteData.writeData(listProductInCart,path);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product x : listProductInCart
        ) {
            total += x.getPrice();
        }
        return total;
    }
}
