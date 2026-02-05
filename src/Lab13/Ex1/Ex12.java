package Lab13.Ex1;

public class Ex12 {
    public static void m(String str, double chislo) {
        try {
            if (str == null) {
                throw new IllegalArgumentException("Строка введена неверно");
            }
            if (chislo > 0.001) {
                throw new IllegalArgumentException("Неверное число");
            }
        } catch (IllegalArgumentException e){
            System.out.println("Не верный аргумент " + e);
        }

    }

    public static void main(String[] args) {
        m(null, 0.00001);
    }
}
