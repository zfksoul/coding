package algorithms.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args){
        LongestCommonSubsequence o = new LongestCommonSubsequence();
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        System.out.print(o.myLongestCommonSubsequence(str1, str2));
    }
    public String lcse(String str1, String str2){
        if (str1 == null || str1.equals("") || str2 == null || str2.equals("")){
            return "";
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[][] dp = getdp(c1, c2);
        int m = c1.length - 1;
        int n = c2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0){
            if (n > 0 && dp[m][n] == dp[m][n - 1]){
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]){
                m--;
            } else {
                res[index--] = c1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }


    public int[][] getdp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int j = 1; j < str2.length; j++){
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++){
            for (int j = 1; j < str2.length; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }
    private String myLongestCommonSubsequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0){
            return "";
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[][] dp = new int[c1.length][c2.length];
        dp[0][0] = c1[0] == c2[0] ? 1 : 0;
        for (int i = 1; i < c2.length; i++){
            if (c1[0] == c2[i]){
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < c1.length; i++){
            dp[i][0] = c2[0] == c1[i] ? 1 : dp[i - 1][0];
            for (int j = 1; j < c2.length; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (c1[i] == c2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return getSequence(c1, c2, dp);
    }

    private String getSequence(char[] c1, char[] c2, int[][] dp) {
        int i = c1.length - 1, j = c2.length - 1;
        char[] res = new char[dp[i][j]];
        int k = dp[i][j] - 1;
        while ( i >= 0 && j >= 0){
            if (j > 0 && dp[i][j] == dp[i][j - 1]){
                j--;
            } else if (i > 0 && dp[i][j] == dp[i - 1][j]){
                i--;
            } else {
                res[k--] = c1[i--];
                j--;
            }
        }
        return String.valueOf(res);
    }
}
