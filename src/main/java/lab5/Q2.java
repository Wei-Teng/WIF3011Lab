package lab5;

public class Q2 {

    private volatile int counter;

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        CounterIncrementer counterIncrementer = q2.new CounterIncrementer();
        CounterListener counterListener = q2.new CounterListener();
        counterIncrementer.start();
        counterListener.start();
    }

    class CounterIncrementer extends Thread {
        public void run() {
            while (true) {
                counter++;
                System.out.println("Counter incremented: " + counter);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class CounterListener extends Thread {

        private final int TARGET_COUNT = 5000;
        private int lastCount;

        public void run() {
            while (counter < TARGET_COUNT) {
                if (counter != lastCount) {
                    lastCount = counter;
                    System.out.println("Counter changed: " + lastCount);
                }
            }
            System.out.println("Counter changed: " + TARGET_COUNT);
            System.exit(0);
        }
    }
}