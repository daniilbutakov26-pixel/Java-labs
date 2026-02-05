package Lab3;

import java.util.Arrays;
import java.util.Random;

public class Ex10 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];


        for (int i = 0; i < arr.length;i++){
            arr[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int num1 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = num1;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
