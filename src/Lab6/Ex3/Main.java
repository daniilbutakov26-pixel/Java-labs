package Lab6.Ex3;

public class Main {
    public static void main(String[] args) {

        Ex3 test1 = new Ex3();
        int [] a = {1,5,3,7,15,0,25};

        //Находим максимальное из переданых int
        System.out.println(test1.getMax(1,5,3,7,15,0,25));
        System.out.println(test1.getMin(1,5,3,7,15,0,25));
        System.out.println(test1.getAverage(1,5,3,7,15,0,25));

        //Передаём массив
        System.out.println(test1.getMax(a));
        System.out.println(test1.getMin(a));
        System.out.println(test1.getAverage(a));




    }
}
