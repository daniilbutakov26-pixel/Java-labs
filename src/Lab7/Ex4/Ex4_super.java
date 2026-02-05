package Lab7.Ex4;

public class Ex4_super {

    public char ch1;

    public Ex4_super(char ch1) {
        this.ch1 = ch1;
    }

    public Ex4_super(Ex4_super other) {
        this.ch1 = other.ch1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ex4_super{");
        sb.append(" ch1= ").append(ch1);
        sb.append('}');
        return sb.toString();
    }
}
