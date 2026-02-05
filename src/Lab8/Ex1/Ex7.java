package Lab8.Ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter out = null;

        try {
            // Создание файловых символьных потоков для чтения и записи
            br = new BufferedReader(new FileReader("tmp/MyFile1.txt"), 1024);
            out = new BufferedWriter(new FileWriter("tmp/MyFile2.txt"));

            int lineCount = 0;   // счетчик строк
            String s;

            // Переписывание информации из одного файла в другой
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                out.write(s);
                out.newLine();   // переход на новую строку
            }

        } catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");
        } finally {
            if (br != null) br.close();
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
