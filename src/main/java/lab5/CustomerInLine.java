package lab5;

public class CustomerInLine extends Thread {

    private int myNum;

    public CustomerInLine(int myNum) {
        this.myNum = myNum;
    }

    public void run() {
        while (true) {
            if (CallingQueue.currCallingNum == this.myNum) {
                System.out.println("Great, finally #" + this.myNum + " was called, now it is my turn");
                break;
            }
        }
    }
}
