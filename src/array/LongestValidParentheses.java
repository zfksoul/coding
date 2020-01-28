package array;

/**
 * 最长有效括号
 * input:"(()"
 * output:2
 * 括号序列合法，所有前缀和>=0，总和=0
 */
public class LongestValidParentheses {

    public static void main(String[] args){
        LongestValidParentheses o = new LongestValidParentheses();
        System.out.println(o.maxLength("(()()"));
    }
    public int maxLength(String str){
        if (str == null || str.equals("")) return 0;
        char[] c = str.toCharArray();
        int[] dp = new int[c.length];
        int p = 0;
        int res = 0;
        for (int i = 1; i < c.length; i++){
            if (c[i] == ')'){
                p = i - dp[i-1] -1;
                if (p >= 0 && c[p] == '('){
                    dp[i] = dp[i-1] + 2 + (p > 0 ? dp[p-1] : 0);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
