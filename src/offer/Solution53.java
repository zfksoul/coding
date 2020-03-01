package offer;



/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution53 {
    public boolean myIsNumeric(char[] str) {
        if (str == null || str.length == 0){
            return false;
        }
        boolean point = false;
        boolean exp = false;
        for (int i = 0; i < str.length; i++){
            if (str[i] == '+' || str[i] == '-'){
                //'+''-'后面是数字或'.'
                if (i == str.length - 1 || !((str[i + 1] >= '0' && str[i + 1] <= '9') || str[i + 1] == '.')){
                    return false;
                }
                //'+''-'位于第一个位置或'e''E'后面
                if (!(i == 0 || str[i - 1] == 'e' || str[i - 1] == 'E')){
                    return false;
                }
            } else if (str[i] == '.'){
                //'.'只能有一个，'.'不能在’e''E'后面，'.'后面是数字或在最后
                if (point || exp || !(i == str.length - 1 || (str[i + 1] >= '0' && str[i + 1] <= '9'))){
                    return false;
                }
                point = true;
            } else if (str[i] == 'e' || str[i] == 'E'){
                //'e''E'只有一个，不能在最后，后面是数字或'+''-'
                if (exp || i == str.length - 1 || !((str[i + 1] >= '0' && str[i + 1] <= '9') || str[i + 1] == '+' || str[i + 1] == '-')){
                    return false;
                }
                exp = true;
            } else if (str[i] >= '0' && str[i] <= '9'){

            } else {
                return false;
            }
        }
        return true;
    }
}
