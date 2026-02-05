package Lab8.Ex1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Ex3 {
    // Считывание по 5 символов (буфер)
    public static void readAllByArray(InputStream in) throws IOException {
        byte[] buff = new byte[5];

        while (true) {
            int count = in.read(buff);
            if (count != -1) { // если не конец файла
                System.out.println("количество = " + count + ", buff = "
                        + Arrays.toString(buff) + ", str = "
                        + new String(buff, 0, count, "cp1251")); // "UTF8"
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "tmp/text.txt";
        InputStream inFile = null; // переменная объявляется до секции try, чтобы не ограничивать область видимости

        try {
            inFile = new FileInputStream(fileName);
            readAllByArray(inFile);

        } catch (IOException e) {
            System.out.println("Ошибка открытия-закрытия файла " + fileName + e);

        } finally { // корректное закрытие потока
            if (inFile != null) {
                try {
                    inFile.close();
                } catch (IOException ignore) {
                    /*NOP*/ // «No OPeration» — ничего не делать
                }
            }
        }
    }}
