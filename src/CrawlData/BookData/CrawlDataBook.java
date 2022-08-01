package CrawlData.BookData;

import CrawlData.ListData.CrawlData;
import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;


public class CrawlDataBook implements CrawlData {
    private final String url = "https://bookbuy.vn/sach-moi/p1";
    private List<String> ID;
    private List<String> name;
    private List<String> author;
    private List<String> price;

    public CrawlDataBook() {
    }

    public void crawlStuff() {
        try {
            Document document = Jsoup.connect(url).get();
            ArrayList<String> getData = document.getElementsByClass("product-item");
            for (int i = 0; i < 20; i++) {

            }
        }

    }
}
