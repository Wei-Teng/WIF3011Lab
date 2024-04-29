package lab2;

import java.util.Random;

public class LargestNumSearcher {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int[] nums = new int[100000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(50000) + 1;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("Largest num concurrent: " + findLargestNumConcurrent(nums));
        long endTime = System.currentTimeMillis();
        System.out.println("Time elapsed concurrent: " + (endTime - startTime));
        long startTime2 = System.currentTimeMillis();
        System.out.println("Largest num sequential: " + findLargestNumSequential(nums));
        long endTime2 = System.currentTimeMillis();
        System.out.println("Time elapsed sequential: " + (endTime2 - startTime2));
    }

    public static int findLargestNumSequential(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > result) {
                result = nums[i];
            }
        }
        return result;
    }

    public static int findLargestNumConcurrent(int[] nums) throws InterruptedException {
        int quarter = nums.length / 4;
        LargestFinder thread1 = new LargestFinder(nums, 0, 0 + quarter);
        LargestFinder thread2 = new LargestFinder(nums, quarter, quarter*2);
        LargestFinder thread3 = new LargestFinder(nums, quarter*2, quarter*3);
        LargestFinder thread4 = new LargestFinder(nums, quarter*3, nums.length);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        return Math.max(thread1.getLargestNum(), thread2.getLargestNum());
    }

    static class LargestFinder extends Thread {

        private int largestNum;
        private int[] nums;
        private int start;
        private int end;

        public LargestFinder(int[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            findLargestNum();
        }

        public void findLargestNum() {
            for (int i = start; i < end; i++) {
                if (nums[i] > largestNum) {
                    largestNum = nums[i];
                }
            }
        }

        public int getLargestNum() {
            return largestNum;
        }

        public void setLargestNum(int largestNum) {
            this.largestNum = largestNum;
        }
    }
}
