package Controller;

import Account.AccountUser;
import Model.Customer.Customer;
import Storage.ReadWriteData;
import Storage.ReadWriteDataBinaryFile;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final ReadWriteData readWriteData = ReadWriteDataBinaryFile.getInstance();
    private final String ACCOUNT_PATH = "AccountUser";
    private List<AccountUser> listUser = readWriteData.readData(ACCOUNT_PATH);

    public String getListUser(Customer customer){
        for (AccountUser x: listUser
             ) {
           return x.DetailOfUser(customer);
        }
        return null;
    }
    public void addAccountUser(AccountUser accountUser){
        listUser.add(accountUser);
        readWriteData.writeData(listUser,ACCOUNT_PATH);
    }
    public void removeAccountUser(int id){
        listUser.remove(id);
        readWriteData.writeData(listUser,ACCOUNT_PATH);
    }
    public void editAccountUser(int id,AccountUser accountUser){
        listUser.set(id,accountUser);
        readWriteData.writeData(listUser,ACCOUNT_PATH);
    }
}
