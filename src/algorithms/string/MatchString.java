package algorithms.string;

import java.util.Arrays;

/**
 * 字符串匹配问题
 */
public class MatchString {
    public static void main(String[] args){
        MatchString o = new MatchString();
        System.out.println(o.isMatch1("abcd", ".*"));
        System.out.println(o.isMatchDP("abcd", ".*"));
    }

    public boolean isMatchDP(String str, String exp){
        if(str == null || exp == null){
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        if (!isValid(s, e)){
            return false;
        }
        boolean[][] dp = initDPMap(s, e);
        for (int i = s.length - 1; i >= 0; i--){
            for (int j = e.length - 2; j >= 0; j--){
                if (e[j + 1] != '*'){
                    dp[i][j] = (s[i] == e[j] || e[j] == '.') && dp[i + 1][j + 1];
                } else {
                    int si = i;
                    while (si != s.length && (s[si] == e[j] || e[j] == '.')){
                        if (dp[si][j + 2]){
                            dp[i][j] = true;
                            break;
                        }
                        si++;
                    }
                    if (dp[i][j] != true){
                        dp[i][j] = dp[si][j + 2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    private boolean[][] initDPMap(char[] s, char[] e) {
        int slen = s.length;
        int elen = e.length;
        boolean[][] dp = new boolean[slen + 1][elen + 1];
        dp[slen][elen] = true;
        for (int j = elen - 2; j >= 0; j-= 2){
            if (e[j] != '*' && e[j + 1] == '*'){
                dp[slen][j] = true;
            } else {
                break;
            }
        }
        if (slen > 0 && elen > 0){
            if (e[elen - 1] == '.' || s[slen - 1] == e[elen - 1]){
                dp[slen - 1][elen - 1] = true;
            }
        }
        return dp;
    }

    public boolean isMatch1(String str, String exp) {
        if (str == null || exp == null){
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        if (!isValid(s, e)){
            return false;
        }
        boolean[][] dp = new boolean[s.length + 1][e.length + 1];
        dp[s.length][e.length] = true;
        for (int j = dp[0].length - 3; j >= 0; j -= 2){
            if (e[j] != '*' && e[j + 1] == '*'){
                dp[s.length][j] = true;
            } else {
                break;
            }
        }
        if (s.length > 0 && e.length > 0){
            if (s[s.length - 1] == e[e.length - 1] || e[e.length - 1] == '.'){
                dp[dp.length - 2][dp.length - 2] = true;
            }
        }
        for (int i = dp.length - 2; i >= 0; i--){
            for (int j = dp[0].length - 3; j >= 0; j--){
                if (e[j + 1] != '*'){
                    if (e[j] == s[i] || e[j] == '.'){
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    int k = i;
                    while (k < dp.length - 1 && (s[k] == e[j] || e[j] == '.')){
                        if (dp[k][j + 2]){
                            dp[i][j] = true;
                            break;
                        }
                        k++;
                    }
                    if (!dp[i][j]){
                        dp[i][j] = dp[k][j + 2];
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][0];
    }
    public boolean isMatch(String str, String exp) {
        if (str == null || exp == null){
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        if (!isValid(s, e)){
            return false;
        }
        return process(s, e, 0, 0);
    }

    public boolean process(char[] s, char[] e, int si, int ei) {
        if (ei == e.length){
            return si == s.length;
        }
        if (ei + 1 == e.length || e[ei + 1] != '*'){
            if (si != s.length && (s[si] == e[ei] || e[ei] == '.')){
                return process(s, e, si + 1, ei + 1);
            } else {
                return false;
            }
        }
        while (si != s.length && (s[si] == e[ei] || e[ei] == '.')){
            if (process(s, e, si, ei + 2)){
                return true;
            }
            si++;
        }
        return process(s, e, si, ei + 2);
    }

    public boolean isValid(char[] s, char[] e){
        for (int i = 0; i < s.length; i++){
            if (s[i] == '.' || s[i] == '*'){
                return false;
            }
        }
        for (int i = 0; i < e.length; i++){
            if (i == 0 && e[i] == '*'){
                return false;
            }
            if (e[i] == '*' && e[i - 1] == '*'){
                return false;
            }
        }
        return true;
    }
}
