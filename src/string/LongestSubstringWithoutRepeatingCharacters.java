package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不包含重复字符的字符串长度
 * input:"abcabcbb"
 * output:3
 * 双指针，单调性，时间复杂度O(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(o.lenthOfLongestSubstring("abcabcbb"));
        System.out.println(o.lenthOfLongestSubstring1("abcabcbb"));
        System.out.println(o.lenthOfLongestSubstring2("abcabcbb"));
    }
    public int lenthOfLongestSubstring(String s){
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        char ci;
        char cj;
        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.get(ci = s.charAt(i)) == null){
                map.put(ci,0);
            }
            map.put(ci,map.get(ci)+1);//i向前移动加入新元素
            while (map.get(ci)>1){//只可能ci重复
                map.put(cj = s.charAt(j++),map.get(cj)-1);//j前移直到不存在重复元素
            }
            res = Math.max(res,i - j + 1);
        }
        return res;
    }
    public int lenthOfLongestSubstring1(String s){
        char[] c = s.toCharArray();
        int[] map = new int[26];
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            map[c[i]-'a']++;
            while (map[c[i]-'a']>1){
                map[c[j++]-'a']--;
            }
            res = Math.max(res,i-j+1);
        }
        return res;
    }
    public int lenthOfLongestSubstring2(String s){
        int[] map = new int[26];
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a']++;
            while(map[s.charAt(i) - 'a'] > 1){
                map[s.charAt(j++) - 'a']--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
