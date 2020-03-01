package algorithms.string;

import java.util.Arrays;

/**
 * 字符串匹配问题
 */
public class MatchString1 {
    public static void main(String[] args) {
        MatchString1 o = new MatchString1();
        //char[] str = {'a','b','c','c','c'};
        //char[] match = {'a','.','c','*'};
        String str = "bcbbabab";
        String match = ".*a*a";
        System.out.println(o.match(str.toCharArray(), match.toCharArray()));
    }
    public boolean match(char[] str, char[] match){
        if (!isValid(str, match)){
            return false;
        }
        return processDP(str, match, 0, 0);
    }
    public boolean processDP(char[] str, char[] match, int s, int m){
        boolean[][] dp = new boolean[str.length + 1][match.length + 1];
        dp[str.length][match.length] = true;
        for (int j = match.length - 2; j >= 0; j -= 2){
            if (match[j] != '*' && match[j + 1] == '*'){
                dp[str.length][j] = true;
            } else {
                break;
            }
        }
        if (str.length > 0 && match.length > 0){
            if (str[str.length - 1] == match[match.length - 1] || match[match.length - 1] == '.'){
                dp[str.length - 1][match.length - 1] = true;
            }
        }
        for (int i = str.length - 1; i >= 0; i--){
            for (int j = match.length - 2; j >= 0; j--){
                if (match[j + 1] != '*'){
                    if (str[i] == match[j] || match[j] == '.'){
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                } else {
                    int k = i;
                    while (k < str.length && (str[k] == match[j] || match[j] == '.')){
                        if (dp[k][j + 2]){
                            dp[i][j] = true;
                            break;
                        }
                        k++;
                    }
                    if (dp[i][j] == false){
                        dp[i][j] = dp[k][j + 2];
                    }
                }
            }
        }
        return dp[0][0];
    }
    public boolean process(char[] str, char[] match, int s, int m){
        if (m == match.length){
            return s == str.length;
        }
        if (m == match.length - 1 || match[m + 1] != '*'){
            if (s != str.length && (str[s] == match[m] || match[m] == '.')){
                return process(str, match, s + 1, m + 1);
            }
            return false;
        }
        while (s < str.length && (match[m] == str[s] || match[m] == '.')){
            if (process(str, match, s, m + 2)){
                return true;
            }
            s++;
        }
        return process(str, match, s, m + 2);
    }

    public boolean isValid(char[] str, char[] match) {
        if (str == null || match == null){
            return false;
        }
        for (int i = 0; i < str.length; i++){
            if (str[i] == '.' || str[i] == '*'){
                return false;
            }
        }

        for (int i = 0; i < match.length; i++){
            if (i == 0 && match[0] == '*'){
                return false;
            }
            if (match[i] == '*' && match[i - 1] == '*'){
                return false;
            }
        }
        return true;
    }


}