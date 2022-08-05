package controller;

import model.customer.Customer;
import storage.ReadWriteData;
import storage.ReadWriteDataBinaryFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public UserManager() {
    }

    private ReadWriteData readWriteData = ReadWriteDataBinaryFile.getInstance();
    private final String CUSTOMER_PATH = "customerUser.dap";
    public List<Customer> listUser = (List<Customer>) readWriteData.readData(CUSTOMER_PATH);

    //    Kiểm tra username có tồn tại hay không
    public int checkUserName(String username) {
        int check = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (username.equals(listUser.get(i).getUsername())) {
                check = i;
                return check;
            }
        }
        return -1;
    }

    public void addAccountUser(Customer customer) {
        listUser.add(customer);
        readWriteData.writeData(listUser, CUSTOMER_PATH);
    }

    public void removeAccountUser(int id) {
        listUser.remove(id);
        readWriteData.writeData(listUser, CUSTOMER_PATH);
    }

    public void editAccountUser(int id, Customer customer) {
        listUser.set(id, customer);
        readWriteData.writeData(listUser, CUSTOMER_PATH);
    }

    public String getNameUser(String username) {
        int check = 0;
        for (int i = 0; i < listUser.size(); i++) {
            if (username.equals(listUser.get(i).getUsername())) {
                check = i ;
            }
        }
        return listUser.get(check).DetailOfUser();
    }

    public String getDetailOfUser(String username) {
        for (int i = 0; i < listUser.size(); i++) {
            if (username.equals(listUser.get(i).getUsername())) {
                return listUser.get(i).toString();
            }
        }
        return null;
    }

    public boolean checkAccount(String account, String password) {
        for (int i = 0; i < listUser.size(); i++) {
            if (account.equals(listUser.get(i).getUsername()) && password.equals(listUser.get(i).getPassword()))
            return true;
        }
        return false;
    }

    public boolean checkUserAccount(String username) {
        for (int i = 0; i < listUser.size(); i++) {
            if (username.equals(listUser.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    public void getAllListUser(){
        for (Customer x: listUser
             ) {
            System.out.println(x.DetailOfUser());
        }
    }
}
