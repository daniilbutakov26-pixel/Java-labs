package Lab11;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();

        int[] arr1 = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr1[i] = random.nextInt(200);
        }

        System.out.println("Массив arr1 : " + Arrays.toString(arr1));

        int[] arrResult = findCommonElements(arr1, 4);

        System.out.println("Массив arrResult : " + Arrays.toString(arrResult));

    }

    private static int[] findCommonElements(int[] arr1, int n) {
        if (n == 0) return new int[0];
        return Arrays.stream(arr1)
                .filter(x -> x % n == 0).toArray();
    }
}