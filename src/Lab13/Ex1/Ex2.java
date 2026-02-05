package Lab13.Ex1;

public class Ex2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            //Без комментария выключает все строки после
            if (true) {
                throw new RuntimeException("Непроверяемая ошибка");
            }
            System.out.println("1");
        } catch (Exception e){
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}
