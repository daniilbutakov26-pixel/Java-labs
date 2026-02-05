package Lab1;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //запрашиваем год рождения
        System.out.println("Введите год рождения в формате yyyy");
        int year = Integer.parseInt(in.nextLine());

        //вычитаем из текущего года год рождения
        year = LocalDate.now().getYear() - year;
        System.out.println("Ваш возраст " + year + " лет");

    }
}
