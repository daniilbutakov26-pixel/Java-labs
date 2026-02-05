package Lab4;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        int n = 5;

        int[][] arr = new int[n][n];

        int row_ = n, col_ = n;
        for (col_ = 0; col_ < n; col_++){
            for (row_ = 0; row_ < n; row_++){
                arr[col_][row_] = 2;
            }
        }
        for (int[] col : arr){
            System.out.println(Arrays.toString(col));
        }
    }
}
