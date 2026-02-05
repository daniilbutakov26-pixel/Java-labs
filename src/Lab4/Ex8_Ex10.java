package Lab4;

import java.util.Scanner;

//Шифр Цезяря, произвольный алфавит, шифрует только символы алфавита
public class Ex8_Ex10 {
    static String caesar(String text, String alphabet, int shift) {
        char[] a = alphabet.toCharArray();
        char[] t = text.toCharArray();
        char[] res = new char[t.length];

        int n = a.length;
        if (n == 0) return text;

        // нормализуем сдвиг в диапазон 0..n-1
        shift = shift % n;
        if (shift < 0) shift += n;

        for (int i = 0; i < t.length; i++) {
            char c = t[i];

            // ищем c в алфавите
            int pos = -1;
            for (int j = 0; j < n; j++) {
                if (a[j] == c) {
                    pos = j;
                    break;
                }
            }

            // символ не из алфавита
            if (pos == -1) {
                res[i] = c;
            } else {
                int newPos = (pos + shift) % n;
                res[i] = a[newPos];
            }
        }

        return new String(res);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Алфавит:");
        String alphabet = in.nextLine();

        System.out.println("Сдвиг:");
        int shift = Integer.parseInt(in.nextLine());

        System.out.println("Текст:");
        String text = in.nextLine();

        System.out.println("1 - шифровать, 2 - расшифровать:");
        int mode = Integer.parseInt(in.nextLine());

        if (mode == 2) shift = -shift;

        System.out.println(caesar(text, alphabet, shift));
    }
}
