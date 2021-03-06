package string;

/**
 * input:"the sky is blue"
 * output:"blue is sky the"
 */
public class ReverseWords {

    public static void main(String[] args){
        StringBuilder s = new StringBuilder("  the sky   is blue ");
        ReverseWords o = new ReverseWords();
        System.out.println(o.myReverseWords(s));
    }
    public String myReverseWords(StringBuilder s){
        int k = 0;
        for (int i = 0; i < s.length(); i++){
            while (i < s.length() && s.charAt(i) == ' ') i++;//i找到单词第一个字母位置
            if (i == s.length()) break;
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') j++;//j找到单词最后字母下一个位置
            reverse(s,i,j-1);
            if (k > 0){
                s.setCharAt(k++, ' ');
            }
            while (i < j) {
                s.setCharAt(k++, s.charAt(i++));//i位置字母移到k位置
            }
        }
        s = new StringBuilder(s.substring(0, k));
        reverse(s,0,s.length()-1);
        return s.toString();
    }

    private void reverse(StringBuilder s, int l, int r) {
        while (l < r){
            char tmp = s.charAt(l);
            s.setCharAt(l,s.charAt(r));
            s.setCharAt(r,tmp);
            l++;
            r--;
        }
    }
}
