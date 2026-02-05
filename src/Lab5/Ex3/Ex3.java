package Lab5.Ex3;

public class Ex3 {

    public int num1,num2;

    public Ex3(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public Ex3(int num1){
        this.num1 = num1;
    }

    public Ex3(){

    }

    public String getAll(){
        return (num1 +" "+ num2);
    }

}
