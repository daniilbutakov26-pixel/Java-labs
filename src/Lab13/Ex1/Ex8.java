package Lab13.Ex1;

public class Ex8 {
    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } catch (Exception e){
            System.out.println("Ошибка " + e);
        } finally {
            System.out.println("1");
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}

