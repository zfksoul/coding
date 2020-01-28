package offer;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月10日 下午11:29:40
 * 
 */
public class Solution2 {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("  ");
        Solution2 so = new Solution2();
        System.out.println(so.replaceSpace(str));
    }

    public String replaceSpace(StringBuffer str) {

        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newlen = len + count * 2;
        char[] c = new char[newlen];
        for (int i = len - 1, j = newlen - 1; i >= 0 && j >= 0; i--) {
            if (str.charAt(i) == ' ') {
                c[j--] = '0';
                c[j--] = '2';
                c[j--] = '%';
            } else {
                c[j] = str.charAt(i);
                j--;
            }
        }

        return String.valueOf(c);
    }
}
