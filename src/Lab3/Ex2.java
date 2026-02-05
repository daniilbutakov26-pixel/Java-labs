package Lab3;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите день недели (слово)");
        String str = in.nextLine();

        //Switch реализация
        switch (str){
            case "Понедельник":
                System.out.println(1);
                break;
            case "Вторник":
                System.out.println(2);
                break;
            case "Среда":
                System.out.println(3);
                break;
            case "Четверг":
                System.out.println(4);
                break;
            case "Пятница":
                System.out.println(5);
                break;
            case "Суббота":
                System.out.println(6);
                break;
            case "Воскресение":
                System.out.println(7);
                break;
            default:
                System.out.println("Токого дня нет");
        }

        //Реализация на if, else if
        if (str.equals("Понедельник")) {
            System.out.println(1);
        } else if (str.equals("Вторник")) {
            System.out.println(2);
        } else if (str.equals("Среда")) {
            System.out.println(3);
        } else if (str.equals("Четверг")) {
            System.out.println(4);
        } else if (str.equals("Пятница")) {
            System.out.println(5);
        } else if (str.equals("Суббота")) {
            System.out.println(6);
        } else if (str.equals("Воскресение")) {
            System.out.println(7);
        } else {
            System.out.println("Такого дня нет");
        }

    }
}
