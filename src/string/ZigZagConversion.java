package string;

/**
 * 行数等于3，将字符串"abcdefghijklmnopqr"按N字形排列
 * a   e   i   m   q
 * b d f h j l n p r
 * c   g   k   o
 * 第一行：首项是0，公差是2(n-1)的等差数列
 * 中间：两个等差数列交错
 * 最后一行：首项是n-1，公差是2(n-1)的等差数列
 */
public class ZigZagConversion {
    public static void main(String[] args){
        ZigZagConversion o = new ZigZagConversion();
        System.out.print(o.convert("abcdefghijklmnopqr",3));
    }

    public String convert(String s, int n){
        if (n == 1) return s;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (i == 0 || i == n - 1){
                for (int j = i; j < s.length(); j += 2 * (n - 1)) res.append(s.charAt(j));
            } else {
                for (int j = i, k = 2 * (n - 1) - i; j < s.length() || k < s.length(); j += 2 * (n - 1), k += 2 * (n - 1)){
                    if (j < s.length()) res.append(s.charAt(j));
                    if (k < s.length()) res.append(s.charAt(k));
                }
            }
        }
        return res.toString();
    }
}
