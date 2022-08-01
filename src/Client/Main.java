package Client;

import CrawlData.BookData.CrawlDataBook;
import CrawlData.ListData.CrawlData;

public class Main {
    public static void main(String[] args) {
        CrawlData data = new CrawlDataBook();
        data.crawlStuff();
    }
}
