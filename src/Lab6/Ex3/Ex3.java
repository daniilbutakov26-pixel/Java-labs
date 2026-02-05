package Lab6.Ex3;

public class Ex3 {
    //работает для массивов и нескольких int

    //Находим максимальное
    public static int getMax(int ... nums){
        int max = 0;

        for (int i : nums) {
            if (i > max){
                max = i;
            }
        }

        return max;
    }

    //Находим минимальное
    public static int getMin(int ... nums){
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i < min){
                min = i;
            }
        }

        return min;
    }

    //Находим среднее
    public static int getAverage(int ... nums){
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        return sum / nums.length;
    }


}
