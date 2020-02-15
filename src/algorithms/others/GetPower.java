package algorithms.others;

/**
 * 给定double类型浮点数base和int类型整数exp，求base的exp次方
 */
public class GetPower {
    public static void main(String[] args){
        GetPower o = new GetPower();
        System.out.println(o.Power(2.0, -3));
    }
    public double Power(double base, int exponent) {
        double res = 1;
        boolean flag = exponent > 0 ? true : false;
        exponent = Math.abs(exponent);
        while (exponent > 0){
            if ((exponent & 1) != 0){
                res *= base;
            }
            base *= base;
            exponent /= 2;
        }
/*
        for (; exponent != 0; exponent >>= 1){
            if ((exponent & 1) != 0){
                res *= base;
            }
            base *= base;
        }
*/
        return flag ? res : 1.0 / res;
    }
}
