package Account;

import Model.Customer.Customer;

import java.io.*;

public class AccountUser implements Serializable {
    private String username, password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountUser() {
    }

    public AccountUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String DetailOfUser(Customer customer){
        return  "Username= " +getUsername()+"/"+
                "password= " +getUsername()+"\n"+
                "Detail: "
                +customer.toString();
    }

}
