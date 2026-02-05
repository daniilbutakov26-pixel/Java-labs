package Lab7.Ex4;

public class Ex4_ext extends Ex4_super {

    public String str1;

    public Ex4_ext(char ch1, String str1) {
        super(ch1);
        this.str1 = str1;
    }

    public Ex4_ext(Ex4_ext other) {
        super(other);
        this.str1 = other.str1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ex4_ext{");
        sb.append(" ch1=' ").append(ch1).append('\'');
        sb.append(" str1=' ").append(str1).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
