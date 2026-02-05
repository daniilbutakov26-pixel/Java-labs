package Lab6.Ex1;

public class Ex1 {

    char ch1;
    String str1;

    public void set(char ch1) {
        this.ch1 = ch1;
    }

    public void set(String str1) {
        this.str1 = str1;
    }

    public void set(char[] ch1) {
        if(ch1.length > 1){
            this.str1 = new String(ch1);
        } else {
            this.ch1 = ch1[0];
        }
    }

    public void getAll() {
        System.out.println(ch1 + " " + str1);
    }
}
