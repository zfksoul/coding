package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不包含重复字符的字符串长度
 * input:"abcabcbb"
 * output:3
 * 双指针，时间复杂度O(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(o.lenthOfLengestSubstring("abcabcbb"));
    }
    public int lenthOfLengestSubstring(String s){
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == null){
                map.put(s.charAt(i),0);
            }
            map.put(s.charAt(i),map.get(s.charAt(i)+1));
            while (map.get(s.charAt(i))>0){
                map.put(s.charAt(j),map.get(s.charAt(j)-1));
                j--;
            }
            res = Math.max(res,i - j + 1);
        }
        return res;
    }
}
