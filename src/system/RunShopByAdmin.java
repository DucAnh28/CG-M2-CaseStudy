package system;

import controller.ProductManager;
import controller.UserManager;
//import login.Login;
import login.Login;
import model.product.BeautiStuff;
import model.product.Book;
import model.product.DrawStuff;
import model.product.Product;
import storage.ReadWriteData;
import storage.ReadWriteDataBinaryFile;
import validateConst.Validate;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RunShopByAdmin {
    ReadWriteData readWriteData = ReadWriteDataBinaryFile.getInstance();
    private UserManager userManager = new UserManager();
    Validate validate = Validate.getInstance();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    private ProductManager productManager = new ProductManager();
    StringBuilder nameOfUser1 = new StringBuilder();

    public RunShopByAdmin() {
    }

    public void menuProductOfAdmin() {
        try {
            do {
                System.out.println("╔============================================================╗");
                System.out.println("║           «-(¯`v´¯)-«Welcome DucAnh»-(¯`v´¯)-»             ║");
                System.out.println("╠============================================================╣");
                System.out.println("║<>[1]. Hiển thị sản phẩm trong cửa hàng                     ║");
                System.out.println("║<>[2]. Kiểm tra sản phẩm trong cửa hàng qua ID              ║");
                System.out.println("║<>[3]. Sửa thông tin sản phẩm trong giỏ hàng                ║");
                System.out.println("║<>[4]. Xóa sản phẩm trong giỏ hàng của người dùng           ║");
                System.out.println("║<>[5]. Hiển thị sản phẩm trong giỏ hàng theo người dùng     ║");
                System.out.println("║<>[6]. Thông tin khách hàng                                 ║");
                System.out.println("║<>[0]. Đăng xuất                                            ║");
                System.out.println("╚============================================================╝");
                System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
                int choice = Integer.parseInt(scanner1.nextLine());
                switch (choice) {
                    case 1:
                        productManager.displayProductInShop();
                        break;
                    case 2:
                        System.out.print("Mời bạn nhập ID:");
                        String idInShop = scanner.nextLine();
                        int check0 = productManager.checkIdOfProductInShop(idInShop);
                        if (check0 != -1) {
                            System.out.println("Sản phẩm bạn cần tìm là: ");
                            productManager.showProductInShopByID(check0);
                            System.out.println("_______________________________");
                        } else System.out.println("Không có sản phẩm !!");
                        break;
                    case 3:
                        try {
                            System.out.print("Nhập username người dùng: ");
                            String nameOfUser = scanner.nextLine();
                            nameOfUser1.delete(0,1);
                            nameOfUser1.append(nameOfUser);
                            List<Product> temp = readWriteData.readData(nameOfUser1.toString() + ".data") ;
                            for (Product x : temp) {
                                productManager.addProduct(x, nameOfUser1.toString() + ".data");
                            }
                            productManager.showProductInCart();
                            System.out.print("[\uD83D\uDD0E] Nhập mã ID sản phẩm muốn sửa: ");
                            String id = scanner.nextLine();
                            if (productManager.checkIdOfCart(id) != -1) {
                                int idex = productManager.checkIdOfCart(id);
                                editProductInCartUser(idex);
                                System.out.println("[\uD83D\uDC4C] Đã cập nhật thông tin sản phẩm");
                            } else if (productManager.checkIdOfCart(id) == -1) {
                                System.out.println("[❌] Không có mã ID trên");
                                System.out.println("---------------------------------------------------");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("[❌] Sai kiểu dữ liệu");
                            System.out.println("---------------------------------------------------");
                        }
                        break;
                    case 4:
                        System.out.print("Nhập username người dùng: ");
                        String nameOfUser = scanner1.nextLine();
                        nameOfUser1.delete(0,1);
                        nameOfUser1.append(nameOfUser);
                        List<Product> temp = readWriteData.readData(nameOfUser1.toString() + ".data") ;
                        for (Product x : temp) {
                            productManager.addProduct(x, nameOfUser1.toString() + ".data");
                        }
                        productManager.showProductInCart();
                        deleteProductInCart();
                        break;
                    case 5:
                        System.out.println("Nhập username của khách hàng");
                        String name = scanner1.nextLine();
                        if (name.equals(RunShopByUser.usernameInShop.toString())) {
                            productManager.showProductInCart();
                        }
                        break;
                    case 6:
                        managerUser();
                        break;
                    case 0:
                        System.out.println("[\uD83D\uDD10] Đã thoát khỏi hệ thống ADMIN !!!");
                        System.out.println("-----------------------------------------------------");
                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("[❌] Không có lựa chọn trên");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("--------------------------------------------------------");
            menuProductOfAdmin();
        }
    }

    public void editProductInCartUser(int index) {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║       .•♫•♬•  SỬA SẢN PHẨM  •♬•♫•.       ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Sửa Book                             ║");
            System.out.println("║>[2]. Sửa DrawStuff                        ║");
            System.out.println("║>[3]. Sửa BeautiStuff                      ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập vào lựa chọn: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            switch (choiceAdd) {
                case 1:
                    System.out.print("Nhập ID sản phẩm mới: ");
                    String idOfBook = scanner1.nextLine();
                    while (!validate.validateBookID(idOfBook)) {
                        System.out.print("Mời bạn nhập lại Nhập ID: ");
                        idOfBook = scanner1.nextLine();
                    }
                    System.out.println("Bạn đã nhập đúng ID");
                    System.out.println("---------------------------------");
                    System.out.print("Nhập tên book: ");
                    String nameBook = scanner.nextLine();
                    System.out.print("Nhập giá book: ");
                    double priceOfBook = scanner1.nextDouble();
                    System.out.print("Nhập tên tác giả book: ");
                    String author = scanner.nextLine();
                    Book book = new Book(idOfBook, nameBook, priceOfBook, author);
                    productManager.editProduct(index, book, nameOfUser1.toString() + ".data");
                    break;
                case 2:
                    System.out.print("Nhập ID dụng cụ vẽ: ");
                    String idOfDrawStuff = scanner1.nextLine();
                    while (!validate.validateDrawStuffID(idOfDrawStuff)) {
                        System.out.print("Mời bạn nhập lại Nhập ID: ");
                        idOfDrawStuff = scanner1.nextLine();
                    }
                    System.out.println("Bạn đã nhập đúng ID");
                    System.out.println("---------------------------------");
                    System.out.print("Nhập tên dụng cụ vẽ: ");
                    String nameDraw = scanner.nextLine();
                    System.out.print("Nhập giá dụng cụ vẽ: ");
                    double priceOfDrawS = scanner1.nextDouble();
                    DrawStuff drawStuff = new DrawStuff(idOfDrawStuff, nameDraw, priceOfDrawS);
                    productManager.editProduct(index, drawStuff, nameOfUser1.toString() + ".data");
                    break;
                case 3:
                    System.out.print("Nhập ID đồ làm đẹp: ");
                    String idOfBeautiStuff = scanner1.nextLine();
                    while (!validate.validateBeautiStuffID(idOfBeautiStuff)) {
                        System.out.print("Mời bạn nhập lại Nhập ID: ");
                        idOfBeautiStuff = scanner1.nextLine();
                    }
                    System.out.println("Bạn đã nhập đúng ID");
                    System.out.println("---------------------------------");
                    System.out.print("Nhập tên đồ làm đẹp: ");
                    String nameBeauti = scanner.nextLine();
                    System.out.print("Nhập giá đồ làm đẹp: ");
                    double priceOfBeautiStuff = scanner1.nextDouble();
                    BeautiStuff beautiStuff = new BeautiStuff(idOfBeautiStuff, nameBeauti, priceOfBeautiStuff);
                    productManager.editProduct(index, beautiStuff, nameOfUser1.toString() + ".data");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------------");
        }
    }

    public void deleteProductInCart() {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║        XÓA SẢN PHẨM TRONG GIỎ HÀNG        ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Xóa sản phẩm theo ID                 ║");
            System.out.println("║>[2]. Xóa tất cả sản phẩm                  ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập vào lựa chọn: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            switch (choiceAdd) {
                case 1:
                    System.out.print("[\uD83D\uDD0E] Nhập mã ID: ");
                    String id = scanner.nextLine();
                    if (productManager.checkIdOfCart(id) != -1) {
                        int temp = productManager.checkIdOfCart(id);
                        productManager.removeProduct(temp, nameOfUser1.toString() + ".data");
                        System.out.println("[\uD83D\uDC4C] Xóa thành công");
                        System.out.println("--------------------------------------");
                    } else if (productManager.checkIdOfCart(id) == -1) {
                        System.out.println("[❌] Không có mã ID trên");
                        System.out.println("---------------------------------------");
                    }
                    break;
                case 2:
                    System.err.print("⛔ \uD83D\uDEA7 Bạn chắn chắc muốn xóa hết dữ liệu (Y/N)❓ \uD83D\uDEA7 ⛔: ");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        productManager.removeAll(RunShopByUser.usernameInShop + ".data");
                        System.out.println("[\uD83D\uDCBE] Đã xóa hết dữ liệu");
                        System.out.println("-----------------------------------------------------");
                    } else {
                        break;
                    }
                case 0:
                    System.out.println("[\uD83D\uDD14] Thoát");
                    break;
                default:
                    System.out.println("[❌] Sai lựa chọn");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------");
            deleteProductInCart();
        }
    }

    public void managerUser() {
        try {
            System.out.println("╔==================================================╗");
            System.out.println("║   «-(¯`v´¯)-« THÔNG TIN KHÁCH HÀNG »-(¯`v´¯)-»   ║");
            System.out.println("╠==================================================╣");
            System.out.println("║>[1]. Tài khoản người dùng theo username          ║");
            System.out.println("║>[2]. Thông tin cá nhân người dùng                ║");
            System.out.println("║>[3]. Xóa tài khoản khách hàng                    ║");
            System.out.println("║>[4]. Xem toàn bộ tài khoản người dùng            ║");
            System.out.println("║>[0]. Quay lại                                    ║");
            System.out.println("╚==================================================╝");
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.print("[\uD83D\uDD0E] Mời bạn nhập vào username: ");
            String username123 = scanner1.nextLine();
            int check = userManager.checkUserName(username123);
            while (check == -1) {
                System.out.println("Không tồn tại tài khoản !!");
                System.out.println("Mời bạn nhập lại username: ");
                username123 = scanner.nextLine();
                check = userManager.checkUserName(username123);
            }
            switch (choice) {
                case 1:
                    System.out.println("-------------------------------");
                    System.out.println(userManager.getNameUser(username123));
                    System.out.println("________________________________");
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println(userManager.getDetailOfUser(username123));
                    System.out.println("________________________________");
                    break;
                case 3:
                    userManager.removeAccountUser(check);
                    break;
                case 4:
                    userManager.getAllListUser();
                    break;
                case 0:
                    System.out.println("[\uD83D\uDD14] Thoát");
                    menuProductOfAdmin();
                    break;
                default:
                    System.out.println("[❌] Sai lựa chon");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------");
            managerUser();
        }
    }
}
