package algorithms.others;

import java.util.Arrays;

/**
 * 给定2个字符串str和match，长度为n和m，如果str中有match，返回match在str中的开始位置，没有返回-1
 * 时间复杂度O(n)
 * 求next数组时间复杂度O(m)
 */
public class KMP {
    public static void main(String[] args){
        KMP o = new KMP();
        String str = "accbc";
        String match = "bc";
        System.out.print(o.getIndexOf(str, match));
    }
    public int getIndexOf(String s, String m){
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()){
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int[] next = getNextArray(match);
        int i = 0;
        int k = 0;
        while (i < str.length && k < match.length){
            if (str[i] == match[k]){
                i++;
                k++;
            } else if (k == 0){
                i++;
            } else {
                k = next[k];
            }
        }
        return k == match.length ? i - k : -1;
    }
    public int getIndexOf1(String s, String m){
        char[] match = m.toCharArray();
        int[] next = getNextArray(match);
        char[] str = s.toCharArray();
        int res = -1;
        int k = 0;
        for (int i = 0; i < s.length(); i++){
            while (k >= 0 && str[i] != match[k]){
                k = next[k];
            }
            if (k < 0 || str[i] == match[k]){
                k++;
            }
            if (k == next.length){
                res = i + 1 - next.length;
                break;
            }
        }
        return res;

    }

    /**
     * i:[0~m]
     * i-cn:[0~m]
     * i++,cn++:i增加，i-cn不变
     * cn减小:i不变，i-cn增加
     * i++:i增加，i-cn增加
     */
    public int[] getNextArray(char[] match){
        if (match.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length){
            if (match[i - 1] == match[cn]){
                next[i++] = ++cn;
            } else if(cn > 0){
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        //优化
        int[] nextval = new int[match.length];
        nextval[0] = 0;
        for (int j = 1; j < match.length; j++){
            if (match[j] == match[next[j]]){
                nextval[j] = nextval[next[j]];
            } else {
                nextval[j] = next[j];
            }
        }
        return nextval;
    }

    public int[] getNextArray1(char[] match){
        if (match == null || match.length == 0) return null;
        if (match.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        for (int i = 2; i < match.length; i++){
            int t = i - 1;
            boolean flag = false;
            while (t > 0){
                if (match[i - 1] == match[next[t]]){
                    next[i] = next[t] + 1;
                    flag = true;
                    break;
                } else {
                    t = next[t];
                }
            }
            if (!flag){
                next[i] = 0;
            }
        }
        return next;
    }
}
