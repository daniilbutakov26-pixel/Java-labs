package Lab1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите месяц");
        String str = "В месяце " + in.nextLine();
        System.out.println("Введите дней в месце");
        str += " ровно " + in.nextLine() + " дней";

        System.out.println(str);


    }
}
