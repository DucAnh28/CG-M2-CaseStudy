package Client;

import CrawlData.ListOfProduct.ListDataCrawlProduct;
import Model.Product.Product;
import Storage.ReadWriteData;
import Storage.ReadWriteDataBinaryFile;

import java.util.List;

public class Main {
    public static void main(String[] args)  {
       List<Product> list =  ListDataCrawlProduct.getListData();
//        for (Product x: list
//             ) {
//            x.display();
//        }
        ReadWriteData data = new ReadWriteDataBinaryFile();
        data.writeData(list,"test123");
        System.out.println("==================");
        data.readData("test123");
        for (Product x: data.readData("test123")
        ) {
            x.display();
        }
    }
}
