package Lab3;

import java.util.Arrays;
import java.util.Random;

public class Ex9 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];


        for (int i = 0; i < arr.length;i++){
            arr[i] = random.nextInt(100);
        }

        int min = 1000, index = 0;
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
                index = i;
            }
        }
        System.out.println("Минимальный эллемент = " + min);

        for (int i = 0;i < arr.length;i++){
            if (arr[i]==min){
                System.out.println("Индекс = " + i);
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
