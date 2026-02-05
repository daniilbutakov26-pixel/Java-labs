package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Ex6 {
    public static void main(String[] args) {
        int rows = 4, cols = 4;

        int[][] arr1 = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                arr1[i][j] = random.nextInt(10);
            }
        }

        for (int[] col : arr1){
            System.out.println(Arrays.toString(col));
        }

        int del_rows = random.nextInt(4);
        int del_cols = random.nextInt(4);

        int[][] arr2 = new int[rows-1][cols-1];

        int bi = 0;
        for (int i = 0; i < rows; i++){
            if (i == del_rows) continue;
            int bj = 0;
            for (int j = 0; j < cols; j++){
                if (j == del_cols) continue;

                arr2[bi][bj]=arr1[i][j];
                bj++;
            }
            bi++;
        }

        System.out.println("Удаляем строку: " + del_rows + ", столбец: " + del_cols);

        for (int[] col : arr2){
            System.out.println(Arrays.toString(col));
        }


    }

}
