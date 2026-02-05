package Lab3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите длинну выводимой последовательности Фибоначи");
        int length1 = in.nextInt();
        int next = 0;
        //For
        int a = 1, b = 1, i = 0;
        for (i = 0; i < length1; i++){
            System.out.print(a + " ");
            next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
        //While
        a = 1;
        b = 1;
        i = 0;
        while (i < length1) {
            System.out.print(a + " ");
            next = a + b;
            a = b;
            b = next;
            i++;
        }
    }
}
