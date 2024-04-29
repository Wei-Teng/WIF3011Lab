package lab4;

public class Operate implements Runnable {

    private Node<Integer> node;
    private Integer target;
    private Dummy dummyTask;
    private int dummyTaskExecutionCount;

    public Operate(Node<Integer> node, int target, Dummy dummyTask) {
        this.node = node;
        this.target = target;
        this.dummyTask = dummyTask;
        this.dummyTaskExecutionCount = 0;
    }

    @Override
    public void run() {
        try {
            while (dummyTaskExecutionCount < 2) {
                node.executeOnValue(target, () -> {
                    dummyTask.run();
                    dummyTaskExecutionCount++;
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
