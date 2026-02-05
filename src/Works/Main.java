package Works;

import java.nio.file.Path;
import java.security.SecureRandom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {

        //Путь к файлу
        Path inputPath = Path.of("src/Works/warandpeace1.txt");
        byte[] input = TextToByte.readAllBytes(inputPath);

        //Ключи
        byte[] vigenereKey = "КЛЮЧ".getBytes(java.nio.charset.Charset.forName("windows-1251"));
        byte[] vernamKey = new byte[input.length];
        new SecureRandom().nextBytes(vernamKey);

        //Набор потоков 12 или 20
        int[] threadsToTest12 = {1, 2, 3, 4, 5, 6, 7, 8, 12};
        int[] threadsToTest20 = {1, 2, 4, 5, 8, 10, 16, 20};

        //Выбор количества потоков для теста
        int[] threadsToTest = threadsToTest12;

        //Число прогрева и прогонов
        int warmups = 5;
        int runs = 15;

        //Эталонное время. 1 поток
        System.out.println("n = " + input.length);

        //Шифр Вернама
        //Однопоточный
        long t1 = Benchmark.timeNanos(() -> {
            byte[] out = Ciphres.vernamSingle(input, vernamKey);
            Benchmark.consume(out);
        }, warmups, runs);
        System.out.println("\nШифр Вернама:");
        System.out.printf("p=%d  T=%.3f ms  S=1.00  E=1.00%n", 1, t1 / 1e6);

        //Многопоточный
        for (int p : threadsToTest) {
            ExecutorService pool = Executors.newFixedThreadPool(p); // создаём пул потоков
            if (p == 1) continue;
            try {
                long tp = Benchmark.timeNanos(() -> {
                    try {
                        byte[] out = Ciphres.vernamParallel(input, vernamKey, pool, p);
                        Benchmark.consume(out);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, warmups, runs);

                double S = (double) t1 / tp;
                double E = S / p;
                System.out.printf("p=%d  T=%.3f ms  S=%.2f  E=%.2f%n", p, tp / 1e6, S, E);

            } finally {
                pool.shutdown();
                pool.awaitTermination(1, TimeUnit.MINUTES);
            }
        }

        //Шифр Цезаря
        //однопоточный
        long t1Caesar = Benchmark.timeNanos(() -> {
            byte[] out = Ciphres.cesarSingleCP1251(input, 5);
            Benchmark.consume(out);
        }, warmups, runs);
        System.out.println("\nШифр Цезаря:");
        System.out.printf("p=%d  T=%.3f ms  S=1.00  E=1.00%n", 1, t1Caesar / 1e6);

        //многопоточный
        for (int p : threadsToTest) {
            if (p == 1) continue;
            ExecutorService pool = Executors.newFixedThreadPool(p);
            try {
                long tpCaesar = Benchmark.timeNanos(() -> {
                    try {
                        byte[] out = Ciphres.cesarParallelCp1251(input, 5, pool, p);
                        Benchmark.consume(out);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, warmups, runs);

                double S = (double) t1Caesar / tpCaesar;
                double E = S / p;
                System.out.printf("p=%d  T=%.3f ms  S=%.2f  E=%.2f%n", p, tpCaesar / 1e6, S, E);

            } finally {
                pool.shutdown();
                pool.awaitTermination(1, TimeUnit.MINUTES);
            }
        }

        //Шифр Виженера
        //однопоточный
        long t1Vig = Benchmark.timeNanos(() -> {
            byte[] out = Ciphres.vigenereSingleCp1251(input, vigenereKey, true);
            Benchmark.consume(out);
        }, warmups, runs);
        System.out.println("\nШифр Виженера:");
        System.out.printf("p=%d  T=%.3f ms  S=1.00  E=1.00%n", 1, t1Vig / 1e6);

        //многопоточный
        for (int p : threadsToTest) {
            ExecutorService pool = Executors.newFixedThreadPool(p);
            if (p == 1) continue;
            try {
                long tpVig = Benchmark.timeNanos(() -> {
                    try {
                        byte[] out = Ciphres.viginerParallelCp1251(input, vigenereKey, true, pool, p);
                        Benchmark.consume(out);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, warmups, runs);

                double S = (double) t1Vig / tpVig;
                double E = S / p;
                System.out.printf("p=%d  T=%.3f ms  S=%.2f  E=%.2f%n", p, tpVig/1e6, S, E);

            } finally {
                pool.shutdown();
                pool.awaitTermination(1, TimeUnit.MINUTES);
            }
        }


    }
}

