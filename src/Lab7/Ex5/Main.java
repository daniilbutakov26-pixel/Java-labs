package Lab7.Ex5;

public class Main {
    public static void main(String[] args) {

        class Top {
            private String str1;

            public Top(String str1){
                this.str1 = str1;
            }

            protected String getText(){
                return str1;
            }

            public void show(){
                System.out.println(getClass().getSimpleName() + "{text='" + getText() + "'}");
            }
        }

        class Mid extends Top{

            protected int num1;

            public Mid(String str1, int num1){
                super(str1);
                this.num1 = num1;
            }

            public void show(){
                System.out.println(getClass().getSimpleName() + "{text='" + getText() + ", num1= " + num1 + "'}");
            }
        }

        class Bot extends Top{

            protected char ch1;

            public Bot(String str1, char ch1){
                super(str1);
                this.ch1 = ch1;
            }

            public void show(){
                System.out.println(getClass().getSimpleName() + "{text='" + getText() + ", ch1= " + ch1 +"'}");
            }
        }

        Top test1 = new Top("Привет");
        Mid test2 = new Mid("Хочу", 25);
        Bot test3 = new Bot("Дом", 'W');

        test1.show();
        test2.show();
        test3.show();
    }
}


