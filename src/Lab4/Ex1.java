package Lab4;

public class Ex1 {
    public static void main(String[] args) {
        int col = 23;
        int row = 11;

        for (int i = 1; i <= row; i++){
            int z = 0;
            for (int j = 0; j < col; j++){
                System.out.print("+");
                z = z + 1;
            }
            System.out.println();
        }
    }
}
