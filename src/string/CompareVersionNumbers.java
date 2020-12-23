package string;

/**
 * 比较版本号，大于返回1，小于返回-1，等于返回0
 * 0.1 < 1.1
 * 1.0.1 > 1.0.0
 * 7.5.2.4 < 7.5.3
 * 1.01 = 1.001
 * 1.0 = 1.0.0
 */
public class CompareVersionNumbers {
    public static void main(String[] args){
        CompareVersionNumbers o = new CompareVersionNumbers();
        System.out.println(o.myCompareVersion("1.0","1.0.1"));
        System.out.println(o.myCompareVersion1("1.0","1.0.1"));
    }
    public int myCompareVersion(String s1, String s2){
        int i = 0;//每一节开头
        int j = 0;//每一节开头
        while (i < s1.length() || j < s2.length()){
            int x = i, y = j;
            while (x < s1.length() && s1.charAt(x) != '.') x++;
            while (y < s2.length() && s2.charAt(y) != '.') y++;
            int a = (i == x) ? 0 : count(s1.substring(i,x));//如果i==x，x没移动，x越界，默认0
            int b = (j == y) ? 0 : count(s2.substring(j,y));//如果j==y，y没移动，y越界，默认0
            if (a > b) return 1;
            if (a < b) return -1;
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }

    private int count(String str) {
        int res = 0;
        int i = 0;
        while (i < str.length()){
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        return res;
    }
    public int myCompareVersion1(String s1, String s2){
        int i = 0;
        int j = 0;
        while (i < s1.length() || j < s2.length()){
            int x = i;
            int y = j;
            while (x < s1.length() && '.' != s1.charAt(x)) x++;
            while (y < s2.length() && '.' != s2.charAt(y)) y++;
            int a = (x == i) ? 0 : count(s1.substring(i, x));
            int b = (y == j) ? 0 : count(s2.substring(j, y));
            if (a > b) return 1;
            if (a < b) return -1;
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }
}
