package algorithms.string;

/**
 * input: str="ABC", num=72
 * output: BABC  (2123)
 */
public class NumberToString {
    public static void main(String[] args){
        NumberToString o = new NumberToString();
        String str = "ABC";
        int num = 72;
        System.out.println(o.getString(str, num));
        System.out.println(o.getString1(str, num));
    }
    public String getString1(String str, int num) {
        if (str == null || str.length() == 0 || num < 1){
            return "";
        }
        int cur = 1;
        char[] c = str.toCharArray();
        int base = c.length;
        int len = 0;
        while (num >= cur){
            len++;
            num -= cur;
            cur *= base;
        }
        char[] res = new char[len];
        int index = 0;
        int nCur = 0;
        do {
            cur /= base;
            nCur = num / cur;
            res[index++] = getKthChar(c, nCur + 1);
            num %= cur;
        } while (index != res.length);
        return String.valueOf(res);
    }

    private char getKthChar(char[] c, int k) {
        if (k < 1 || k > c.length){
            return 0;
        }
        return c[k - 1];
    }

    public String getString(String str, int num) {
        if (str == null || str.equals("") || num < 1){
            return "";
        }
        char[] c = str.toCharArray();
        int base = c.length;
        int n = 1;
        int k = 0;
        while (num >= n){
            num -= n;
            n = n * base;
            k++;
        }
        int[] cnt = new int[k];
        char[] res = new char[k];
        n /= base;
        for (int i = 0; i < cnt.length; i++){
            cnt[i]++;
            while (num >= n){
                num -= n;
                cnt[i]++;
            }
            if (n == 1){
                break;
            }
            n /= base;
        }
        for (int i = 0; i < cnt.length; i++){
            res[i] = str.charAt(cnt[i] - 1);
        }
        return String.valueOf(res);

    }
}
