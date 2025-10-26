package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/simple-bank-system
 */

public class LC2043SimpleBankSystem {
    public static void main(String[] args) {
        long[] balance = {10, 100, 20, 50, 30};
        Bank bank = new Bank(balance);

        System.out.println(bank.withdraw(3, 10));             // true
        System.out.println(bank.transfer(5, 1, 20)); // true
        System.out.println(bank.deposit(5, 20));              // true
        System.out.println(bank.transfer(3, 4, 15)); // false
        System.out.println(bank.withdraw(10, 50));            // false
    }
}

class Bank {
    private final long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    private boolean isValidAccount(int account) {
        return account < 1 || account > balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (isValidAccount(account1) || isValidAccount(account2)) return false;
        if (balance[account1 - 1] < money) return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (isValidAccount(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (isValidAccount(account)) return false;
        if (balance[account - 1] < money) return false;
        balance[account - 1] -= money;
        return true;
    }
}