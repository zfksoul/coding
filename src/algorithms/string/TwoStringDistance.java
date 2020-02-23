package algorithms.string;

/**
 * 给定2个字符串，以长的字符串长度为准，返回在字典序中，2个字符串之间有多少个字符串
 */
public class TwoStringDistance {
    public static void main(String[] args){
        TwoStringDistance o = new TwoStringDistance();
        String str1 = "abds";
        String str2 = "ac";
        System.out.println(o.getDistance(str1, str2));
    }

    private int getDistance(String str1, String str2) {
        if (str1 == null || str2 == null){
            return -1;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int len = Math.max(c1.length, c2.length);
        int i = pos(c1, len);
        int j = pos(c2, len);
        long a = pos1(c1, len);
        long b = pos1(c2, len);
        return Math.abs(i - j) - 1;
    }
    private long pos1(char[] c, int len) {
        long pre = 0;
        long res = 0;
        for (int i = 0; i < c.length; i++){
            pre = pre * 26 + c[i] - 'a';
            res += pre + 1;
        }
        for (int i = c.length; i < len; i++){
            pre *= 26;
            res += pre;
        }
        return res;
    }
    private int pos(char[] c, int len) {
        int pre = 0;
        int res = 0;
        int index = 0;
        while (index < len){
            if (index < c.length){
                pre = pre * 26 + c[index] - 'a';//分别算不同长度的结果
                res += pre + 1;
            } else {
                pre = pre * 26;
                res += pre;
            }
            index++;
        }
        return res;
    }

}
