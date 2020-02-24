package offer;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Solution34 {
    public char myfirstOnce(String str){
        if (str == null || str.equals("")){
            return 0;
        }
        char[] c = str.toCharArray();
        int[] map = new int[256];
        //防止溢出
        for (int i = 0; i < c.length; i++){
            map[c[i]] = map[c[i]] == 0 ? 1 : -1;
        }
        for (int i = 0; i < c.length; i++){
            if (map[c[i]] == 1){
                return c[i];
            }
        }
        return 0;
    }

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++){
            map[str.charAt(i)] = map[str.charAt(i)] == 0 ? 1 : -1;
        }
        for (int i = 0; i < str.length(); i++){
            if (map[str.charAt(i)] == 1) return i;
        }
        return -1;
    }
}
