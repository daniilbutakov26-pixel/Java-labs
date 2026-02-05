package Lab13.Ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2 {

    // Ошибка: такого столбца нет
    static class NoSuchColumnException extends Exception {
        public NoSuchColumnException(String message) {
            super(message);
        }
    }

    // Печать столбца (номер столбца задаём 1..m)
    static void printColumn(int[][] a, int colNumber) throws NoSuchColumnException {
        int rows = a.length;
        int cols = a[0].length;

        if (colNumber < 1 || colNumber > cols) {
            throw new NoSuchColumnException(
                    "Столбца №" + colNumber + " нет. Допустимый диапазон: 1.." + cols
            );
        }

        int j = colNumber - 1; // перевод в индекс 0..m-1
        System.out.println("Столбец №" + colNumber + ":");
        for (int i = 0; i < rows; i++) {
            System.out.println(a[i][j]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12}
        };

        try {
            System.out.print("Введите номер столбца (1.." + matrix[0].length + "): ");
            int col = sc.nextInt(); // InputMismatchException

            printColumn(matrix, col);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: нужно ввести целое число (номер столбца).");

        } catch (NoSuchColumnException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

