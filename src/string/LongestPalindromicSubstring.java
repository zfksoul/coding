package string;

/**
 * 返回任意最长回文子串
 * input:"babad"
 * output:"bab"
 * note:"aba"也可以
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args){
        String s = "aaaababad";
        LongestPalindromicSubstring o = new LongestPalindromicSubstring();
        System.out.println(o.longestPalindrome(s));
        System.out.println("abcdef".substring(3,5));

    }
    public String longestPalindrome(String s){
        String res = "";
        for (int i = 0; i < s.length(); i++){
            for (int j = i, k = i; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++){
                if (res.length() < k - j + 1) res = s.substring(j, k + 1);
            }
            for (int j = i, k = i + 1; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++){
                if (res.length() < k - j + 1) res = s.substring(j, k + 1);
            }
        }
        return res;
    }
}
