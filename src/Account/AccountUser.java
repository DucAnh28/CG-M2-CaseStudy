package Account;

import Model.Customer.Customer;

import java.io.*;

public class AccountUser extends Customer implements Serializable {
    private String username, password;

    public AccountUser() {
    }

    public AccountUser(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
