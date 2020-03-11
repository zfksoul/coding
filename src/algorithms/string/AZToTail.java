package algorithms.string;

import java.util.Scanner;

/**
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 对于每组数据，输出移位后的字符串。
 */
public class AZToTail {
    public static void main(String[] args){
        AZToTail o = new AZToTail();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            StringBuilder s = new StringBuilder(in.nextLine());
            System.out.println(o.fun(s));
        }
    }

    public String fun(StringBuilder s) {
        if (s == null || s.length() == 0){
            return "";
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < s.length() - i - 1; j++){
                if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z' && s.charAt(j + 1) >= 'a' && s.charAt(j + 1) <= 'z'){
                    char tmp = s.charAt(j + 1);
                    s.setCharAt(j + 1, s.charAt(j));
                    s.setCharAt(j, tmp);
                }
            }
        }
        return s.toString();
    }


}
