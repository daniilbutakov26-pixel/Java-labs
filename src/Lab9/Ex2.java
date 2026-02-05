package Lab9;

import java.util.Scanner;

public class Ex2 {
    // Рекурсивный перевод в двоичную систему (без ведущих нулей)
    static String toBinary(int n) {
        if (n == 0) return "0";

        // обработка отрицательных чисел: знак + перевод модуля
        if (n < 0) return "-" + toBinaryPositive(-n);

        return toBinaryPositive(n);
    }

    // Рекурсивный перевод для n > 0
    static String toBinaryPositive(int n) {
        if (n == 0) return "";                 // база рекурсии для сборки строки
        return toBinaryPositive(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое число: ");

        int n = in.nextInt();
        System.out.println("Двоичное представление: " + toBinary(n));
    }
}
