package Lab9;

import java.util.HashMap;
import java.util.Map;

public class Ex6 {
    public static void main(String[] args) {

        // Создаём HashMap<int,str>
        HashMap<Integer, String> map = new HashMap<>();

        //Заполняем 10 значений
        map.put(0, "zero");
        map.put(1, "cat");
        map.put(2, "elephant");
        map.put(3, "house");
        map.put(4, "sun");
        map.put(5, "planet");
        map.put(6, "computer");
        map.put(7, "java");
        map.put(8, "keyboard");
        map.put(9, "monitor");

        //Нахождение тех, у которых ключ > 5
        System.out.println("key > 5: ");
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            int key = entry.getKey();
            String value = entry.getValue();

            if (key > 5) {
                System.out.println("key=" + key + " - " + value);
            }


        }

        //Если key = 0 -> выводим все строки
        if (map.containsKey(0)){
            System.out.println("\nКлючь 0 найден");

            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (String value : map.values()){
                if (!first) sb.append(", ");
                sb.append(value);
                first = false;
            }

            System.out.println(sb);
        } else {
            System.out.println("\nКлюч 0 не найден");
        }

        //Перемножить все ключи, где длинна строки > 5
        int pr = 1;
        boolean foundAny = false;

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            int key = entry.getKey();
            String value = entry.getValue();

            if (value.length() > 5){
                pr *= key;
                foundAny = true;
            }
        }

            if (foundAny){
                System.out.println("\nПроизведение ключей, где длинна строки > 5 = " + pr);
            } else {
                System.out.println("\nНет строк длиннее 5");
            }
    }
}
