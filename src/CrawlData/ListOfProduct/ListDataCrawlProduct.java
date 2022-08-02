package CrawlData.ListOfProduct;

import CrawlData.DataOfWeb.CrawlDataBeautiStuff;
import CrawlData.DataOfWeb.CrawlDataBook;
import CrawlData.DataOfWeb.CrawlDataDrawStuff;
import Model.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class ListDataCrawlProduct {
    private static List<Product> listOfBook = new ArrayList<>(CrawlDataBook.getInstance().getBooksOfData());
    private static List<Product> listOfDrawStuff = new ArrayList<>(CrawlDataDrawStuff.getInstance().getDrawOfData());
    private static List<Product> listOfBeautiStuff = new ArrayList<>(CrawlDataBeautiStuff.getInstance().getBeautiStuffData());
    public static List<Product> listDisplay = new ArrayList<>();

    public static List<Product> getListData() {
        for (Product x : listOfBook
             ) {
            listDisplay.add(x);
        }
        for (Product x : listOfDrawStuff
             ) {
            listDisplay.add(x);
        }
        for (Product x : listOfBeautiStuff
             ) {
            listDisplay.add(x);
        }
        return listDisplay;
    }
}
