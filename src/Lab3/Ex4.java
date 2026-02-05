package Lab3;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Последовательно введите два целых числа");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int i = 0;
        //проверим и упорядочим введённые числа
        if (num2 < num1){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        //вывод в for
        for (i = num1; i <= num2; i++){
            System.out.print(i + " ");
        }

        System.out.println();
        //вывод в while
        i = num1;
        while (i <=num2){
            System.out.print(i + " ");
            i++;
        }
    }
}
