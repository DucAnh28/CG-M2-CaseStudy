package system;

import controller.ProductManager;
import model.product.Bill;
import model.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RunShopByUser {
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    ProductManager productManager = new ProductManager();

    public RunShopByUser() {
    }

    public void menuProductOfUser() {
        try {
            do {
                System.out.println("╔============================================================╗");
                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG USER █ ▆ ▅ ▃ ▂             ║");
                System.out.println("╠============================================================╣");
                System.out.println("║>[1]. Hiển thị sản phẩm trong shop                          ║");
                System.out.println("║>[2]. Tìm kiếm sản phẩm trong shop                          ║");
                System.out.println("║>[3]. Thêm sản phẩm vào giỏ hàng                            ║");
                System.out.println("║>[4]. Xóa sản phẩm khỏi giỏ hàng                            ║");
                System.out.println("║>[5]. Hiển thị sản phẩm trong giỏ hàng                      ║");
                System.out.println("║>[6]. Thanh toán                                            ║");
                System.out.println("║>[0]. Đăng xuất                                             ║");
                System.out.println("╚============================================================╝");
                System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        productManager.displayProductInShop();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        productManager.displayProductInShop();
                        addProductToCart();
                        break;
                    case 4:
                        displayCart();
                        removeProductFromCart();
                        break;
                    case 5:
                        displayCart();
                        break;
                    case 6:
                        displayCart();
                        payment();
                        break;
                    case 0:
                        System.out.println("[\uD83D\uDD10] Đã thoát khỏi hệ thống USER !!!");
                        System.out.println("----------------------------------------------------");
//                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("[❌] Nhập sai lựa chọn, thử lại");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            menuProductOfUser();
        }
    }

    public void search() {
        try {
            System.out.println("╔============================================╗");
            System.out.println("║   ▂ ▃ ▅ ▆ █ TÌM KIẾM SẢN PHẨM  █ ▆ ▅ ▃ ▂   ║");
            System.out.println("╠============================================╣");
            System.out.println("║>[1]. Theo ID                               ║");
            System.out.println("║>[0]. Thoát                                 ║");
            System.out.println("╚============================================╝");
            System.out.print("[\uD83D\uDD0E] Mời bạn nhập vào lựa chọn: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            if (choiceAdd == 1) {
                System.out.print("Mời bạn nhập ID sản phẩm: ");
                String idInShop = scanner1.nextLine();
                int check = productManager.checkIdOfProductInShop(idInShop);
                productManager.showProductInShopByID(check);
            }
            if (choiceAdd == 0) {
                menuProductOfUser();
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("----------------------------------------------------");
            search();
        }
    }

    public void addProductToCart() {
        try {
            System.out.print("[\uD83D\uDD0E] Nhập mã sản phẩm bỏ vào giỏ: ");
            int id = Integer.parseInt(scanner.nextLine());
            Product product = productManager.showProductInCart();
            if (product == null) {
                System.out.println("[❌] Không đúng mã ID sản phẩm");
            } else {
                System.out.println("Mời bạn nhập username của bạn: ");
                String username = scanner1.nextLine();
                productManager.addProduct(product, username);
                System.out.println("[\uD83D\uDC4C] Đã thêm sản phẩm vào giỏ hàng");
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            addProductToCart();
        }
    }

    public void removeProductFromCart() {
        try {
            if (productManager.showProductInCart() == null) {
                System.out.println("[❌] Giỏ hàng trống rỗng");
            } else {
                System.out.print("[\uD83D\uDD0E] Nhập mã sản phẩm muốn xóa khỏi giỏ hàng: ");
                String id = scanner.nextLine();
                int check = productManager.checkIdOfCart(id);

                if (check == -1) {
                    System.out.println("[❌] Không có sản phẩm có mã ID trên trong giỏ hàng");
                } else {
                    System.out.println("Mời bạn nhập username của bạn: ");
                    String username = scanner1.nextLine();
                    productManager.removeProduct(check, username);
                    System.out.println("[\uD83D\uDC4C] Đã xóa sản phẩm thành công khỏi giỏ hàng");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------");
            removeProductFromCart();
        }
    }

    public void displayCart() {
        if (productManager.showProductInCart() == null) {
            System.out.println("[❌] Chưa có sản phẩm nào trong giỏ hàng");
        } else {
            productManager.showProductInCart();
        }
    }

    public void payment() {
        if (productManager.showProductInCart() != null) {
            System.out.print("[\uD83D\uDCB0] Tổng giá tiền các sản phẩm trong giỏ hàng là: "+ productManager.getTotalPrice());
            System.out.print("[\uD83C\uDF81] Xác nhân thanh toán (Y/N): ");
            String result = scanner.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                Bill bill = new Bill()
                for (Product p : cartUser) {
                    productFacade.delete(p.getId());
                }
                cartUser.clear();
                System.out.println("[\uD83D\uDC4C] Thanh toán hoàn tất! Xin trân trọng cảm ơn quý khách đã mua sản phẩm!!\uD83C\uDF81 \uD83D\uDC97 \uD83D\uDC97");
            } else {
                System.out.println("[❌] Bạn cần thanh toán hóa đơn để có sản phẩm");
            }
        } else {
            System.out.println("[❌] Chưa có sản phẩm nào trong giỏ hàng ");
        }
    }
}
