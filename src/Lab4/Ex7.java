package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Ex7 {
    public static void main(String[] args) {
        int rows = 4, cols = 4;

        int[][] arr1 = new int[rows][cols];

        Random random = new Random();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                arr1[i][j]= random.nextInt(10);
                System.out.println();
                for (int[] row : arr1) System.out.println(Arrays.toString(row));
            }
            i++;
            for (int j = cols - 1; j != 0; j--){
                arr1[i][j]= random.nextInt(10);
                System.out.println();
                for (int[] row : arr1) System.out.println(Arrays.toString(row));
            }
        }
    }
}
