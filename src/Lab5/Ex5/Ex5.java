package Lab5.Ex5;

public class Ex5 {
    private int num1;

    public Ex5(int num1) {
        if (num1 > 100) {
            this.num1 = 100;
        } else {
            this.num1 = num1;
        }
    }

    public Ex5() {
        this.num1 = 0;
    }

    public void setNum1(int num1) {
        if (num1 > 100) {
            this.num1 = 100;
        } else {
            this.num1 = num1;
        }
    }

    public void setNum1() {
        this.num1 = num1;
    }

    public int getNum1(){
        return num1;
    }
}