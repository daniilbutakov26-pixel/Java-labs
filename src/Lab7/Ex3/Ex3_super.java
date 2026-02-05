package Lab7.Ex3;

public class Ex3_super {

    public int num1;

    public Ex3_super(int num1) {
        this.num1 = num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ex3_super{");
        sb.append("num1=").append(num1);
        sb.append('}');
        return sb.toString();
    }
}
