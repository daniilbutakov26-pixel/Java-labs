package Lab7.Ex1;

public class Main {
    public static void main(String[] args) {
        Ex1_super super_test1 = new Ex1_super("Привет");

        System.out.println(super_test1.toString());

        Ex1_ext ext_test1 = new Ex1_ext("Hi", "Daniil");

        System.out.println(ext_test1.toString());

    }
}
