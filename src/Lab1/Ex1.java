package Lab1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //пробуем собирать строку на ходу, что бы не плодить переменные
        System.out.println("Введите Фамилию");
        String name = "Привет " + in.nextLine();
        System.out.println("Введите Имя");
        name += " " + in.nextLine();
        System.out.println("Введите Отчество");
        name += " " + in.nextLine();

        //выводим
        System.out.printf(name);
    }


}
