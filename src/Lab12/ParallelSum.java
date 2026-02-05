package Lab12;

public class ParallelSum {

    // Сумма массива с числом потоков = числу ядер
    public static long sumParallel(int[] arr) throws InterruptedException {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив пустой или null");
        }

        int cores = Runtime.getRuntime().availableProcessors();
        int threadsCount = cores;

        int n = arr.length;
        int chunk = (n + threadsCount - 1) / threadsCount; // округление вверх

        long[] partialSums = new long[threadsCount];
        Thread[] threads = new Thread[threadsCount];

        for (int t = 0; t < threadsCount; t++) {
            final int idx = t;
            final int start = t * chunk;
            final int end = Math.min(start + chunk, n);

            threads[t] = new Thread(() -> {
                if (start >= end) return; // если потоков больше, чем данных

                long localSum = 0;
                for (int i = start; i < end; i++) {
                    localSum += arr[i];
                }
                partialSums[idx] = localSum;
            });

            threads[t].start();
        }

        //Ждём завершения потоков
        for (Thread th : threads) th.join();

        long total = 0;
        for (long s : partialSums) total += s;

        return total;
    }

    // Обычный однопоточный вариант для проверки
    public static long sumLoop(int[] arr) {
        long sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }

}
