package Lab9;

class Nodes {

    public int value;

    public Nodes next;

    public Node previous;

    public Nodes(int value, Nodes next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}

public class Ex5 {
    public static void main(String[] args) {

        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node ref = node0;
        while (ref !=null){
            //Выводим текущего и делаем текущим следующего
            System.out.print(" " + ref.value);
            ref = ref.next;
        }

        //создание с хвоста
        Node head = null;
        for (int i = 9; i >=0; i --){
            head = new Node(i, head);
        }

        //Вывод на экран
        Node ref1 = head;
        while (ref1 != null){
            System.out.println(" " + ref1.value);
            ref1 = ref1.next;
        }


    }
}
