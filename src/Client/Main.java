package Client;

import DataOfProduct.CrawlBook;
import DataOfProduct.CrawlData;

public class Main {
    public static void main(String[] args) {
        CrawlData data = new CrawlBook();
        data.crawlStuff();
    }
}
