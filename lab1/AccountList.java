public class AccountList {
    private Account[] accounts;
    private int size;

    public AccountList(int maximumSize) {
        accounts = new Account[maximumSize];
    }

    public boolean appendAccount(Account account) {
        if (size == accounts.length) {
            return false;
        }
        accounts[size] = account;
        size++;
        return true;
    }

    public Account getAccount(int idx) {
        if (idx >= 0 && idx < size) {
            return accounts[idx];
        }
        System.out.println("Input index exceeds the number of appended elements");
        return null;
    }
}
