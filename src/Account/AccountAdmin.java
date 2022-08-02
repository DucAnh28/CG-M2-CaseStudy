package Account;

public class AccountAdmin {
    private static final String ACCOUNT_NAME = "admin";
    private static final String PASSWORD = "ducanh123";

    public AccountAdmin() {
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    @Override
    public String toString() {
        return "AccountAdmin{" +
                "ACCOUNT_NAME='" + ACCOUNT_NAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }
}
