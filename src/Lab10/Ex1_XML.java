package Lab10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.Scanner;

public class Ex1_XML {

    //Добавление книги
    public static void recBook(Document doc, Element rootElement, String title1, String author1, String year1) {

        Element book = doc.createElement("book");
        rootElement.appendChild(book);

        Element title = doc.createElement("title");
        title.appendChild(doc.createTextNode(title1));
        book.appendChild(title);

        Element author = doc.createElement("author");
        author.appendChild(doc.createTextNode(author1));
        book.appendChild(author);

        Element year = doc.createElement("year");
        year.appendChild(doc.createTextNode(year1));
        book.appendChild(year);
    }

    //Запись в XML-файл
    public static void recordFile(Document doc) throws TransformerException {

        doc.setXmlStandalone(true);
        doc.normalizeDocument();
        javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
        javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
        javax.xml.transform.stream.StreamResult result =
                new javax.xml.transform.stream.StreamResult(new File("tmp/lr10/ex1.xml"));
        transformer.transform(source, result);

        System.out.println("XML-файл успешно создан!");
    }

    //Чтение тега
    private static String getTagText(Element element, String tag) {
        NodeList list = element.getElementsByTagName(tag);
        if (list == null || list.getLength() == 0 || list.item(0) == null) {
            return null; // нет такого тега
        }
        return list.item(0).getTextContent().trim();
    }

    //Поиск по автору
    private static void searchByAuthor(Document doc, String authorQuery) {
        NodeList books = doc.getElementsByTagName("book");
        boolean found = false;

        for (int i = 0; i < books.getLength(); i++) {
            Node node = books.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) continue;

            Element book = (Element) node;

            String author = getTagText(book, "author");
            if (author == null) continue;

            if (author.toLowerCase().contains(authorQuery.toLowerCase())) {
                found = true;
                String title = getTagText(book, "title");
                String year = getTagText(book, "year");
                System.out.println("Найдена книга: " + title + " | " + author + " | " + year);
            }
        }

        if (!found) {
            System.out.println("По автору \"" + authorQuery + "\" ничего не найдено.");
        }
    }

    //Поиск по году
    private static void searchByYear(Document doc, String yearQuery) {
        NodeList books = doc.getElementsByTagName("book");
        boolean found = false;

        for (int i = 0; i < books.getLength(); i++) {
            Node node = books.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) continue;

            Element book = (Element) node;

            String year = getTagText(book, "year");
            if (year == null) continue;

            if (year.equals(yearQuery.trim())) {
                found = true;
                String title = getTagText(book, "title");
                String author = getTagText(book, "author");
                System.out.println("Найдена книга: " + title + " | " + author + " | " + year);
            }
        }

        if (!found) {
            System.out.println("По году \"" + yearQuery + "\" ничего не найдено.");
        }
    }

    public static void deliteBook(Document doc, String title){
        NodeList books = doc.getElementsByTagName("book");

        String titleToDelite = title;

        for (int i = books.getLength() - 1; i >= 0; i--){
            Node node = books.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) continue;

            Element bookElement = (Element) node;

            //Берём title от book
            Node titleNode = bookElement.getElementsByTagName("title").item(0);
            if (titleNode == null) continue;

            String titles = titleNode.getTextContent().trim();

            if (titles.equalsIgnoreCase(titleToDelite.trim())){
                Node parentNode = bookElement.getParentNode();
                parentNode.removeChild(bookElement);
                break;
            }
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBulder = docFactory.newDocumentBuilder();

        //Создание корневого элемента
        Document doc = docBulder.newDocument();
        Element rootElement = doc.createElement("library");
        doc.appendChild(rootElement);

        try {
            //Добавление первой книги
            Element book1 = doc.createElement("book");
            rootElement.appendChild(book1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Война и мир"));
            book1.appendChild(title1);

            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Лев Толстой"));
            book1.appendChild(author1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1869"));
            book1.appendChild(year1);

            //Добавление второй книги
            Element book2 = doc.createElement("book");
            rootElement.appendChild(book2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Мастер и Маргарита"));
            book2.appendChild(title2);

            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("Михаил Булгаков"));
            book2.appendChild(author2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1867"));
            book2.appendChild(year2);

            //Добавление книг с помощью метода
            recBook(doc, rootElement, "Вино из одуванчиков", "Рэй Брэдбери", "1957");
            recBook(doc, rootElement, "Метафизика", "Аристотель", "IV век до н.э.");

            recordFile(doc);


        } catch (Exception pce) {
            pce.printStackTrace();
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Библиотека. Для записи книги введите - 0, для поиска введите - 1, для удаления книги - 2");

        switch (in.nextLine()) {
            case "0":
                System.out.println("Последовательно введите название, автора, год");
                recBook(doc, rootElement, in.nextLine(), in.nextLine(), in.nextLine());
                recordFile(doc);
                break;

            case "1":
                System.out.println("Критерий поиска: 0 - Автор, 1 - год");
                switch (in.nextLine()) {
                    case "0":
                        System.out.print("Введите автора:");
                        String authorQuery = in.nextLine();
                        searchByAuthor(doc, authorQuery);
                        break;

                    case "1":
                        System.out.print("Введите год: ");
                        String yearQuery = in.nextLine();
                        searchByYear(doc, yearQuery);
                        break;

                    default:
                        System.out.println("Неизвестная команда");
                        break;
                }
                break;
            case "2":
                System.out.println("Введите название книги для удаления");
                deliteBook(doc, in.nextLine());
                recordFile(doc);
                break;

            default:
                System.out.println("Неизвестная команда");
                break;
        }
    }
}