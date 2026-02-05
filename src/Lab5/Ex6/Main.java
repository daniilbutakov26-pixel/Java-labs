package Lab5.Ex6;

public class Main {
    public static void main(String[] args) {
        Ex6 test1 = new Ex6(10, 25);
        Ex6 test2 = new Ex6(10);

        test1.getMinMax();
        test2.getMinMax();

        test1.setMinMax(-15,22);
        test2.setMinMax(50);

        test1.getMinMax();
        test2.getMinMax();

        test1.setMinMax(100);
        test2.setMinMax(75,-5);

        test1.getMinMax();
        test2.getMinMax();
    }
}
