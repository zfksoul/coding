package algorithms.dp;

/**
 * 最长公共子串
 */
public class LongestCommonSubString {
    public static void main(String[] args){
        LongestCommonSubString o = new LongestCommonSubString();
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.print(o.lcst(str1, str2));
    }
    public String lcst(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = 0;
        int col = chs2.length - 1;
        int max = 0;
        int end = 0;
        while (row < chs1.length){
            int i = row;
            int j = col;
            int len = 0;
            while (i < chs1.length && j < chs2.length){
                if (chs1[i] != chs2[j]){
                    len = 0;
                } else {
                    len++;
                }
                if (len > max){
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0){
                col--;
            } else {
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public String myLongestCommonSubString(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int len = 0;
        int row = 0;
        int col = c2.length - 1;
        int x;
        int y;
        int max = Integer.MIN_VALUE;
        int k = str1.length();
        while (row < c1.length){
            x = row;
            y = col;
            while (x < c1.length && y < c2.length){
                if (c1[x] == c2[y]){
                    len++;
                    if (len > max){
                        max = len;
                        k = x + 1;
                    }
                } else {
                    len = 0;
                }
                x++;
                y++;
            }
            if (col > 0){
                col--;
            } else {
                row++;
            }
        }
        return str1.substring(k - max, k);
    }
}
