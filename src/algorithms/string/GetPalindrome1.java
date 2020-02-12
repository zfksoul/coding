package algorithms.string;

/**
 * 给定字符串str和它的最长回文子串strlps，返回添加最少字符串使str成为回文串的一种结果
 * input: str="A1B21C", strlps="121"
 * output: "AC1B2B1CA"或"CA1B2B1AC"
 */
public class GetPalindrome1 {
    public static void main(String[] args){
        GetPalindrome1 o = new GetPalindrome1();
        String str = "A1B21C";
        String strlps = "121";
        System.out.print(o.myGetPalindrome1(str,strlps));
    }

    public String myGetPalindrome1(String str, String strlps){
        if (str == null || str.equals("")){
            return "";
        }
        char[] chas = str.toCharArray();
        char[] lps = strlps.toCharArray();
        char[] res = new char[2 * chas.length - lps.length];
        int chasl = 0;
        int chasr = chas.length - 1;
        int lpsl = 0;
        int lpsr = lps.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        int tmpl = 0;
        int tmpr = 0;
        while (lpsl <= lpsr){
            tmpl = chasl;
            tmpr = chasr;
            while (chas[chasl] != lps[lpsl]){
                chasl++;
            }
            while (chas[chasr] != lps[lpsr]){
                chasr--;
            }
            set(res, resl, resr, chas, chasl, chasr, tmpl, tmpr);
            resl += chasl - tmpl + tmpr - chasr;
            resr -= chasl - tmpl + tmpr - chasr;
            res[resl++] = chas[chasl++];
            res[resr--] = chas[chasr--];
            lpsl++;
            lpsr--;
        }
        return String.valueOf(res);
    }

    private void set(char[] res, int resl, int resr,
                     char[] chas, int chasl, int chasr, int tmpl, int tmpr) {
        for (int i = tmpl; i < chasl; i++){
            res[resl++] = chas[i];
            res[resr--] = chas[i];
        }
        for (int i = tmpr; i > chasr; i--){
            res[resl++] = chas[i];
            res[resr--] = chas[i];
        }
    }
}
