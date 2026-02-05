package Lab8.Ex1;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Ex10 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("tmp/MyFile1.txt"), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(new FileOutputStream("tmp/MyFile2.txt"), StandardCharsets.UTF_8))) {

            int lineCount = 0;
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }

        } catch (IOException e) {
            System.out.println("Ошибка !!!!!!!! " + e);
        }
    }
}
