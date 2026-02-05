package Lab12;

import java.util.Random;

import static Lab12.ParallelSum.sumLoop;
import static Lab12.ParallelSum.sumParallel;

public class Ex6 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[1_000_000];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100); // чтобы сумма была предсказуемее
        }

        long t0 = System.nanoTime();
        long s1 = sumParallel(arr);
        long t1 = System.nanoTime();

        long t2 = System.nanoTime();
        long s2 = sumLoop(arr);
        long t3 = System.nanoTime();

        //Не уверенным тестом один поток побеждает до 1 млр длинны массива
        System.out.println("sumParallel: " + s1 + " time=" + (t1 - t0) + " ns");
        System.out.println("sumLoop    : " + s2 + " time=" + (t3 - t2) + " ns");
        System.out.println("equal? " + (s1 == s2));
    }
}
