package CrawlData.BookData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawDataDrawStuff implements CrawlData{
    private final String url = "https://bookbuy.vn/van-phong-pham/dung-cu-ve";
    private List<String> ID_DrawStuff;
    private List<String> name_DrawStuff;
    private List<String> price_DrawStuff;

    public CrawDataDrawStuff() {
    }

    public List<String> getID_DrawStuff() {
        return ID_DrawStuff;
    }

    public List<String> getName_DrawStuff() {
        return name_DrawStuff;
    }

    public List<String> getPrice_DrawStuff() {
        return price_DrawStuff;
    }


    public void crawlStuff() {
        try {
            Document document = Jsoup.connect(url).get();
            ArrayList<Element> getDataTitle = document.getElementsByClass("t-view");
            ArrayList<Element> getDataPrice = document.getElementsByClass("real-price");
            for (int i = 0; i < 5; i++) {
                ID_DrawStuff.add("DT_" + i);
                name_DrawStuff.add(getDataTitle.get(i).getElementsByTag("a").text());
                price_DrawStuff.add(getDataPrice.get(i).getElementsByTag("a").text());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
