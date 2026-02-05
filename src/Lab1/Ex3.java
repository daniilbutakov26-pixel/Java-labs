package Lab1;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Последовательно введите текущий день недели, название месяца, номер дня");
        String str = in.nextLine() + " ";
        str += in.nextLine() + " ";
        str += in.nextLine() + " ";
        System.out.println("Сегодня: " + str);
    }
}
