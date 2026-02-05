package Lab9;

import java.util.Scanner;

public class En3 {
    // Рекурсивный ввод массива
    //(Scanner) передаётся в рекурсивный метод, чтобы все рекурсивные вызовы использовали один и тот же объект ввода
    static void inputArray(int[] a, int i, Scanner sc) {
        if (i == a.length) return;          // база рекурсии
        System.out.print("a[" + i + "] = ");
        a[i] = sc.nextInt();
        inputArray(a, i + 1, sc);           // шаг рекурсии
    }

    // Рекурсивный вывод массива
    static void printArray(int[] a, int i) {
        if (i == a.length) return;          // база рекурсии
        System.out.print(a[i]);
        if (i < a.length - 1) System.out.print(" ");
        printArray(a, i + 1);               // шаг рекурсии
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер массива n: ");
        int n = in.nextInt();

        if (n < 0) {
            System.out.println("Размер массива не может быть отрицательным.");
            return;
        }

        int[] a = new int[n];

        System.out.println("Введите элементы массива:");
        inputArray(a, 0, in);

        System.out.print("Массив: ");
        printArray(a, 0);
        System.out.println();
    }
}
