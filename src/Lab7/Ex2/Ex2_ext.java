package Lab7.Ex2;

public class Ex2_ext extends Ex2_super{

    public int num1 = 0;

    public Ex2_ext(String str1, int num1) {
        super(str1);
        this.num1 = num1;
    }

    @Override
    public void setStr1(String str1) {
        super.setStr1(str1);
    }

    public void setStr1() {
        super.setStr1("");
        this.num1 = 0;
    }

    public void set(int num) {
        this.num1 = num;
    }

    public void set(String str1, int num) {
        super.setStr1(str1);
        this.num1 = num1;
    }

    @Override
    public String toString() {
        return "SubClass{num=" + num1 + ", text='" + getStr1() + "', len=" + getLengthStr1() + "}";
    }
}
