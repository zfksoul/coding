package algorithms;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月18日 下午8:29:28
 * 
 */
public class Solution12 {

    public static void main(String[] args) {
        Solution12 so = new Solution12();
        System.out.println(so.Power(2.2, -3));
    }

    public double Power(double base, int exponent) {
        boolean flag = false;
        if (exponent < 0) {
            exponent = -exponent;
            flag = true;
        }
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else {
            double result = Power(base, exponent >> 1);
            result *= result;
            if ((exponent & 1) == 1) {
                result *= base;
            }
            if (flag) {
                return 1 / result;
            } else {
                return result;
            }
        }
    }
}
