package Lab8.Ex1;

import java.io.*;
import java.net.URL;

public class Ex8 {

    public static void readAllByByte( Reader in)	throws IOException { while (true) {
        int oneByte = in.read();	// читает 1 байт
        if (oneByte != -1) {	// признак конца файла
            System.out.print((char) oneByte);
        } else {
            System.out.print("\n" + " конец ");
            break;
        }
    }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile	= new FileInputStream("tmp/MyFile1.txt");	// байтовый поток
            Reader rFile= new InputStreamReader(inFile,"UTF-8");	// символьный поток

            readAllByByte(rFile); System.out.print("\n\n\n"); inFile.close(); rFile.close(); // С потоком связана интернет-страница

            InputStream inUrl = new URL("http://ya.ru").openStream(); // байтовый поток
            Reader   rUrl=new  InputStreamReader(inUrl,  "UTF-8");	// символьный поток
            readAllByByte(rUrl); System.out.print("\n\n\n"); inUrl.close();
            rUrl.close(); // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream( new byte[] {5, 8, 3, 9, 11}); Reader rArray=new InputStreamReader(inArray,"UTF-8" ); // символьный поток
            readAllByByte(rArray); System.out.print("\n\n\n"); inArray.close(); rArray.close();
        } catch (IOException e) { System.out.println("Ошибка: "+ e);
        }
    }

}
