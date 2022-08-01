package CrawlData.BookData;

import Model.Product.Book;
import Model.Product.Product;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CrawlDataBook implements CrawlData {
    private final String url = "https://bookbuy.vn/sach-moi/p1";
    private List<Product> books = new Book();
//    private List<String> ID_Book;
//    private List<String> name_Book;
//    private List<String> author_Book;
//    private List<String> price_Book;

    public CrawlDataBook() {
    }

    public List<Product> getBooks() {
        return books;
    }

    //    public List<String> getID_Book() {
//        return ID_Book;
//    }
//
//    public List<String> getName_Book() {
//        return name_Book;
//    }
//
//    public List<String> getAuthor_Book() {
//        return author_Book;
//    }
//
//    public List<String> getPrice_Book() {
//        return price_Book;
//    }


    public void crawlStuff() {
        try {
            Document document = Jsoup.connect(url).get();
            ArrayList<Element> getDataTitle = document.getElementsByClass("t-view");
            ArrayList<Element> getDataAuthor = document.getElementsByClass("au-view");
            ArrayList<Element> getDataPrice = document.getElementsByClass("real-price");
            for (int i = 0; i < 5; i++) {
                String id = "B_" +i;
                Book b1 = new Book();
                b1.setID(id);
                String name = getDataTitle.get(i).getElementsByTag("a").text();
                b1.setName(name);
                String author = getDataAuthor.get(i).getElementsByTag("a").text();
                b1.setAuthor(author);
                String price = getDataPrice.get(i).getElementsByTag("a").text();
                b1.setPrice(Double.valueOf(price));
                books.add(b1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
