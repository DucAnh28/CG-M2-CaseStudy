package controller;

import crawlData.ListOfProduct.ListDataCrawlProduct;
import login.Login;
import model.product.Product;
import storage.ReadWriteData;
import storage.ReadWriteDataBinaryFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements Serializable {
    private ListDataCrawlProduct listDataCrawlProduct = ListDataCrawlProduct.getInstance();
    private ReadWriteData readWriteData = ReadWriteDataBinaryFile.getInstance();
    List<Product> listdatacrawl = listDataCrawlProduct.getListData();
    private String nameOfUser1 = Login.username + ".dap";

    public String getNameOfUser1() {
        return nameOfUser1;
    }

    public List<Product> listProductInCart;

    public ProductManager() {
        if (! new File("DataOfCase/"+nameOfUser1+".dap").exists()) {
            try {
                new File("DataOfCase/"+nameOfUser1).createNewFile();
                listProductInCart = new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            listDataCrawlProduct = (ListDataCrawlProduct) readWriteData.readData(nameOfUser1);
        }
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

    //    Giỏ Hàng người dùng
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

    public void addProduct(Product products) {
        listProductInCart.add(products);
        readWriteData.writeData(listProductInCart, nameOfUser1);
    }

    public void editProduct(int id, Product product) {
        listProductInCart.set(id, product);
        readWriteData.writeData(listProductInCart, nameOfUser1);
    }

    public void removeProduct(int id) {
        listProductInCart.remove(id);
        readWriteData.writeData(listProductInCart, nameOfUser1);
    }

    public void removeAll() {
        listProductInCart.removeAll(listProductInCart);
        readWriteData.writeData(listProductInCart, nameOfUser1);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product x : listProductInCart) {
            total += x.getPrice();
        }
        return total;
    }
}
