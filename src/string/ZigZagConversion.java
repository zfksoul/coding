package string;

/**
 * 行数等于3，将字符串"abcdefghijklmnopqr"按N字形排列
 * 0    8       16
 * 1   7 9     15 17
 * 2  6  10   14   18
 * 3 5    11 13     19
 * 4       12        20
 * 第一行：首项是0，公差是2(n-1)的等差数列
 * 中间：两个等差数列交错
 * 最后一行：首项是n-1，公差是2(n-1)的等差数列
 * a  e   i   m   q
 * b d f h j l n p r
 * c    g   k   o
 */
public class ZigZagConversion {
    public static void main(String[] args){
        ZigZagConversion o = new ZigZagConversion();
        System.out.println(o.convert("abcdefghijklmnopqr",3));
        System.out.println(o.convert1("abcdefghijklmnopqr",3));
    }

    public String convert(String s, int n){
        if (n == 1) return s;
        StringBuilder res = new StringBuilder();
        int gap = 2 * (n - 1);
        for (int i = 0; i < n; i++){
            if (i == 0 || i == n - 1){
                for (int j = i; j < s.length(); j += gap) {//如果n==1,这里会死循环
                    res.append(s.charAt(j));
                }
            } else {
                for (int j = i, k = gap - i; j < s.length() || k < s.length(); j += gap, k += gap){
                    if (j < s.length()) res.append(s.charAt(j));
                    if (k < s.length()) res.append(s.charAt(k));
                }
            }
        }
        return res.toString();
    }
    public String convert1(String s, int n){
        if (s.length() == 1) return s;
        int gap = 2 * (n - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (i == 0 || i == n - 1){
                for (int j = i; j < s.length(); j += gap){
                    res.append(s.charAt(j));
                }
            } else {
                for (int j = i, k = n - i; j < s.length() || k < s.length(); j += gap, k += gap){
                    if (j < s.length()) res.append(s.charAt(j));
                    if (k < s.length()) res.append(s.charAt(k));
                }
            }
        }
        return res.toString();
    }
}
