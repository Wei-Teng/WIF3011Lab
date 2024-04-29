package lab1;

public class Lab1Demo {

    public static final Object lock = new Object();
    public static boolean isNumFinish = false;
    public static boolean isCharFinish = false;

    public static void main(String[] args) {
        Runnable printChar1 = new PrintChar('A', 10);
        Runnable printNum = new PrintNum(45);

        Thread thread1 = new Thread(printChar1);
        Thread thread2 = new Thread(printNum);

        thread2.start();
        thread1.start();
    }
}
