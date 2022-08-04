package controller;

import crawlData.ListOfProduct.ListDataCrawlProduct;
import login.Login;
import model.product.Product;
import storage.ReadWriteData;
import storage.ReadWriteDataBinaryFile;
import system.RunShopByUser;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements Serializable {
    private ListDataCrawlProduct listDataCrawlProduct = ListDataCrawlProduct.getInstance();
    private ReadWriteData readWriteData = ReadWriteDataBinaryFile.getInstance();
    public List<Product> listdatacrawl = listDataCrawlProduct.getListData();

    public List<Product> listProductInCart = new ArrayList<>(RunShopByUser.listProductInCartByUser);

    public ProductManager() {
    }

    //        Shop:
    public void displayProductInShop() {
        for (Product x : listdatacrawl) {
            x.display();
        }
    }

    public void showProductInShopByID(int number) {
        listdatacrawl.get(number).display();
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

    public Product findProductInShop(String id) {
        for (int i = 0; i < listdatacrawl.size(); i++) {
            if (id.equals(listdatacrawl.get(i).getID())) {
                return listdatacrawl.get(i);
            }
        }
        return null;
    }

    //    Giỏ Hàng người dùng:
    public int checkIdOfCart(String id) {
        int check = -1;
        for (int i = 0; i < listProductInCart.size(); i++) {
            if (id.equalsIgnoreCase(listProductInCart.get(i).getID())) {
                check = i;
                return check;
            }
        }
        return -1;
    }

    public void showProductInCart() {
        for (Product x : listProductInCart) {
            x.display();
        }
    }

    public void addProduct(Product products, String path) {
        listProductInCart.add(products);
        readWriteData.writeData(listProductInCart, path);
    }

    public void editProduct(int id, Product product, String path) {
        listProductInCart.set(id, product);
        readWriteData.writeData(listProductInCart, path);
    }

    public void removeProduct(int id, String path) {
        listProductInCart.remove(id);
        readWriteData.writeData(listProductInCart, path);
    }

    public void removeAll(String path) {
        listProductInCart.removeAll(listProductInCart);
        readWriteData.writeData(listProductInCart, path);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product x : listProductInCart) {
            total += x.getPrice();
        }
        return total;
    }


}
