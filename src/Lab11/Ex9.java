package Lab11;

import java.util.List;
import java.util.stream.Collectors;

public class Ex9 {

    public static void main(String[] args) {

        String string = "9. Напишите функцию (уже 9), которая принимает на вход " +
                "список строк и возвращает новый список!" +
                " Содержащий только те строки, " +
                "Которые содержат только буквы (без цифр и символов).";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings, 9);

        System.out.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s != null && !s.isEmpty())
                .filter(s -> s.chars().allMatch(Character::isLetter)).toList();
    }
}
