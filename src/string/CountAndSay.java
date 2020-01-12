package string;

/**
 * 根据上一行输出下一行字符串
 * 1
 * 11
 * 21
 * 1211
 * 111221
 */
public class CountAndSay {
    public static void main(String[] args){
        CountAndSay o = new CountAndSay();
        System.out.println(o.myCountAndSay(6));
    }
    public String myCountAndSay(int n){
        StringBuilder s = new StringBuilder("1");
        for (int i = 0; i < n - 1; i++){
            StringBuilder ns = new StringBuilder();
            for (int j = 0; j < s.length(); j++){
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) k++;
                ns.append(k - j).append(s.charAt(j));
                j = k - 1;
            }
            s = ns;
        }
        return s.toString();
    }
}

