package Lab1;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите Ваш возраст");
        int age = Integer.parseInt(in.nextLine());

        age = LocalDate.now().getYear() - age;
        System.out.println("Ваш год рождения - " + age);
    }
}
