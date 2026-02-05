package Works;

import java.util.concurrent.*;

public class Ciphres {

    private Ciphres(){} //Утилитарный класс, без экземпляров

    //==================================
    //Шифр Вернама
    //==================================

    //Однопоточная реализация шифра Вернама
    //Применяя XOR с тем же ключом получим декодировку

    public static byte[] vernamSingle(byte[] input, byte[] key){
        if (key.length < input.length){
            throw new IllegalArgumentException("Длинна ключа должна быть >= длинны входящей строки");
        }

        byte[] out = new byte[input.length];

        //Проходим по всем индексам. Линейный алгоритм O(n).
        for (int i = 0; i < input.length; i++){
            out[i] = (byte) (input[i] ^ key[i]); // ^ - XOR по байтам. Сложение по модулю.
        }

        return out;
    }

    //==================================
    //Многопоточная версия шифра Вернама
    //==================================

    //Разбиваем диапазон на p частей [0..n) и обрабатываем параллельно

    public static byte[] vernamParallel(byte[] input, byte[] key, ExecutorService pool, int threads)
            throws InterruptedException {

        if (key.length < input.length) {
            throw new IllegalArgumentException("Длина ключа должна быть >= длины входных данных");
        }
        if (threads <= 0) {
            throw new IllegalArgumentException("число потоков должно быть > 0");
        }

        byte[] out = new byte[input.length];

        runParallel(pool, input.length, threads, (start, end) -> {
            for (int i = start; i < end; i++) {
                out[i] = (byte) (input[i] ^ key[i]);
            }
        });

        return out;
    }

    //==================================
    //Цезарь, CP1251
    //==================================

    //не буквенные символы не меняем

    public static byte[] cesarSingleCP1251(byte[] input, int shift){
        byte[] out = new byte[input.length];

        for (int i = 0; i < input.length; i++){
            out[i] = cesarByteCp1251(input[i], shift);
        }
        return out;
    }

    //Многопопточная версия шифра Цезаря

    public static byte[] cesarParallelCp1251(byte[] input, int shift, ExecutorService pool, int threads)
            throws InterruptedException {

        if (threads <= 0) {
            throw new IllegalArgumentException("Число потоков должно быть > 0");
        }

        byte[] out = new byte[input.length];

        runParallel(pool, input.length, threads, (start, end) -> {
            for (int i = start; i < end; i++) {
                out[i] = cesarByteCp1251(input[i], shift);
            }
        });

        return out;
    }

    //==========================
    //Шифр Вижинера
    //==========================

    //Однопоточная реализация

    public static byte[] vigenereSingleCp1251(byte[] input, byte[] keyCp1251, boolean encrypt){
        if (keyCp1251 == null || keyCp1251.length == 0){
            throw new IllegalArgumentException("Ключ должен быть длиннее 0");
        }

        byte[] out = new byte[input.length];

        for (int i = 0; i < input.length; i++){
            out[i] = vigenereByteCp1251(input[i], i, keyCp1251, encrypt);
        }

        return out;
    }

    //Многопоточная версия шифра Вижинера

    public static byte[] viginerParallelCp1251(byte[] input, byte[] keyCp1251, boolean encrypt,
                                               ExecutorService pool, int threads)
            throws InterruptedException {

        if (keyCp1251 == null || keyCp1251.length == 0) {
            throw new IllegalArgumentException("Ключ должен быть длины > 0");
        }
        if (threads <= 0) {
            throw new IllegalArgumentException("Число потоков должно быть > 0");
        }

        byte[] out = new byte[input.length];

        runParallel(pool, input.length, threads, (start, end) -> {
            for (int i = start; i < end; i++) {
                // важно: используем ГЛОБАЛЬНЫЙ индекс i, чтобы key[i % keyLen] совпадал как в single
                out[i] = vigenereByteCp1251(input[i], i, keyCp1251, encrypt);
            }
        });

        return out;
    }

    //Внутренние функции для работы с CP1251.
    //Алфавит и преобразования
    //Русский алфавит 33 буквы с "Ё"
    //Сдвиг - переход по кругу - mod 33.
    //Цифры, латиницу, символы возвращяем как есть

    private static byte cesarByteCp1251(byte b, int shift) {
        //Нормализуем сдвиг, так как 1 и 34 = один и тот же сдвиг на 1
        int s = mod(shift, 33);

        int x = b & 0xFF; //byte = -128..127, переводим в 0..255

        //Обработка верхнего регистра
        if (x == 0xA8) {
            return shiftUpper(0, s);
        }
        if (x >= 0xC0 && x <= 0xDF) {// А..Я
            int pos = (x - 0xC0) + 1; // А->1 .. Я -> 32
            return shiftUpper(pos, s);
        }

        //Нижний регистр
        if (x == 0xB8) { // 'ё'
            return shiftLower(0, s);
        }
        if (x >= 0xE0) { // 'а'..'я'
            int pos = (x - 0xE0) + 1; // 'а'->1 ... 'я'->32
            return shiftLower(pos, s);
        }

        // Пробелы, точки, цифры, латиница не трогаем
        return b;
    }

    //Вижинер для одного байта:
    //Получаем индекс буква ключа (0..32),
    //Используем его как сдвиг для шифра Цезаря

    private static byte vigenereByteCp1251(byte b, int globalIndex, byte[] key, boolean encrypt){
        int k = key[globalIndex % key.length] & 0xFF;

        int keyShift = cp1251RuLetterIndex(k);
        if (keyShift < 0) {
            //Если в ключе не символ алфавита - оставляем как есть
            return b;
        }

        //Для расшифрования сдвиг делаем отрицательным
        int shift = encrypt ? keyShift : - keyShift;

        return cesarByteCp1251(b, shift);
    }

    //Возвращаем индекс русской буквы для CP1251:
    //Или -1
    private static int cp1251RuLetterIndex(int x) {
        if (x == 0xA8 || x == 0xB8) return 0;                 // Ё/ё
        if (x >= 0xC0 && x <= 0xDF) return (x - 0xC0) + 1;     // А..Я
        if (x >= 0xE0 && x <= 0xFF) return (x - 0xE0) + 1;     // а..я
        return -1;
    }

    //Сдвиг по кругу для верхнего регистра mod 33

    private static byte shiftUpper (int pos, int shift){
        int newPos = mod(pos + shift, 33);
        if (newPos == 0) return (byte) 0xA8; // Ё
        return (byte) (0xC0 + (newPos - 1)); // А..Я
    }

    //Сдвиг по кругу для нижнего регистра mod 33
    private static byte shiftLower(int pos, int shift) {
        int newPos = mod(pos + shift, 33);
        if (newPos == 0) return (byte) 0xB8; // ё
        return (byte) (0xE0 + (newPos - 1)); // а..я
    }

    // Так как в Java -1 % 33 = -1 приводим к положительному
    private static int mod(int a, int m){
        int r = a % m;
        return (r < 0) ? (r + m) : r;
    }

    //=====================================
    // Общая функция для многопоточности
    //=====================================

    //раздаём диапазоны [start, end)
    private interface RangeTask {
        void run(int start, int end);
    }

    //Можно не синхронизировать потоки, так как каждый пишет в свой участок массива out[start..end)
    //Диапазоны не пересекаются

    private static void runParallel(ExecutorService pool, int n, int threads, RangeTask task)
            throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(threads);

        for (int t = 0; t < threads; t++) {
            //Делим по формуле fool(t*n/threads), находим start и end для каждого участка
            final int start = (int) ((long) t * n / threads);
            final int end   = (int) ((long) (t + 1) * n / threads);

            pool.submit(() -> {
                try {
                    task.run(start, end);
                } finally {
                    latch.countDown();
                }
            });
        }
        //ждём завершения потоков
        latch.await();
    }
}
