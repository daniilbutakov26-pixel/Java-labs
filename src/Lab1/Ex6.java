package Lab1;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //запрашиваем год рождения и имя пользователя
        System.out.println("Введите ваш год рождения в формате yyyy");
        int year = Integer.parseInt(in.nextLine());
        year = LocalDate.now().getYear() - year;

        System.out.println("Введите ваше имя");
        String name = in.nextLine();

        System.out.println("Добрый день, " + name + ", Ваш возраст " + year + " лет");

    }
}
