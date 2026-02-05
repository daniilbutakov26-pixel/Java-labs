package Lab3;

import java.util.Arrays;

public class Ex8 {
    public static void main(String[] args) {
        char[] arr = new char[10];

        char ch = 'A';
        for (int i = 0;i < arr.length;){
            if (ch != 'A' && ch != 'E' && ch != 'I'){
                arr[i] = ch;
                i++;
            }
            ch++;
        }
    System.out.println(Arrays.toString(arr));


    }
}
