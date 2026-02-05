package Lab5.Ex1;

public class Ex1 {
    private char ch1;

    public void setCh1(char ch){
        this.ch1 = ch;
    }

    public int getCode(){
        return(this.ch1);
    }

    public void getInfo(){
        System.out.println(this.ch1 + " код = " + this.getCode());
    }

}

