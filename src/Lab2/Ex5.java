package Lab2;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число");
        int num1 = in.nextInt();

        num1 = num1 / 1000;
        System.out.println("В вашем числе " + num1 + " тысяч");

    }
}
