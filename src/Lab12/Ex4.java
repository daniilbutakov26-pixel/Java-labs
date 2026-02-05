package Lab12;

public class Ex4 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++){
            final int num = i + 1;
            threads[i] = new Thread(() -> System.out.println("Поток № " + num));
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
