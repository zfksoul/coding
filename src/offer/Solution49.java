package offer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class Solution49 {
    public static void main(String[] args){
        Solution49 o = new Solution49();
        String str = "-2147483649";
        System.out.println(o.myStrToInt(str));
    }
    public int myStrToInt(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        long res = 0;
        boolean flag = true;
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            res = str.charAt(0) - '0';
        } else if (str.charAt(0) == '+'){
            flag = true;
        } else if (str.charAt(0) == '-'){
            flag = false;
        } else {
            return 0;
        }
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9' ){
                res = res * 10 + str.charAt(i) - '0';
            } else {
                return 0;
            }
        }
        res = flag ? res : -res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }
        return (int) res;
    }
}
