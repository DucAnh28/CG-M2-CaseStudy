package CrawlData.DataOfWeb;

import Model.Product.BeautiStuff;
import Model.Product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlDataBeautiStuff implements CrawlData {
    private static CrawlDataBeautiStuff instance;
    private final String url = "https://bookbuy.vn/suc-khoe-lam-dep-moi/p1";

    private List<Product> beautiStuffData = new ArrayList<>();

    private CrawlDataBeautiStuff() {
    }

    public static CrawlDataBeautiStuff getInstance(){
        if (instance == null){
            return instance = new CrawlDataBeautiStuff();
        } else return instance;
    }

    public List<Product> getBeautiStuffData() {
        crawlStuff();
        return beautiStuffData;
    }

    public void crawlStuff() {
        try {
            Document document = Jsoup.connect(url).get();
            ArrayList<Element> getDataTitle = document.getElementsByClass("t-view");
            ArrayList<Element> getDataPrice = document.getElementsByClass("real-price");
            for (int i = 0; i < 5; i++) {
                BeautiStuff b1 = new BeautiStuff();
                String id = "BS_" + i;
                b1.setID(id);
                String name = getDataTitle.get(i).getElementsByTag("a").text();
                b1.setName(name);
                String price = getDataPrice.get(i).getElementsByTag("span").text();
                price = price.replaceAll(",", "");
                price = price.replaceAll("₫", "").trim();
                b1.setPrice(Double.parseDouble(price));
                beautiStuffData.add(b1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
