package Lab1;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите чило");
        int num = in.nextInt();

        System.out.println((num-1) +" "+ num + " " + (num+1) + " " + (num*3)*(num*3));

    }
}
