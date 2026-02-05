package Lab7.Ex3;

public class Main {
    public static void main(String[] args) {
        Ex3_super test1 = new Ex3_super(1);
        Ex3_ext test2 = new Ex3_ext(1,'F');
        Ex3_ext_sub test3 = new Ex3_ext_sub(1,'D', "Hello");
        
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println(test3.toString());


    }
}
