package Lab1;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //На этот раз делаем разные переменные
        System.out.println("Введите имя");
        String name = in.nextLine();

        System.out.println("Введите ваш возраст");
        String age = in.nextLine();

        System.out.println("Информация: Имя - " + name + " возраст - " + age + " лет");




    }

}
