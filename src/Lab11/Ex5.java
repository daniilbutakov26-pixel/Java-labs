package Lab11;

import java.util.List;
import java.util.stream.Collectors;

public class Ex5 {

    public static void main(String[] args) {

        String string = "Напишите функцию, Которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки, " +
                "которые включают в себя подстроку На.";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings, "На");

        System.out.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list, String sub) {
        return list.stream()
                .filter(s -> s.contains(sub))
                .collect(Collectors.toList());
    }
}