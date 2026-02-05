package Lab7.Ex1;

public class Ex1_super {

    private String str;

    public Ex1_super(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ex1_Super{");
        sb.append("str='").append(str).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
