package Client;

import CrawlData.BookData.CrawlData;
import CrawlData.BookData.CrawlDataBook;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CrawlDataBook data = new CrawlDataBook();
        System.out.println(data.getBooks());
    }
}
