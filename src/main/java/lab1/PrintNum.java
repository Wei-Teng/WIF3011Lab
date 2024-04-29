package lab1;

public class PrintNum implements Runnable {

    private final int targetCount;
    private int count = 1;

    public PrintNum(int targetCount) {
        this.targetCount = targetCount;
    }

    @Override
    public void run() {
        Object lock = Lab1Demo.lock;
        synchronized (lock) {
            while (count <= targetCount) {
                try {
                    if (!Lab1Demo.isCharFinish) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count);
                count++;
                lock.notify();
            }
            Lab1Demo.isNumFinish = true;
            lock.notify();
        }
    }
}
