package Lab5.Ex5;

public class Main {
    public static void main(String[] args) {

        Ex5 test1 = new Ex5();
        Ex5 test2 = new Ex5(45);

        //Выводим значения num1
        System.out.println(test1.getNum1());
        System.out.println(test2.getNum1());

        //Переписываем значения num1
        test1.setNum1(122);
        test2.setNum1();

        //Выводим новые значения num1
        System.out.println(test1.getNum1());
        System.out.println(test2.getNum1());

    }
}
