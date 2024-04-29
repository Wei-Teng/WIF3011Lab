package lab3;

public class RoomAccess {

    public static final int MAX_GUEST_NUM = 6;
    public static int guestNum;
    public static int cleanerNum;

    public synchronized void guestEnterRoom() throws InterruptedException {
        while (cleanerNum > 0 || guestNum >= MAX_GUEST_NUM) {
            wait();
            System.out.println(Thread.currentThread().getName() + " waiting...");
        }
        guestNum++;
        System.out.println(Thread.currentThread().getName() + " enter the room...");
    }

    public synchronized void guestLeaveRoom() throws InterruptedException {
        guestNum--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " leave the room...");
    }

    public synchronized void cleanerEnterRoom() throws InterruptedException {
        while (guestNum > 0 || cleanerNum > 0) {
            wait();
            System.out.println(Thread.currentThread().getName() + " waiting...");
        }
        cleanerNum++;
        System.out.println(Thread.currentThread().getName() + " enter the room...");
    }

    public synchronized void cleanerLeaveRoom() {
        cleanerNum--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " leave the room...");
    }

    public static void main(String[] args) {
        RoomAccess roomAccess = new RoomAccess();

        Thread cleaner1 = new Thread(() -> {
            try {
                roomAccess.cleanerEnterRoom();
                Thread.sleep(2000);
                roomAccess.cleanerLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Cleaner 1");

        Thread cleaner2 = new Thread(() -> {
            try {
                roomAccess.cleanerEnterRoom();
                Thread.sleep(1000);
                roomAccess.cleanerLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Cleaner 2");

        Thread cleaner3 = new Thread(() -> {
            try {
                roomAccess.cleanerEnterRoom();
                Thread.sleep(200);
                roomAccess.cleanerLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Cleaner 3");

        Thread cleaner4 = new Thread(() -> {
            try {
                roomAccess.cleanerEnterRoom();
                Thread.sleep(2000);
                roomAccess.cleanerLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Cleaner 4");

        Thread guest1 = new Thread(() -> {
            try {
                roomAccess.guestEnterRoom();
                Thread.sleep(2000);
                roomAccess.guestLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Guest 1");

        Thread guest2 = new Thread(() -> {
            try {
                roomAccess.guestEnterRoom();
                Thread.sleep(2000);
                roomAccess.guestLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Guest 2");

        Thread guest3 = new Thread(() -> {
            try {
                roomAccess.guestEnterRoom();
                Thread.sleep(2000);
                roomAccess.guestLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Guest 3");

        Thread guest4 = new Thread(() -> {
            try {
                roomAccess.guestEnterRoom();
                Thread.sleep(2000);
                roomAccess.guestLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Guest 4");

        Thread guest5 = new Thread(() -> {
            try {
                roomAccess.guestEnterRoom();
                Thread.sleep(400);
                roomAccess.guestLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Guest 5");

        Thread guest6 = new Thread(() -> {
            try {
                roomAccess.guestEnterRoom();
                Thread.sleep(5000);
                roomAccess.guestLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Guest 6");

        Thread guest7 = new Thread(() -> {
            try {
                roomAccess.guestEnterRoom();
                Thread.sleep(500);
                roomAccess.guestLeaveRoom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Guest 7");

        cleaner1.start();
        cleaner2.start();
        cleaner3.start();
        cleaner4.start();
        guest1.start();
        guest2.start();
        guest6.start();
        guest3.start();
        guest4.start();
        guest5.start();
        guest7.start();
    }
}
