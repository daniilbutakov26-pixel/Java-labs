package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Ex5 {
    public static void main(String[] args) {
        Random random = new Random();

        int rows = 5, cols = 2;

        int[][] a = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = random.nextInt(10);
            }
        }

        int[][] b = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                b[j][i] = a[i][j];
            }

            System.out.println("Исходный массив:");
            for (int[] row : a) System.out.println(Arrays.toString(row));

            System.out.println("После замены строк и столбцов:");
            for (int[] row : b) System.out.println(Arrays.toString(row));
        }
    }
}
