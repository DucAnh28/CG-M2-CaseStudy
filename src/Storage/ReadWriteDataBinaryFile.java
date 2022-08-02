package Storage;

import Model.Product.Product;

import java.io.*;
import java.util.List;

public class ReadWriteDataBinaryFile implements ReadWriteData {
    private static ReadWriteDataBinaryFile instance = null;
    private ReadWriteDataBinaryFile(){

    }

    public ReadWriteDataBinaryFile getInstance(){
        if (instance == null){
            return instance = new ReadWriteDataBinaryFile();
        } else return instance;
    }

    @Override
    public void writeData(List<Product> list, String name) {
        try {
            FileOutputStream fos = new FileOutputStream("DataOfCase/"+name+".dap");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Product> readData(String path) {
        try {
            FileInputStream fis = new FileInputStream("DataOfCase/"+path+".dap");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object temp = ois.readObject();
            List<Product> list = (List<Product>) temp;
            fis.close();
            ois.close();
            return list;
        } catch (IOException e){
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
