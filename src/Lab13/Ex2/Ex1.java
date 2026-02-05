package Lab13.Ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {

    // Ошибка: нет положительных элементов
    static class NoPositiveElementsException extends Exception {
        public NoPositiveElementsException(String message) {
            super(message);
        }
    }

    // Ввод массива (ошибка ввода/тип/диапазон -> InputMismatchException)
    static int[] readArray(Scanner sc, int n) throws InputMismatchException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt(); // может выбросить InputMismatchException
        }
        return arr;
    }

    // Среднее положительных, если положительных нет -> исключение
    static double avgPositive(int[] arr) throws NoPositiveElementsException {
        long sum = 0;
        int count = 0;

        for (int x : arr) {
            if (x > 0) {
                sum += x;
                count++;
            }
        }

        if (count == 0) {
            throw new NoPositiveElementsException("Положительные элементы отсутствуют.");
        }

        return (double) sum / count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите N: ");
            int n = in.nextInt(); //может выбросить InputMismatchException

            if (n <= 0) {
                System.out.println("Ошибка: N должно быть > 0.");
                return;
            }

            int[] arr = readArray(in, n);
            double avg = avgPositive(arr);

            System.out.println("Среднее положительных: " + avg);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: нужно вводить целые числа типа int (без букв и без слишком больших чисел).");

        } catch (NoPositiveElementsException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        }
    }
}
