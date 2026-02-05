package Lab8;

import java.io.*;
import java.util.Scanner;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class Ex2 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        File file1 = new File("tmp/Ex2_1.txt");
        File file2 = new File("tmp/Ex2_2.txt");
        file1.createNewFile();
        if (file1.exists()) {
            System.out.println("Создан");
            System.out.println("Путь1: " + file1.getAbsolutePath());
        }

        in.nextLine();

        System.out.println("Последовательно ведите 2 строки и 5 double чисел: ");
        //провека i < 7 так как мы заранее знаем сколько там должно быть строк
        try (BufferedWriter bw = Files.newBufferedWriter(file1.toPath(), StandardCharsets.UTF_8
                , StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

            for (int i = 0; i < 7; i++) {
                bw.write(in.nextLine());
                bw.newLine();
            }
        }

        //file1 -> file2
        try (BufferedReader br = Files.newBufferedReader(file1.toPath(), StandardCharsets.UTF_8);
             BufferedWriter bw2 = Files.newBufferedWriter(file2.toPath(), StandardCharsets.UTF_8,
                     StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)){
             int countLine = 0;
             String line;

             while ((line = br.readLine()) != null){
                 countLine++;
                 if (countLine == 2){
                     bw2.write(line);
                     bw2.newLine();
                 }
                 //Проверяем условие
                 try {
                     double x = Double.parseDouble(line);
                     if (x >= 0){
                         bw2.write(line);
                         bw2.newLine();
                     }
                 } catch (NumberFormatException e){

                 }
             }
            System.out.println("Готово. file2: " + file2.toPath());
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}

