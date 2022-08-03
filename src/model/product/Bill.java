package model.product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Bill implements Serializable {
    private String userName;
    private List<Product> productList;
    private double totalPrice;
    private LocalDateTime purchaseDate;

    public Bill() {
    }

    public Bill(String userName, List<Product> productList, double totalPrice, LocalDateTime purchaseDate) {
        this.userName = userName;
        this.productList = productList;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
    }

    public String getUserName() {
        return userName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "userName='" + userName + '\'' +
                ", productList=" + productList +
                ", totalPrice=" + totalPrice +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}