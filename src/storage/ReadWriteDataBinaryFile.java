package storage;

import model.product.Product;

import java.io.*;
import java.util.List;

public class ReadWriteDataBinaryFile implements ReadWriteData {
    private static ReadWriteDataBinaryFile instance = null;
    private ReadWriteDataBinaryFile(){
    }

    public static ReadWriteDataBinaryFile getInstance(){
        if (instance == null){
            return instance = new ReadWriteDataBinaryFile();
        } else return instance;
    }

    @Override
    public void writeData(List list, String name) {
        try {
            FileOutputStream fos = new FileOutputStream("DataOfCase/"+name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List readData(String name) {
        try {
            FileInputStream fis = new FileInputStream("DataOfCase/"+name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object temp = ois.readObject();
            List list = (List) temp;
            fis.close();
            ois.close();
            return list;
        } catch (IOException e){
            System.err.println("Ồ thì ra bạn là người mới !! Chào mừng Bạn đến với DucAnhStore");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
