package algorithms.dp;

/**
 * 给定2个字符串str1和str2，判断字符串aim是否由这2个字符串交错组成
 */
public class StringCross {

    public static void main(String[] args){
        StringCross o = new StringCross();
        String str1 = "AB";
        String str2 = "123";
        String aim = "A12B2";
        System.out.print(o.isCross(str1, str2, aim));
    }
    public boolean isCross1(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null){
            return false;
        }
        if (str1.length() + str2.length() != aim.length()){
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        char[] longs = ch1.length >= ch2.length ? ch1 : ch2;
        char[] shorts = ch1.length < ch2.length ? ch1 : ch2;
        boolean[] dp = new boolean[shorts.length + 1];
        dp[0] = true;
        for (int i = 1; i <= shorts.length; i++){
            if (shorts[i - 1] != chaim[i - 1]){
                break;
            }
            dp[i] = true;
        }
        for (int i = 1; i <= longs.length; i++){
            dp[0] = dp[0] && longs[i - 1] == chaim[i - 1];
            for (int j = 1; j <= shorts.length; j++){
                if (longs[i - 1] == chaim[i + j - 1] && dp[j]
                        || (shorts[j - 1] == chaim[i + j - 1] && dp[j - 1])){
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }
        return dp[shorts.length];
    }
    public boolean isCross(String str1, String str2, String m) {
        if (str1 == null || str2 == null || m == null){
            return false;
        }
        if (str1.length() + str2.length() != m.length()){
            return false;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        char[] aim = m.toCharArray();
        char[] shorts = str1.length() < str2.length() ? c1 : c2;
        char[] longs = str1.length() < str2.length() ? c2 : c1;
        boolean[] dp = new boolean[shorts.length + 1];
        dp[0] = true;
        for (int j = 0; j < shorts.length; j++){
            dp[j + 1] = aim[j] == shorts[j] ? dp[j] : false;
        }
        for (int i = 0; i < longs.length; i++){
            dp[0] = aim[i] == longs[i] ? dp[0] : false;
            for (int j = 0; j < shorts.length; j++){
                if (shorts[j] == aim[i + j + 1]){
                    dp[j + 1] = dp[j];
                } else if (longs[i] == aim[i + j + 1]){
                    dp[j + 1] = dp[j + 1];
                } else {
                    dp[j + 1] = false;
                }
            }
        }
        return dp[shorts.length];
    }
}
