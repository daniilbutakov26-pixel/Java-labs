package Lab1;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Последовательно введите два числа для сложения");
        float sum = in.nextFloat();
        sum += in.nextFloat();

        System.out.println("Сумма равна: " + sum);


    }
}
