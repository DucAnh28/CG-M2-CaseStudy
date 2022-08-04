package login;

import account.AccountAdmin;
import controller.UserManager;
import model.customer.Customer;
import system.RunShopByAdmin;
import system.RunShopByUser;
import validateConst.Validate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    UserManager userManager = new UserManager();
    RunShopByAdmin runShopByAdmin = new RunShopByAdmin();
    RunShopByUser runShopByUser = new RunShopByUser();
    Validate validate = Validate.getInstance();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    AccountAdmin accountAdmin = new AccountAdmin();
    public static StringBuilder usernameOfLogin = new StringBuilder();

    public Login() {
    }

    public void loginSystem() {
        try {
            menuLogin();
        } catch (Exception e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            loginSystem();
        }
    }

    //
    public void menuLogin() throws NumberFormatException {
        do {
            System.out.println("╔============================================╗");
            System.out.println("║    ꧁ღ╭⊱ꕥ  DucAnh BookStore  ꕥ⊱╮ღ꧂     ║");
            System.out.println("╠============================================╣");
            System.out.println("║>[1]. Đăng nhập                             ║");
            System.out.println("║>[2]. Đăng ký tài khoản                     ║");
            System.out.println("║>[0]. Thoát                                 ║");
            System.out.println("╚============================================╝");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    loginManager();
                    break;
                case 2:
                    registerAccountUser();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("[❌] Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                    break;
            }
        } while (true);
    }

    public void loginManager() throws InputMismatchException {
        System.out.println("┎──────────────[ĐĂNG NHẬP]──────────────┒");
        System.out.print("┠ ▹ Nhập tài khoản: ");
        String account = scanner.nextLine();
        System.out.print("┠ ▹ Nhập mật khẩu: ");
        String password = scanner1.next();
        System.out.println("┖───────────────────────────────────────┚");
        checkAccount(account, password);
    }

    public void checkAccount(String account, String password) {
        try {
            if (account.equals(accountAdmin.getACCOUNT_NAME()) && password.equals(accountAdmin.getPASSWORD())) {
                System.out.println("[\uD83D\uDD13] Đặng nhập hệ thống bởi ADMIN thành công !!!");
                System.out.println("------------------------------------------------------------");
                runShopByAdmin.menuProductOfAdmin();
            } else {
                loginAccountUser(account, password);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[❌] Đăng nhập thất bại. Vui lòng đăng nhập lại !!!");
            System.out.println("-------------------------------------------------------");
            loginSystem();
        }
    }

    public void loginAccountUser(String account, String password) {
        if (userManager.checkAccount(account,password) == true) {
            usernameOfLogin.append(account);
            System.out.println("[\uD83D\uDD13] Đăng nhập hệ thống bởi USER thành công !!!");
            System.out.println("----------------------------------------------------------");
            runShopByUser.menuProductOfUser();
        } else {
            System.out.println("[❌] Tài khoản USER chưa tồn tại. Hoặc sai mật khẩu . Vui lòng kiểm tra lại !!!");
            System.out.println("------------------------------------------------------------");
            loginSystem();
        }
    }

    public void registerAccountUser() throws InputMismatchException {
        System.out.println("┎──────────────[ĐĂNG KÝ]──────────────┒");
        System.out.println("[\uD83D\uDD11] Mời bạn nhập thông tin:");
        System.out.println("--------------------------------------");
        String accountUser = registerAccountName();
        String passwordUser = registerPassword();
        System.out.print("┠ ▹ Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("┠ ▹ Nhập tuổi: ");
        int age = scanner1.nextInt();
        System.out.print("┠ ▹ Nhập địa chỉ: ");
        String address = scanner.nextLine();
        String phoneNumber = registerPhoneNumber();
        String email = registerEmail();
        System.out.println("┖─────────────────────────────────────┚");
        checkAccountUser(accountUser, passwordUser, name, age, address, phoneNumber, email);
    }

    public String registerAccountName() {
        String accountUser;
        while (true) {
            System.out.print("┠ ▹ Nhập tài khoản: ");
            String account = scanner.nextLine();
            if (!validate.validateAccount(account)) {
                System.out.println("[❌] Tài khoản không hợp lệ !!!");
                System.out.println(">[Chú ý]: Tài khoản phải từ 7 đến 9 ký tự (a,1,...)");
                System.out.println("---------------------------------------------------");
            } else {
                accountUser = account;
                break;
            }
        }
        return accountUser;
    }

    public String registerPassword() {
        String passwordUser;
        while (true) {
            System.out.print("┠ ▹ Nhập passwword: ");
            String password = scanner.nextLine();
            if (!validate.validatePassword(password)) {
                System.out.println("[❌] Mật khẩu không hợp lệ !!!");
                System.out.println(">[Chú ý]: Mật khẩu phải viết hoa chữ cái đầu tiên và có số cuối cùng !");
                System.out.println("-----------------------------------------");
            } else {
                passwordUser = password;
                break;
            }
        }
        return passwordUser;
    }

    public String registerPhoneNumber() {
        String phoneNumber;
        while (true) {
            System.out.print("┠ ▹ Nhập số điện thoại: ");
            String phone = scanner.nextLine();
            if (!validate.validatePhone(phone)) {
                System.out.println("[❌] Số điện thoại không hợp lệ !!!");
                System.out.println(">[Chú ý]: Số điện thoại phải có 10 số (0 - 9) định dạng: (+84)-911112222");
                System.out.println("------------------------------------------");
            } else {
                phoneNumber = phone;
                break;
            }
        }
        return phoneNumber;
    }

    public String registerEmail() {
        String email;
        while (true) {
            System.out.print("┠ ▹ Nhập email: ");
            String inputEmail = scanner.nextLine();
            if (!validate.validateEmail(inputEmail)) {
                System.out.println("[❌] Email không hợp lệ !!!");
                System.out.println(">[Chú ý]: Email phải có dạng: abc@yahoo.com/ Xyz.a@gmail.vn/...");
                System.out.println("--------------------------------------------");
            } else {
                email = inputEmail;
                break;
            }
        }
        return email;
    }

    public void checkAccountUser(String accountUser, String passwordUser, String name, int age, String address, String phoneNumber, String email) {
        if (userManager.checkUserAccount(accountUser)) {
            System.out.println("[❌] Tài khoản đã tồn tại. Vui lòng đăng ký lại !!!");
            System.out.println("---------------------------------------");
        } else {
            Customer customer = new Customer(accountUser, passwordUser, name, age, address, phoneNumber, email);
            userManager.addAccountUser(customer);
            System.out.println("Đăng ký thành công. Mời đăng nhập vào hệ thống !!!");
            System.out.println("----------------------------------------");
            System.out.println();
        }
        loginSystem();
    }
}
