package lab3;

public class BankAccount {

    private int existingBalance = 500;

    private synchronized void deposit(int amount) {
        existingBalance += amount;
        notifyAll();
        System.out.println("Successfully deposit RM" + amount);
    }

    private synchronized void withdraw(int amount) throws InterruptedException {
        while (amount > existingBalance) {
            System.out.println("Waiting to withdraw RM" + amount);
            wait();
        }
        existingBalance -= amount;
        System.out.println("Successfully withdraw RM" + amount);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread deposit1 = new Thread(() -> {
            account.deposit(100);
        });

        Thread deposit2 = new Thread(() -> {
            account.deposit(300);
        });

        Thread withdraw1 = new Thread(() -> {
            try {
                account.withdraw(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread withdraw2 = new Thread(() -> {
            try {
                account.withdraw(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        deposit1.start();
        deposit2.start();
        withdraw1.start();
        withdraw2.start();
    }
}
