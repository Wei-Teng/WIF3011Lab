package lab4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Node<T> {

    private T value;
    private Lock lock;
    private Condition valueChanged;

    public Node() {
        this.lock = new ReentrantLock();
        this.valueChanged = lock.newCondition();
    }

    public void setValue(T value) {
        lock.lock();
        this.value = value;
        valueChanged.signalAll();
        lock.unlock();
    }

    public void executeOnValue(T desiredValue, Runnable task) throws InterruptedException {
        lock.lock();
        while (!this.value.equals(desiredValue)) {
            valueChanged.await();
        }
        task.run();
        lock.unlock();
    }
}
