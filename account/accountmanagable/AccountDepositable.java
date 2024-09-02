package account.accountmanagable;

public interface AccountDepositable {
    void deposit(double amount);
    void deposit(double amount, String description);
}
