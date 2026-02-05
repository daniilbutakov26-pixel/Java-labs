package Lab2;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число больше пяти и менее десяти");
        int num1 = in.nextInt();

        if (num1 >= 5 && num1 <= 10){
            System.out.println("Верно");
        } else {
            System.out.println("Не выполняет условие");
        }
    }
}
