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
        System.out.println(o.myCountAndSay1(6));
    }
    public String myCountAndSay(int n){
        StringBuilder s = new StringBuilder("1");
        for (int i = 0; i < n - 1; i++){
            StringBuilder ns = new StringBuilder();
            for (int j = 0; j < s.length(); j++){
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) k++;
                ns.append (k - j).append(s.substring(j,j+1));
                j = k - 1;
            }
            s = ns;
        }
        return s.toString();
    }
    public String myCountAndSay1(int n){
        StringBuilder s = new StringBuilder("1");
        for (int i = 0; i < n - 1; i++){
            StringBuilder ns = new StringBuilder();
            int k = 0;
            for (int j = 0; j < s.length(); j++){
                while (k < s.length() && s.charAt(k) == s.charAt(j)) k++;
                ns.append(k - j).append(s.substring(j, j + 1));
                j = k - 1;
            }
            s = ns;
        }
        return s.toString();
    }
    /*public String myCountAndSay2(int n){
        StringBuilder s = new StringBuilder("1");
        StringBuilder ns = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < n - 1; i++){
            for (int j = 1; j < s.length(); j++){
                if (s.charAt(j) == s.charAt( j - 1)){
                    cnt++;
                } else {
                    ns.append(cnt).append(s.charAt(j - 1));
                    cnt = 1;
                }
            }
            ns.append(cnt).append(s.charAt(s.length() - 1));
            cnt = 1;
            s = ns;
            ns = new StringBuilder();
        }
        return s.toString();
    }*/
}

