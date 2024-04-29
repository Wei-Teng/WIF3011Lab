package lab4;

import java.util.Random;

public class Write implements Runnable {

    private Node<Integer> node;
    private Random random;

    public Write(Node<Integer> node) {
        this.node = node;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int randomValue = random.nextInt(5);
                node.setValue(randomValue);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
