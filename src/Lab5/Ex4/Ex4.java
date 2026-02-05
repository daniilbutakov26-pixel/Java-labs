package Lab5.Ex4;

public class Ex4 {
    private char ch1;
    private int num1;

    public Ex4(int num1,char ch1){
        this.ch1 = ch1;
        this.num1 = num1;
    }

    public Ex4(double x){
        this.num1 = (int) (Math.abs(x) * 100) % 100;
        this.ch1 = (char)((int) Math.abs(x));
    }

    public void getAll(){
        System.out.println(this.ch1 + " " + num1);
    }
}
