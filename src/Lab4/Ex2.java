package Lab4;

public class Ex2 {
    public static void main(String[] args) {
        int row = 6;
        String str = "+";

        for (int i = 1; i <= row; i++){
            System.out.println(str);
            str = str + "+";
        }
    }
}
