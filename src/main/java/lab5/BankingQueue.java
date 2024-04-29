package lab5;

import java.util.Random;

public class BankingQueue {
    public static void main(String[] args) {
        Random random = new Random();
        CallingQueue callingQueue = new CallingQueue();
        CustomerInLine customerInLine = new CustomerInLine(random.nextInt(10) + 1);
        callingQueue.start();
        customerInLine.start();
    }
}
