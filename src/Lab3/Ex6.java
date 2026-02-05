package Lab3;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите длинну массива");
        String str = in.nextLine();
        int length1 = 0;
        try {
            length1 = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка. Это не целое число.");
        }

        int[] mass = new int[length1];

        int i = 0, count = 0;
        while (count < mass.length){
            if (i % 5 == 2){
                mass[count] = i;
                count++;
            }
            i++;
        }
               System.out.println(Arrays.toString(mass));
    }
}
