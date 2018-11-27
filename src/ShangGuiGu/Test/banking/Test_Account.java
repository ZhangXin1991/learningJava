package ShangGuiGu.Test.banking;

public class Test_Account {
    private double balance;

    public Test_Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        this.balance += amt;
    }

    public void withdraw(double amt) {
        this.balance -= amt;
    }

    public static void main(String[] args) {
        Test_Account account = new Test_Account(500);

        account.withdraw(150);
        account.deposit(22.50);
        account.withdraw(47.62);
        System.out.println(account.getBalance());

    }
}
