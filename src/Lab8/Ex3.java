package Lab8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class Ex3 {


    private static final String CONSONANTS = "БВГДЖЗЙКЛМНПРСТФЧЦЧШЩбвгджзйклмнпрстфхцчшщ";

    //Проверка, что строка не пустая и начинается с согласной true/false
    private static boolean startsWithConsonant(String word){
        if (word == null || word.isEmpty()){
            return false;
        }

        char first = word.charAt(0);

        return CONSONANTS.indexOf(first) >= 0;
    }

    private static String cleanWord(String word){
        if (word == null) {
            return "";
        }
        return word.replaceAll("^[^\\p{L}]+|[^\\p{L}]+$", "");
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);

        File file1 = new File("tmp/Ex3_1.txt");
        File file2 = new File("tmp/Ex3_2.txt");
        file1.createNewFile();

        if (file1.exists()) {
            System.out.println("Создан");
            System.out.println("Путь1: " + file1.getAbsolutePath());
        }


        //file1 -> file2
        try (BufferedReader br = Files.newBufferedReader(file1.toPath(), StandardCharsets.UTF_8);
             BufferedWriter bw = Files.newBufferedWriter(file2.toPath(), StandardCharsets.UTF_8,
                     StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)){
            int countLine = 0;
            String line;

            //Читаем файл построчно
            while ((line = br.readLine()) != null){
                countLine++;

                //Делим строки на слова
                String[] words = line.split(" ");

                //Собираем подходящие слова в List
                List<String> selectedWords = new ArrayList<>();

                //Перебираем слова из строки текста
                for (String word : words){
                    String cleanWord = cleanWord(word);

                    if (word.isEmpty()) continue;

                    //Проверяем условие "НАЧИНАЕТСЯ С СОГЛАСНОЙ"
                    if (startsWithConsonant(word)){
                        selectedWords.add(cleanWord);
                    }
                }

                // Количество подходящих слов в этой строке
                int count = selectedWords.size();

                //Записываем в выходной файл
                bw.write("Строка №" + countLine + ", количество = " + count);
                bw.newLine();

                if (count == 0) {
                    bw.write("-");
                } else {
                    bw.write(String.join(" ", selectedWords));
                }

                //Отступы
                bw.newLine();
                bw.newLine();
            }
            System.out.println("Готово. file2: " + file2.toPath());
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }

}
