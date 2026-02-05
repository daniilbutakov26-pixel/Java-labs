package Lab12;

import java.time.LocalTime;

public class Ex1 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
                try {
                    Thread.sleep(1000); // 1 секунда
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
                try {
                    Thread.sleep(1000); // 1 секунда
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        // ждём завершения обоих потоков
        t1.join();
        t2.join();
    }
}
