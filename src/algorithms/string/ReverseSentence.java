package algorithms.string;

public class ReverseSentence {
    public static void main(String[] args){
        ReverseSentence o = new ReverseSentence();
        String str = "I am a student.";
        System.out.println(o.myReverseSentence1(str));
    }
    public String myReverseSentence1(String str) {
        if (str == null || str.trim().length() == 0){
            return str;
        }
        char[] c = str.toCharArray();
        reverse(c, 0, c.length - 1);
        int l = 0;
        int r = 0;
        while (l < c.length){
            if (c[r] != ' '){
                r++;
            } else {
                reverse(c, l, r - 1);
                r++;
                l = r;
            }
            if (r == c.length){
                reverse(c, l, r - 1);
                break;
            }
        }
        return String.valueOf(c);
    }

    private void reverse(char[] c, int l, int r) {
        if (l >= r){
            return;
        }
        while (l < r){
            char tmp = c[l];
            c[l] = c[r];
            c[r] = tmp;
            l++;
            r--;
        }
    }

    public String myReverseSentence(String str) {
        if (str == null || str.trim().length() == 0){
            return str;
        }
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--){
            sb.append(s[i]);
            sb.append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return new String(sb);
    }

}
