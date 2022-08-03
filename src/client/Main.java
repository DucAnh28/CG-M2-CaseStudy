package client;

import controller.ProductManager;
import controller.UserManager;
import login.Login;
import model.product.Product;
import system.RunShopByAdmin;

public class Main {
    public static void main(String[] args)  {
        Login login = new Login();
        login.loginSystem();
      }
}
