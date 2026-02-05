package Lab13.Ex1;

public class Ex6 {
    //Меняли местами Exception и RuntimeException
    //так как предок не должен перехватывать ошибку раньше потомка
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("2");
        } catch (Exception e) {
            System.out.println("3");
        }
        System.out.println("4");
    }
}
