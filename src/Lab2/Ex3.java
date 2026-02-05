package Lab2;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число кратное 4 и больше 10");
        int num1 = in.nextInt();

        if (num1 % 4 == 0 && num1 > 10){
            System.out.println("Верно");
        } else {
            System.out.println("Не выполняет условие");
        }
    }
}
