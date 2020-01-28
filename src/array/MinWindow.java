package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * input:
 * s="ADOBECODEBANC"，T="ABC"
 * output:
 * "BANC"
 */
public class MinWindow {

    public static void main(String[] args){
        MinWindow o = new MinWindow();
        System.out.println(o.myMinWindow("ADOBECODEBANC","ABCD"));
    }
    public int myMinWindow(String s1, String s2){
        if (s1 == null || s2 == null || s1.length() < s2.length()) return 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < c2.length; i++) map[c2[i]]++;
        int match = c2.length;
        int minLen = Integer.MAX_VALUE;
        /*int l = 0;
        int r = 0;
        while (r != c1.length){
            map[c1[r]]--;
            if (map[c1[r]] >= 0) match--;
            if (match == 0){
                while (map[c1[l]] < 0) map[c1[l++]]++;
                minLen = Math.min(minLen, r - l + 1);
                match++;
                map[c1[l++]]++;
            }
            r++;
        }*/
        for (int l = 0, r = 0; r < c1.length; r++){
            map[c1[r]]--;
            if (map[c1[r]] >= 0) match--;
            if (match == 0){
                while (map[c1[l]] < 0) map[c1[l++]]++;
                minLen = Math.min(minLen, r - l + 1);
                map[c1[l++]]++;
                match++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
