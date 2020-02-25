package offer;

import java.util.Arrays;

/**
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution43 {
    public static void main(String[] args){
        Solution43 o = new Solution43();
        String str = "12345";
        System.out.println(o.myLeftRotateString(str, 7));
    }
    public String myLeftRotateString1(String str,int n) {
        if (str == null || str.length() == 0){
            return "";
        }
        n %= str.length();
        n = n < 0 ? n + str.length() : n;
        return str.substring(n) + str.substring(0, n);
    }
    public String myLeftRotateString(String str,int n) {
        if (str == null || str.length() == 0){
            return "";
        }
        char[] c = str.toCharArray();
        char[] c1 = Arrays.copyOf(c, c.length * 2);
        for (int i = 0; i < c.length; i++){
            c1[i + c.length] = c[i];
        }
        n %= c.length;
        return new String(c1, n < 0 ? n + c.length : n, c.length);
    }
}
