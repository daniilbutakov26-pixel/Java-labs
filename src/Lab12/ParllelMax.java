package Lab12;

import java.util.Arrays;

public class ParllelMax {

    public  static int findMaxParallel(int[] arr) throws  InterruptedException {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив пустой или null");
        }

        //Узнаём количество ядер, записываем в cores
        int cores = Runtime.getRuntime().availableProcessors();
        int threadsCount = cores;

        int n = arr.length;
        //каждому threads по chunk
        int chunk = (n + threadsCount - 1) / threadsCount;

        int[] partialMax = new int[threadsCount];
        Arrays.fill(partialMax,Integer.MIN_VALUE);

        Thread[] threads = new Thread[threadsCount];

        for (int t = 0; t < threadsCount; t++){
            final int idx = t;
            final int start = t * chunk;
            final int end = Math.min(start + chunk, n);

            threads[t] = new Thread(() -> {
                if (start >= end) {
                    return;
                }

                int localMax = arr[start];
                for (int i = start + 1; i < end; i++){
                    if (arr[i] > localMax) localMax = arr[i];
                }
                partialMax[idx] = localMax;
            });

            threads[t].start();
        }

        //Ждём завершения потоков
        for (Thread th : threads) th.join();

        //находим максимум из локальных максимумов
        int max = partialMax[0];
        for (int i = 1; i < partialMax.length; i++){
            if (partialMax[i] > max) max = partialMax[i];
        }
        return max;
    }
}
