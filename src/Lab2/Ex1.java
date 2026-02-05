package Lab2;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число");
        int num1 = in.nextInt();

        if (num1 % 3 == 0) {
            System.out.println("Делится на 3 без остатка");
        } else {
            System.out.println("не делится на 3 без остатка");
        }
    }
}
