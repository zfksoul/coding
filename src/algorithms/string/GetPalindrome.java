package algorithms.string;

/**
* 给定字符串，可以在字符串任意位置添加字符，返回添加字符最少情况下得到回文串的结果
* 时间复杂度O(n^2)
*/
public class GetPalindrome {
    public static void main(String[] args) {
        GetPalindrome o = new GetPalindrome();
        System.out.print(o.myGetPalindrome("asdfd"));
    }
    //时间复杂度O(n^2)
    public int[][] getDP(char[] c){
        int[][] dp = new int[c.length][c.length];
        for (int j = 1; j < c.length; j++) {
            dp[j - 1][j] = c[j - 1] == c[j] ? 0 : 1;
            for (int i = j - 2; i >= 0; i--) {
                if (c[i] == c[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp;
    }
    public String myGetPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        char[] c = str.toCharArray();
        int[][] dp = getDP(c);
        char[] res = new char[c.length + dp[0][c.length - 1]];
        int i = 0;
        int j = c.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        while (i <= j) {
            if (c[i] == c[j]) {
                res[resl++] = c[i++];
                res[resr--] = c[j--];
            } else if (dp[i][j - 1] < dp[i + 1][j]) {
                res[resl++] = c[j];
                res[resr--] = c[j--];
            } else {
                res[resl++] = c[i];
                res[resr--] = c[i++];
            }
        }
        return String.valueOf(res);
    }
}
