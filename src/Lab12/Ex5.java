package Lab12;

import java.util.Random;

import static Lab12.ParllelMax.findMaxParallel;

public class Ex5 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[1_000_000_000];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt();
        }

        long t0 = System.nanoTime();
        int max1 = findMaxParallel(arr);
        long t1 = System.nanoTime();

        long t2 = System.nanoTime();
        //int max2 = maxLoop(arr);
        long t3 = System.nanoTime();

        //Сравним с циклом maxLoop, findMaxParallel начинает выигрывать при arr.length > 10000000
        System.out.println("Максимум: " + max1 + " " + (t1 - t0));
        //System.out.println("Максимум: " + max2 + " " + (t3 - t2));
        //System.out.println(max1 == max2);
    }

    static int maxLoop(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("empty");
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
}
