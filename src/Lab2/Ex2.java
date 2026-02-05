package Lab2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число");
        int num1 = in.nextInt();

        if (num1 % 5 == 2 && num1 % 7 == 1){
            System.out.println("num % 2 = 2, num % 7 = 1");
        } else {
            System.out.println("не выполняет условие: num % 2= 2, num % 7 = 1");
        }
    }
}
