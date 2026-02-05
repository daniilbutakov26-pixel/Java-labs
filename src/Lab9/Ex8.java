package Lab9;

import java.util.Scanner;

public class Ex8 {

    static class SinglyIntList {

        private static class Node {
            int value;
            Node next;
            Node(int value, Node next){
                this.value = value;
                this.next = next;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public int size(){
            return size;
        }

        private void clear(){
            head = null;
            tail = null;
            size = 0;
        }

        //Пересчёт size и tail
        private void rebuldTailAndSize(){
            size = 0;
            tail = null;
            Node cur = head;
            while (cur != null){
                tail = cur;
                size++;
                cur = cur.next;
            }
        }

        //Ввод с головы
        public void creatHead(Scanner in, int n){
            clear();
            for (int i = 0; i < n; i++){
                int x = in.nextInt();
                AddFirst(x);
            }
        }

        //Ввод с хвоста
        public void createTail(Scanner in, int n){
            clear();
            for (int i = 0; i < n; i++){
                int x = in.nextInt();
                AddLast(x);
            }
        }

        //Ввод списком через пробел
        public String toString(){
            StringBuilder sb = new StringBuilder();
            Node cur = head;
            while (cur != null){
                sb.append(cur.value);
                if (cur.next != null) sb.append(" ");
                cur = cur.next;
            }
            return sb.toString();
        }

        //Добавление в начало
        public void AddFirst(int x){
            Node node = new Node(x, head);
            head = node;
            if (size == 0) tail = node;
            size++;
        }

        //Добавить в конец
        public void AddLast(int x){
            Node node = new Node(x, null);
            if (size == 0){
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        //Вставка по номеру позиции
        public void Insert(int position, int x){
            if (position < 1 || position > size + 1){
                throw new IllegalArgumentException("Error");
            }
            if (position == 1){
                AddFirst(x);
                return;
            }
            if (position == size+1){
                AddLast(x);
                return;
            }

            //Узлы перед позицией
            Node prev = head;
            for (int i = 1; i < position - 1; i++){
                prev = prev.next;
            }
            prev.next = new Node(x, prev.next);
            size++;
        }

        //Удаление с головы
        public int RemoveFirst(){
            if (size == 0 ) throw new IllegalStateException("Список пуст");
            int val = head.value;
            head = head.next;
            size--;
            if (size == 0) tail = null;
            return val;
        }

        //Удаление последнего
        public int RemoveLast(){
            if (size == 0 ) throw new IllegalStateException("Список пуст");
            if (size == 1) {
                int val = head.value;
                clear();
                return val;
            }

            //Ищем предпоследный узел
            Node prev = head;
            while (prev.next != tail) {
                prev = prev.next;
            }

            int val = tail.value;
            prev.next = null;
            tail = prev;
            size--;
            return val;
        }

        //Удаление по номеру позиции
        public int Remove(int position){
            if (position < 1 || position > size){
                throw new IllegalArgumentException("Error");
            }
            if (position == 1) return RemoveFirst();
            if (position == size) return RemoveLast();

            Node prev = head;
            for (int i = 1; i < position - 1; i++){
                prev = prev.next;
            }
            Node target = prev.next;
            int val = target.value;
            prev.next = target.next;
            size--;
            return val;
        }

        //МЕТОДЫ С РЕКУРСИЕЙ
        public void createHeadRec(Scanner in, int n){
            clear();
            head = createHeadRecImpl(in, n);
            rebuldTailAndSize();
        }

        private Node createHeadRecImpl(Scanner in, int n){
            if (n == 0) return null;
            Node rest = createHeadRecImpl(in, n - 1);
            int x = in.nextInt();
            return new Node(x, rest);
        }

        public void createTailRec(Scanner in, int n){
            clear();
            head = createHeadRecImpl(in, n);
            rebuldTailAndSize();
        }

        private Node createTailRecImpl(Scanner in, int n) {
            if (n == 0) return null;
            int x = in.nextInt();
            Node node = new Node(x, null);
            node.next = createTailRecImpl(in, n - 1);
            return node;
        }

        public String toStringRec() {
            StringBuilder sb = new StringBuilder();
            toStringRecImpl(head, sb);
            return sb.toString();
        }

        private void toStringRecImpl(Node node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.value);
            if (node.next != null) sb.append(" ");
            toStringRecImpl(node.next, sb);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SinglyIntList list = new SinglyIntList();

        System.out.print("Введите n: ");
        int n = in.nextInt();

        System.out.println("Введите " + n + " чисел (для createTail):");
        list.createTail(in, n);

        System.out.println("toString()     = " + list.toString());
        System.out.println("toStringRec()  = " + list.toStringRec());

        System.out.println("\nAddFirst(999), AddLast(111):");
        list.AddFirst(999);
        list.AddLast(111);
        System.out.println(list);

        System.out.println("\nInsert(position=2, value=555):");
        list.Insert(2, 555);
        System.out.println(list);

        System.out.println("\nRemoveFirst(): " + list.RemoveFirst());
        System.out.println("После RemoveFirst: " + list);

        System.out.println("\nRemoveLast(): " + list.RemoveLast());
        System.out.println("После RemoveLast: " + list);

        System.out.println("\nRemove(position=2): " + list.Remove(2));
        System.out.println("После Remove(2): " + list);
    }
}
