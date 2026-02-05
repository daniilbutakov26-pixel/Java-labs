package Lab9;

class Node {

    public int value;

    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class Ex4 {
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
    }
}
