package Lab6;

import java.util.Arrays;

public class Main_Ex4_10 {
    public static void main(String[] args) {
        int[] arr1 = {1,4,5,6,2,3,6};
        char[] arr2 = {'1','4','5','6'};
        Ex4_10 test1 = new Ex4_10();

        //Ex4 - n!! факториал через 2. n!! = n*(n-2)*(n-4)*...
        System.out.println(test1.factorialN(5));

        //Ex5 сумма квадратов до N, при N = 3, будет 14
        System.out.println(test1.sumPowerToN(3));

        //Ex6 - копия первых N эллементов массива
        System.out.println(Arrays.toString(test1.coppyArrToN(arr1,25)));

        //Ex7 - char массив в массив int кодов от char
        System.out.println(Arrays.toString(test1.toCodes(arr2)));

        //Ex8 - среднее значение эллементов
        System.out.println(test1.average(arr1));

        //Ex9 - попарная замена эллементов массива {'1','4','5','6'} = {'6','5','4','1'}
        System.out.println(test1.swapEllements(arr2));

        //Ex10 - принимаем массив int возвращаем массив int[2]{min,max}
        //Используем класс Ex3 из Ex3 шестой лабораторной работы, там уже делали min и max
        System.out.println(Arrays.toString(test1.getMinMax(1,2,3,4,53,2,0,3)));

    }
}
