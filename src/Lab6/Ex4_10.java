package Lab6;

import Lab6.Ex3.Ex3;

import java.sql.PreparedStatement;
import java.util.Arrays;

public class Ex4_10 {

    //Ex4 - n!! факториал через 2. n!! = n*(n-2)*(n-4)*...
    public static int factorialN(int num){
        int rez = 1;

        if (num % 2 == 0){
            for (int i = num; i != 2; i -= 2){
                rez *= i;
            }
            rez *= 2;
        } else {
            for (int i = num; i != 1; i -= 2){
                rez *= i;
            }
        }

        return rez;
    }

    //Ex5 сумма квадратов до N
    public static int sumPowerToN(int N){
        int rez = 0;

        for (int i = 1; i <= N; i++){
            rez += i * i;
        }

        return rez;
    }

    //Ex6 - копия первых N эллементов массива
    public static int[] coppyArrToN(int[] arr, int N){
        int[] temp;
        if (N < arr.length){
            temp = Arrays.copyOf(arr, N);
        } else {
            temp = Arrays.copyOf(arr, arr.length);
        }


        return temp;
    }

    //Ex7 - char массив в массив int кодов от char
    public static int[] toCodes(char[] arr){
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }

        return temp;
    }

    //Ex8 - среднее значение эллементов массива
    public static double average(int[] arr){
        double temp = 0;

        for (int i = 0; i < arr.length; i++){
            temp += arr[i];
        }

        return temp / arr.length;
    }

    //Ex9 - попарная замена эллементов массива 1, 2, 3, 4 = 4, 3, 2, 1
    public static char[] swapEllements(char[] arr){
        int lenght = arr.length-1;
        //Проходим половину массива, так как замена парная
        for (int i = 0; i < arr.length / 2; i++){
            char temp = arr[i];
            arr[i] = arr[lenght];
            arr[lenght] = temp;
            lenght--;
        }

        return arr;
    }

    //Ex10 - принимаем массив int возвращаем массив int[2]{min,max}
    //Используем класс Ex3 из Ex3 шестой лабораторной работы, там уже делали min и max
    public static int[] getMinMax(int ... arr){
        Ex3 calc = new Ex3();

        int[] rez = {calc.getMin(arr),calc.getMax(arr)};

        return rez;
    }

}
