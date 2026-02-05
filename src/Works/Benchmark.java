package Works;

public class Benchmark {
    private Benchmark(){}

    private static volatile int blackhole;

    public static long timeNanos(Runnable r, int warmups, int runs){
        for (int i = 0; i < warmups; i++) r.run();
        long best = Long.MAX_VALUE;
        for (int i = 0; i < runs; i++){
            long t0 = System.nanoTime();
            r.run();
            long t1 = System.nanoTime();
            best = Math.min(best, t1 - t0);
        }
        return best;
    }

    public static void consume(byte[] arr) {
        // Чтобы результат считался использованным
        blackhole ^= (arr[0] & 0xFF);
        blackhole ^= (arr[arr.length - 1] & 0xFF);
    }
}
