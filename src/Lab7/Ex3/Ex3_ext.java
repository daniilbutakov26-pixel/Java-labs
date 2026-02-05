package Lab7.Ex3;

public class Ex3_ext extends Ex3_super {

    public char ch1;

    public Ex3_ext(int num1, char ch1) {
        super(num1);
        this.ch1 = ch1;
    }

    public void setNum1(int num1, char ch1) {
        super.setNum1(num1);
        this.ch1 = ch1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ex3_ext{");
        sb.append("num1=").append(num1);
        sb.append("ch1=").append(ch1);
        sb.append('}');
        return sb.toString();
    }
}
