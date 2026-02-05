package Lab5.Ex3;

public class Main {
    public static void main(String[] args) {

        Ex3 test1 = new Ex3();

        Ex3 test2 = new Ex3(1);

        Ex3 test3 = new Ex3(5,7);

        //Вывод без полей/с одним полем/с двумя полями
        System.out.println(test1.getAll());
        System.out.println(test2.getAll());
        System.out.println(test3.getAll());
    }
}
