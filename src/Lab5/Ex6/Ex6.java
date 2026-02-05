package Lab5.Ex6;

public class Ex6 {
    int max, min;

    public Ex6(int min_, int max_) {
        if (min_ > max_) throw new IllegalArgumentException("min не должно превышать max");
        this.min = min_;
        this.max = max_;
    }

    public Ex6 (int num1){
        if (num1 > this.min){
            this.max = num1;
        } else {
            this.min = num1;
        }
    }

    public void setMinMax(int min_, int max_){
        if (min_ > max_) {
            System.out.println("min не должно превышать max");
            return;
        } else {
            if (min_ < this.min) {
                this.min = min_;
            }
            if (this.max < max_) {
                this.max = max_;
            }
        }
    }

    public void setMinMax(int num1){
        if (num1 < this.min){
            this.min = num1;
        }
        if (this.max < num1){
            this.max = num1;
        }
    }

    public void getMinMax(){
        System.out.println(min + " " + max);
    }
}
