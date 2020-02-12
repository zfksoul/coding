package algorithms.string;

import java.util.HashMap;

/**
 * 最小包含子串
 * input: str1="abcde" str2="ac"
 * output: 3
 */
public class MinContainString {
    public static void main(String[] args){
        MinContainString o = new MinContainString();
        String str1 = "abcde";
        String str2 = "ac";
        System.out.println(o.minLength(str1, str2));
    }

    private int minLength(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()){
            return 0;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < c2.length; i++){
            map[c2[i]]++;
        }//其他字符欠款为0，只有c2里的字符欠款大于0，所以l右滑还款时，其他字符不会大于0，只有c2里的字符会大于0，用于判断是否再次欠款
        int i = 0;
        int j = 0;
        int t = c2.length;
        int len = Integer.MAX_VALUE;
        while (j < c1.length){
            map[c1[j]]--;
            if (map[c1[j]] >= 0){
                t--;
            }
            if (t == 0){
                while (map[c1[i]] < 0){
                    map[c1[i++]]++;
                }
                len = Math.min(len, j - i + 1);
                t++;
                map[c1[i++]]++;
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
