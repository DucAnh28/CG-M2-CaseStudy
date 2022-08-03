package storage;

import java.util.List;

public interface ReadWriteData<E> {
    void writeData(List<E> list,String path);

    List<E> readData(String path);
}
