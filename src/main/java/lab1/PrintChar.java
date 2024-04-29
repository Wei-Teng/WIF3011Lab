package lab1;

public class PrintChar implements Runnable {

    private final char charToPrint;
    private final int printCount;
    private int currCount = 0;

    public PrintChar(char c, int printCount) {
        this.charToPrint = c;
        this.printCount = printCount;
    }

    @Override
    public void run() {
       printChar();
    }

    public void printChar() {
        Object lock = Lab1Demo.lock;
        synchronized (lock) {
            while (currCount < printCount) {
                System.out.println(charToPrint);
                currCount++;
                lock.notify();
                try {
                    if (!Lab1Demo.isNumFinish) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Lab1Demo.isCharFinish = true;
            lock.notify();
        }
    }
}
