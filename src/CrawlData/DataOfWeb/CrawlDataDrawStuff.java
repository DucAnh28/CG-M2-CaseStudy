package CrawlData.DataOfWeb;

import Model.Product.DrawStuff;
import Model.Product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlDataDrawStuff implements CrawlData {
    private static CrawlDataDrawStuff instance;
    private final String url = "https://bookbuy.vn/van-phong-pham/dung-cu-ve";

    private List<Product> drawOfData = new ArrayList<>();

    public CrawlDataDrawStuff() {
    }

    public static CrawlDataDrawStuff getInstance(){
        if (instance == null){
            return instance = new CrawlDataDrawStuff();
        } else return instance;
    }

    public List<Product> getDrawOfData(){
        crawlStuff();
        return drawOfData;
    }

    public void crawlStuff() {
        try {
            Document document = Jsoup.connect(url).get();
            ArrayList<Element> getDataTitle = document.getElementsByClass("t-view");
            ArrayList<Element> getDataPrice = document.getElementsByClass("real-price");
            for (int i = 0; i < 5; i++) {
                DrawStuff b1 = new DrawStuff();
                String id = "DS_" + i;
                b1.setID(id);
                String name = getDataTitle.get(i).getElementsByTag("a").text();
                b1.setName(name);
                String price = getDataPrice.get(i).getElementsByTag("span").text();
                price = price.replaceAll(",", "");
                price = price.replaceAll("₫", "").trim();
                b1.setPrice(Double.parseDouble(price));
                drawOfData.add(b1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
