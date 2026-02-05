package Lab10;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex3_HTML {

    private static Document fetch2Tries(String url) throws IOException {
        try {
            return Jsoup.connect(url).timeout(10_000).get();
        } catch (IOException e) {
            System.out.println("Ошибка получения страницы: " + e.getMessage());
            System.out.println("Повторная попытка подключения...");

            // вторая попытка (если снова ошибка — пробросим дальше)
            return Jsoup.connect(url).timeout(10_000).get();
        }
    }

    public static void main(String[] args) {
        String url = "https://itlearn.ru/first-steps";
        Path out = Path.of("tmp/lr10/links.txt");

        try {
            Document doc = fetch2Tries(url);
            Elements links = doc.select("a[href]");

            Files.createDirectories(out.getParent());

            StringBuilder sb = new StringBuilder();
            for (Element link : links){
                String href = link.attr("abs:href");
                System.out.println(href);
                sb.append(href).append(System.lineSeparator());            }

            Files.writeString(out, sb.toString(), StandardCharsets.UTF_8);
            System.out.println("Ссылки сохранены в: " + out.toAbsolutePath());

        } catch (IOException e){
            System.out.println("Не удалось получить страницу даже после повторной попытки: " + e.getMessage());
        }
    }
}
