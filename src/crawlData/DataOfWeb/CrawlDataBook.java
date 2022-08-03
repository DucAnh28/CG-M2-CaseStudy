package crawlData.DataOfWeb;

import model.product.Book;
import model.product.Product;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CrawlDataBook implements CrawlData {
    private static CrawlDataBook instance;
    private final String url = "https://bookbuy.vn/sach-moi/p1";
    private List<Product> booksOfData = new ArrayList<>();

    private CrawlDataBook() {
    }

    public static CrawlDataBook getInstance() {
        if (instance == null) {
            return instance = new CrawlDataBook();
        } else return instance;
    }

    public List<Product> getBooksOfData() {
        crawlStuff();
        return booksOfData;
    }

    public void crawlStuff() {
        try {
            Document document = Jsoup.connect(url).get();
            ArrayList<Element> getDataTitle = document.getElementsByClass("t-view");
            ArrayList<Element> getDataAuthor = document.getElementsByClass("au-view");
            ArrayList<Element> getDataPrice = document.getElementsByClass("real-price");
            for (int i = 0; i < 5; i++) {
                Book b1 = new Book();
                String id = "Book_" + i;
                b1.setID(id);
                String name = getDataTitle.get(i).getElementsByTag("a").text();
                b1.setName(name);
                String author = getDataAuthor.get(i).getElementsByTag("a").text();
                b1.setAuthor(author);
                String price = getDataPrice.get(i).getElementsByTag("span").text();
                price = price.replaceAll(",", "");
                price = price.replaceAll("₫", "").trim();
                b1.setPrice(Double.parseDouble(price));
                booksOfData.add(b1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
