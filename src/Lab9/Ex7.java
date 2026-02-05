package Lab9;

import java.util.*;

public class Ex7 {

    //Универсальная симуляция под Array и Linked List
    //Удаляем каждый второй эллемент
    static int simulate(List<Integer> people){
        ListIterator<Integer> it = people.listIterator();
        boolean removeThis = false;

        while (people.size() > 1) {
            if (!it.hasNext()) {
                it = people.listIterator();
            }

            it.next();

            if (removeThis) {
                it.remove();
            }

            removeThis = !removeThis;
        }

        return people.get(0);

    }

    static  List<Integer> buildArrayList(int n){
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) list.add(i);
        return list;
    }

    static  List<Integer> buildLinkedList(int n){
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N: ");
        int n = in.nextInt();

        if (n <= 0){
            System.out.println("N Должно быть > 0");
            return;
        }

        //ArrayList
        List<Integer> a = buildArrayList(n);
        long t0 = System.nanoTime();
        int winnerA = simulate(a);
        long t1 = System.nanoTime();

        //LinkedList
        List<Integer> l = buildLinkedList(n);
        long t2 = System.nanoTime();
        int winnerL = simulate(l);
        long t3 = System.nanoTime();

        System.out.println("\nПобедитель (ArrayList): " + winnerA);
        System.out.println("Победитель (LinkedList): " + winnerL);

        System.out.println("\nВремя ArrayList:  " + (t1 - t0) + " нс");
        System.out.println("Время LinkedList: " + (t3 - t2) + " нс");


    }
}
