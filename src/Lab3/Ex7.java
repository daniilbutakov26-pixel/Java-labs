package Lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {

        int length1 = 10;

        char[] arr = new char[length1];
        char a = 'A';
        for (int i = 0; i < arr.length;i++){
            arr[i]=a;
            a += 2;
        }
        System.out.println(Arrays.toString(arr));

    }
}
