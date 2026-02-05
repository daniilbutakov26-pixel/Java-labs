package Lab5.Ex2;

public class Ex2 {
    private char ch1, ch2;

    public Ex2(char ch1, char ch2){
        this.ch1 = ch1;
        this.ch2 = ch2;
    }

    public Ex2(){
        this.ch1 = 'A';
        this.ch2 = 'B';
    }

    public String getline(){
        String temp = "";
        for (char i = this.ch1; i < this.ch2; i++){
            temp += i + " ";
        }
        return temp;
    }

}
