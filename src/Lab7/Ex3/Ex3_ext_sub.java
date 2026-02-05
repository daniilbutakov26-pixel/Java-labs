package Lab7.Ex3;

public class Ex3_ext_sub extends Ex3_ext {

    public String str1;

    public Ex3_ext_sub(int num1, char ch1, String str1) {
        super(num1, ch1);
        this.str1 = str1;
    }

    public void setNum1(int num1, char ch1, String str1) {
        super.setNum1(num1, ch1);
        this.str1 = str1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ex3_ext_sub{");
        sb.append("str1='").append(str1).append('\'');
        sb.append("ch1='").append(ch1).append('\'');
        sb.append("num1='").append(num1).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
