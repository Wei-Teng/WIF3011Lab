package lab4;

public class Lab4Demo {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        Thread writeThread = new Thread(new Write(node));
        Dummy dummyTask = new Dummy();
        Thread operateThread = new Thread(new Operate(node, 3, dummyTask));
        writeThread.start();
        operateThread.start();
    }
}
