package Storage;

import Model.Product.Product;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ReadWriteData {
    void writeData(List<Product> list,String path);

    List<Product> readData(String path);
}
