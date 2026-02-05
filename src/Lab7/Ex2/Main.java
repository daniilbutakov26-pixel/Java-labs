package Lab7.Ex2;

public class Main {
    public static void main(String[] args) {
        Ex2_super test1 = new Ex2_super("Hello");
        Ex2_ext test2 = new Ex2_ext("Hi", 20);

        //Вывод начальных значений
        System.out.println(test1.getStr1() + " " + test1.getLengthStr1());
        System.out.println(test2.toString());

        //Переопределение
        test1.setStr1("Привет");
        test2.setStr1("Даниил"); //Перепишится следующей строкой
        test2.set("Дом", 7);


        //Повторный вывод
        System.out.println(test1.getStr1() + " " + test1.getLengthStr1());
        System.out.println(test2.toString());
    }
}
