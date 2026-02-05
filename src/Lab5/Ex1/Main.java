package Lab5.Ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Ex1 - ввод значения, вывод кода символа
        Ex1 test1 = new Ex1();

        System.out.println("Введите значение ch1");
        test1.setCh1(in.nextLine().charAt(0));

        test1.getInfo();
    }
}
