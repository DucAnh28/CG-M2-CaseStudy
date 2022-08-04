package storage;

import model.product.Bill;

import java.io.*;
import java.util.List;

public class ReadWriteDataTxt {
    private static ReadWriteDataTxt instance = null;

    private ReadWriteDataTxt() {
    }

    public static ReadWriteDataTxt getInstance() {
        if (instance == null) {
            return instance = new ReadWriteDataTxt();
        } else return instance;
    }

    public void writeData(String data, String path) {
        try {
            FileWriter fileWriter = new FileWriter("DataOfCase/" + path + "bill.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
//            System.out.println("lỗi ở đây");
            System.err.println(e.getMessage());
        }
    }

    public String readData(String path) {
        try {
            FileReader fileReader = new FileReader("DataOfCase/" + path + "bill.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data = bufferedReader.readLine();
            fileReader.close();
            bufferedReader.close();
            return data;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
