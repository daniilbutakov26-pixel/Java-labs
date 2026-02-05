package Lab8.Ex1;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Ex2 {
    public static void readAllByByte(InputStream in) throws IOException{
        while (true) {
            int oneByte = in.read();
            if (oneByte != -1){
                System.out.print((char) oneByte);
            } else {
                System.out.print("/n" + "end");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            InputStream inFile = new FileInputStream("tmp/text.txt");
            readAllByByte(inFile);
            System.out.print("n/n/n");
                inFile.close();

            InputStream inUrl = new URL("https://ya.ru/").openStream();
            readAllByByte(inUrl);
            System.out.print("n/n/n");
            inUrl.close();

            InputStream inArray=new ByteArrayInputStream(new byte[] {7,9,3,7,4});
            readAllByByte(inArray);
            System.out.print("n/n/n");
                inArray.close();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
