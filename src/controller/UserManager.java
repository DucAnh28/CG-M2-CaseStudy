package controller;

import model.customer.Customer;
import storage.ReadWriteData;
import storage.ReadWriteDataBinaryFile;

import java.util.List;

public class UserManager {
    private final ReadWriteData readWriteData = ReadWriteDataBinaryFile.getInstance();
    private final String CUSTOMER_PATH = "DataOfCase/Customer";
    private final String CUSTOMER_HISTORY_PATH = "DataOfCase/CustomerHistory";
    public List<Customer> listUser = (List<Customer>) readWriteData.readData(CUSTOMER_PATH);
    public List<Customer> listUserHistory = (List<Customer>) readWriteData.readData(CUSTOMER_HISTORY_PATH);

    public void addAccountUser(Customer customer){
        listUser.add(customer);
        readWriteData.writeData(listUser, CUSTOMER_PATH);
    }
    public void removeAccountUser(int id){
        listUser.remove(id);
        readWriteData.writeData(listUser, CUSTOMER_PATH);
    }
    public void editAccountUser(int id,Customer customer){
        listUser.set(id,customer);
        readWriteData.writeData(listUser, CUSTOMER_PATH);
    }

    public String getNameUser(String username){
        for (int i = 0; i < listUser.size(); i++) {
            if (username.equals(listUser.get(i).getUsername())){
                return listUser.get(i).DetailOfUser()+listUser.get().toString();
            }
        }
        return null;
    }

}
