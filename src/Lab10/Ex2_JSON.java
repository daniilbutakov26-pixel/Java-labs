package Lab10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Ex2_JSON {

    //Запись JSON
    public static void recordJSON(JSONObject library){
        try (FileWriter file = new FileWriter("tmp/lr10/ex2.json")) {
            file.write(library.toJSONString());
            System.out.println("JSON создан!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Чтение и вывод всех книг
    public static void writeJSON(String URL){

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(URL));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                System.out.println("\nНазвание книги: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год издания: " + book.get("year"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    //Добавление книги
    public static void addBook(JSONArray books, String title, String author, String year){
        JSONObject book = new JSONObject();
        book.put("title", title);
        book.put("author", author);
        book.put("year", year);
        books.add(book);
    }

    //поиск по автору
    public static JSONArray searthByAuthor(JSONArray books, String authorQuery){
        JSONArray result = new JSONArray();
        if (authorQuery == null) return result;

        String q = authorQuery.trim().toLowerCase();

        for (Object obj : books) {
            if (!(obj instanceof JSONObject)) continue;
            JSONObject book = (JSONObject) obj;

            Object authorObj = book.get("author");
            if (authorObj == null) continue;

            String author = authorObj.toString().toLowerCase();

            if (author.contains(q)) {
                result.add(book);
            }
        }
        return result;
    }

    //Для вывода книг после поиска
    public static void printBooks(JSONArray arr) {
        if (arr.isEmpty()) {
            System.out.println("Ничего не найдено.");
            return;
        }
        for (Object obj : arr) {
            JSONObject b = (JSONObject) obj;
            System.out.println(
                    b.get("title") + " | " + b.get("author") + " | " + b.get("year")
            );
        }
    }

    //Удаляем первую найденную книгу по названию
    public static void deleteFirstByTitle(JSONArray books, String titleToDelete) {
        String t = titleToDelete.trim().toLowerCase();

        for (int i = 0; i < books.size(); i++) {
            Object obj = books.get(i);
            if (!(obj instanceof JSONObject)) continue;

            JSONObject book = (JSONObject) obj;
            Object titleObj = book.get("title");
            if (titleObj == null) continue;

            String title = titleObj.toString().trim().toLowerCase();

            if (title.equals(t)) {
                books.remove(i);   // удаляем по индексу
            }
        }
    }

    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        addBook(books, "Война и мир", "Лев Толстой", "1869");
        addBook(books, "Мастер и Маргарита", "Михаил Булгаков", "1967");
        addBook(books, "1984", "Джордж Оруэлл", "1949");

        library.put("books", books);

        recordJSON(library);

        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Выберите действие: e - выход, 0 - добавить книгу, 1 - поиск, 2 - удаление");

            if (in.nextLine().equalsIgnoreCase("e")){
                break;
            }

            switch (in.nextLine()){
                case "0":
                    System.out.println("Введите: Название, Автора, Год");
                    addBook(books, in.nextLine(), in.nextLine(), in.nextLine());
                    recordJSON(library);
                    break;
                case "1":
                    System.out.println("Введите автора");
                    JSONArray b = searthByAuthor(books, in.nextLine());
                    printBooks(b);
                    break;
                case "2":
                    System.out.println("Введите название книги для удаления");
                    deleteFirstByTitle(books, in.nextLine());
                    recordJSON(library);
                    break;
                default:
                    System.out.println("Не верный ввод");
                    break;
            }
        }
        writeJSON("tmp/lr10/ex2.json");
    }
}
