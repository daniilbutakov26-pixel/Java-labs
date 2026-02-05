package Lab7.Ex4;

public class Ex4_ext_sub extends Ex4_ext {

    public int num1;

    public Ex4_ext_sub(char ch1, String str1, int num1) {
        super(ch1, str1);
        this.num1 = num1;
    }

    public Ex4_ext_sub(Ex4_ext_sub other) {
        super(other);
        this.num1 = other.num1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ex4_ext_sub{");
        sb.append(" ch1= ").append(ch1);
        sb.append(" str1= ").append(str1);
        sb.append(" num1= ").append(num1);
        sb.append('}');
        return sb.toString();
    }
}
