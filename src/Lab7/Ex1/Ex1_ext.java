package Lab7.Ex1;

public class Ex1_ext extends Ex1_super {

    private String strExt1;
    private String strExt2;

    public Ex1_ext(String str1) {
        super(str1);
        this.strExt1 = str1;
    }

    public Ex1_ext(String str1, String str2) {
        super(str1);
        this.strExt1 = str1;
        this.strExt2 = str2;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ex1_ext{");
        sb.append("strExt1='").append(strExt1).append('\'');
        sb.append(", strExt2='").append(strExt2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
