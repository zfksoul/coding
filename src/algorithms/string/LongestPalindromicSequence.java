package algorithms.string;

import java.util.Scanner;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 */
public class LongestPalindromicSequence {
    public static void main(String[] args){
        LongestPalindromicSequence o = new LongestPalindromicSequence();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            System.out.println(s.length() - o.LPSDP(s.toCharArray()));
        }
        //System.out.println(o.LPS(s.toCharArray()));

    }
    public int LPSDP(char[] c){
        if (c == null || c.length == 0){
            return 0;
        }
        int[][] dp = new int[c.length][c.length];
        for (int i = 0; i < c.length; i++){
            dp[i][i] = 1;
        }
        for (int i = dp.length - 1; i >= 0; i--){
            for (int j = i + 1; j < dp[0].length; j++){
                if (c[i] == c[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][c.length - 1];
    }
    public int LPS(char[] c){
        if (c == null || c.length == 0){
            return 0;
        }
        return fun(c, 0, c.length - 1);
    }

    public int fun(char[] c, int l, int r) {
        if (l > r){
            return 0;
        }
        if (l == r){
            return 1;
        }
        if (c[l] == c[r]){
            return fun(c, l + 1, r - 1) + 2;
        } else {
            return Math.max(fun(c, l + 1, r), fun(c, l, r - 1));
        }

    }
}
