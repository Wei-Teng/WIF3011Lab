package lab5;

public class CallingQueue extends Thread {

    public static volatile int currCallingNum;

    public void run() {
        for (int i = 1; i <= 10; i++) {
            currCallingNum = i;
            System.out.println("Calling for the customer #" + currCallingNum);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
