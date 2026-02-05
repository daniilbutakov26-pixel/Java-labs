package Lab3;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length1 = in.nextInt();

        int sum = 0, i = 0;

        //for
        for (i = 1; i < length1; i++){
            if (i % 5 == 2 || i % 3 == 1){
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("Сумма = " + sum);
        sum = 0;
        i = 0;
        //while
        while (i < length1){
            if (i % 5 == 2 || i % 3 == 1){
                System.out.print(i + " ");
                sum += i;
            }
            i++;
        }
        System.out.println("Сумма = " + sum);

    }
}
