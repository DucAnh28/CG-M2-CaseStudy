package model.product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Bill {
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

    public String getProductList() {
        StringBuilder temp = new StringBuilder() ;
        for (Product x:productList
             ) {
          temp.append(x.toString());
        }
        return temp.toString();
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
                ", productList=" + getProductList() +
                ", totalPrice=" + totalPrice +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
