package Lab1;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите чило");
        int num1 = in.nextInt();
        System.out.println("Введите второе число");
        int num2 = in.nextInt();

        System.out.println("Сумма: " + (num1+num2) + " " + "разность: " + (num1-num2));
    }
}
