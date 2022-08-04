package controller;

import storage.ReadWriteDataTxt;

public class BillManager {
    private ReadWriteDataTxt readWriteData = ReadWriteDataTxt.getInstance();
    public BillManager() {
    }

    public void writeBillOfUser(String data, String path) {
        readWriteData.writeData(data,path);
    }
    public String readBillOfUser(String path){
       return readWriteData.readData(path);
    }
}
