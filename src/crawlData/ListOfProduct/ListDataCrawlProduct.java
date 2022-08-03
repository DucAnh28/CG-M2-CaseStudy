package crawlData.ListOfProduct;

import crawlData.DataOfWeb.CrawlDataBeautiStuff;
import crawlData.DataOfWeb.CrawlDataBook;
import crawlData.DataOfWeb.CrawlDataDrawStuff;
import model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ListDataCrawlProduct {
    private List<Product> listOfBook = new ArrayList<>(CrawlDataBook.getInstance().getBooksOfData());
    private List<Product> listOfDrawStuff = new ArrayList<>(CrawlDataDrawStuff.getInstance().getDrawOfData());
    private List<Product> listOfBeautiStuff = new ArrayList<>(CrawlDataBeautiStuff.getInstance().getBeautiStuffData());
    private List<Product> listOfAll = new ArrayList<>();

    public List<Product> getListOfBook() {
        return listOfBook;
    }

    public List<Product> getListOfDrawStuff() {
        return listOfDrawStuff;
    }

    public List<Product> getListOfBeautiStuff() {
        return listOfBeautiStuff;
    }

    public List<Product> getListData() {
        for (Product x : listOfBook
             ) {
            listOfAll.add(x);
        }
        for (Product x : listOfDrawStuff
             ) {
            listOfAll.add(x);
        }
        for (Product x : listOfBeautiStuff
             ) {
            listOfAll.add(x);
        }
        return listOfAll;
    }
}
