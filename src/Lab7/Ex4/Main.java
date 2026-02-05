package Lab7.Ex4;

public class Main {
    public static void main(String[] args) {
        Ex4_super test1 = new Ex4_super('A');
        Ex4_ext test2 = new Ex4_ext('B',"Привет");
        Ex4_ext_sub test3 = new Ex4_ext_sub('F', "Дом", 2012);

        Ex4_ext_sub test4 = new Ex4_ext_sub(test3);

        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println(test3.toString());
        System.out.println(test4.toString());



    }
}
