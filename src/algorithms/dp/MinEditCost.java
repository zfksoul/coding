package algorithms.dp;

import java.util.Arrays;

/**
 * 最小编辑代价
 * 插入代价ic
 * 删除代价dc
 * 替换代价rc
 * input: str1="abc",str2="adc",ic=5,dc=3,rc=2
 * output:2
 */
public class MinEditCost {

    public static void main(String[] args){
        MinEditCost o = new MinEditCost();
        String str1 = "ab22asd";
        String str2 = "ab12cd3sasad";
        System.out.println(o.myMinEditCost(str1, str2, 5, 3, 2));
        System.out.println(o.minCost1(str1, str2, 5, 3, 2));
        System.out.println(o.myMinEditCost1(str1, str2, 5, 3, 2));
        System.out.println(o.minCost2(str1, str2, 5, 3, 2));
    }

    public int minCost2(String str1, String str2, int ic, int dc, int rc){
        if (str1 == null || str2 == null){
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] longs = chs1.length >= chs2.length ? chs1 : chs2;
        char[] shorts = chs1.length < chs2.length ? chs1 : chs2;
        if (chs1.length < chs2.length){
            int tmp = ic;
            ic = dc;
            dc = tmp;
        }
        int[] dp = new int[shorts.length + 1];
        for (int i = 1; i <= shorts.length; i++){
            dp[i] = ic * i;
        }
        for (int i = 1; i <= longs.length; i++){
            int p = dp[0];
            dp[0] = dc * i;
            for (int j = 1; j <= shorts.length; j++){
                int tmp = dp[j];
                if (longs[i - 1] == shorts[j - 1]){
                    dp[j] = p;
                } else {
                    dp[j] = p + rc;
                }
                dp[j] = Math.min(dp[j], dp[j - 1] + ic);
                dp[j] = Math.min(dp[j], tmp + dc);
                p = tmp;
            }
        }
        return dp[shorts.length];
    }

    public int myMinEditCost(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null){
            return 0;
        }
        boolean rowmore = str1.length() >= str2.length() ? true : false;
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int less = Math.min(str1.length(), str2.length());
        int more = Math.max(str1.length(), str2.length());
        int[] dp = new int[less + 1];
        int tmp;
        int p;
        for (int j = 0; j <= less; j++){
            dp[j] = rowmore ? j * ic : j * dc;
        }
        for (int i = 0; i < more; i++){
            p = dp[0];
            dp[0] = rowmore ? dp[0] + dc : dp[0] + ic;
            for (int j = 0; j < less; j++){
                if (rowmore){
                    if (c1[i] == c2[j]){
                        tmp = dp[j + 1];
                        dp[j + 1] = Math.min(Math.min(p, dp[j+1] + dc),dp[j] + ic);
                        p = tmp;
                    } else {
                        tmp = dp[j + 1];
                        dp[j + 1] = Math.min(Math.min(p + rc, dp[j+1] + dc),dp[j] + ic);
                        p = tmp;
                    }
                } else {
                    if (c1[j] == c2[i]){
                        tmp = dp[j + 1];
                        dp[j + 1] = Math.min(Math.min(p, dp[j+1] + ic),dp[j] + dc);
                        p = tmp;
                    } else {
                        tmp = dp[j + 1];
                        dp[j + 1] = Math.min(Math.min(p + rc, dp[j+1] + ic),dp[j] + dc);
                        p = tmp;
                    }
                }

            }
        }
        return dp[less];
    }

    public int myMinEditCost1(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null){
            return 0;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int tmp;
        int p;
        int[] dp = new int[c2.length + 1];
        for (int j = 0; j <= c2.length; j++){
            dp[j] = j * ic;
        }
        for (int i = 0; i < c1.length; i++){
            p = dp[0];
            dp[0] = p + dc;
            for (int j = 0; j < c2.length; j++){
                if (c1[i] == c2[j]){
                    tmp = dp[j + 1];
                    //dp[j + 1] = p;
                    dp[j + 1] = Math.min(Math.min(dp[j] + ic, dp[j + 1] + dc), p);
                    p = tmp;
                } else {
                    tmp = dp[j + 1];
                    dp[j + 1] = Math.min(Math.min(dp[j] + ic, dp[j + 1] + dc), p + rc);
                    p = tmp;
                }
            }
        }
        return dp[c2.length];
    }

    public int minCost1(String str1, String str2, int ic, int dc, int rc){
        if (str1 == null || str2 == null){
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length + 1;
        int col = chs2.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++){
            dp[i][0] = dc * i;
        }
        for (int j = 1; j < col; j++){
            dp[0][j] = ic * j;
        }
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                if (chs1[i - 1] == chs2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[row - 1][col - 1];
    }
}
