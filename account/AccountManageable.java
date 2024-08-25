package account;

public interface AccountManageable {
    double getBalance();
    void deposit(double amount);
    void deposit(double amount, String description);
    void withdraw(double amount);
    void withdraw(double amount, String reason);
}
