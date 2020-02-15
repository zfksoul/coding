package algorithms.string;

/**
 * 将字符串中的" "替换成"%20"
 */
public class ReplaceBlankToChars {
    public static void main(String[] args){
        ReplaceBlankToChars o = new ReplaceBlankToChars();
        StringBuffer sb = new StringBuffer("we are happy.");
        System.out.println(o.replaceSpace(sb));
    }
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.equals("")){
            return "";
        }
        char[] c = str.toString().toCharArray();
        int cnt = 0;
        for (int i = 0; i < c.length; i++){
            if (c[i] == ' '){
                cnt++;
            }
        }
        char[] res = new char[c.length + cnt * 2];
        int index = 0;
        for (int i = 0; i < c.length; i++){
            if (c[i] == ' '){
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            } else {
                res[index++] = c[i];
            }
        }
        return new String(res);
    }
}
