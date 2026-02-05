package Lab6.Ex1;

public class Main {
    public static void main(String[] args) {
        Ex1 test1 = new Ex1();

        //Устанавливаем значения и выводим результат
        test1.set('A');
        test1.set("Привет");
        test1.getAll();

        //Передаём символьный массив a
        char[] a = new char[]{'A','B', '!'};
        test1.set(a);
        test1.getAll();

        //Передаём символьный массив с одним эллементом
        char[] b = new char[]{'Н'};
        test1.set(b);
        test1.getAll();

    }


}
