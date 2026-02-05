package Lab13.Ex2;

import java.util.Scanner;

import java.util.InputMismatchException;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите N: ");
            int n = sc.nextInt();
            if (n <= 0) throw new IllegalArgumentException("N должно быть > 0");

            int sum = 0;

            for (int i = 0; i < n; i++) {
                System.out.print("arr[" + i + "] = ");
                int x = sc.nextInt(); // InputMismatchException

                // Проверка диапазона byte
                if (x < Byte.MIN_VALUE || x > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Элемент " + x + " не помещается в byte (-128..127)");
                }

                sum += x;

                // Проверка диапазона byte при суммировании
                if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Сумма вышла за диапазон byte (-128..127). sum=" + sum);
                }
            }

            System.out.println("Сумма (byte) = " + (byte) sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: нужно вводить целые числа (без букв).");

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } catch (ArithmeticException e) {
            System.out.println("Ошибка диапазона: " + e.getMessage());
        }
    }
}

