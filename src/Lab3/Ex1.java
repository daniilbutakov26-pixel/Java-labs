package Lab3;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число от 1 до 7 - день недели");
        int num1 = in.nextInt();

        switch (num1){
            case 1:
                System.out.println("Пн");
                break;
            case 2:
                System.out.println("Вт");
                break;
            case 3:
                System.out.println("Ср");
                break;
            case 4:
                System.out.println("Чт");
                break;
            case 5:
                System.out.println("Пт");
                break;
            case 6:
                System.out.println("Сб");
                break;
            case 7:
                System.out.println("Вс");
                break;
            default:
                System.out.println("Не выполнено условие");
        }
    }
}
