package algorithms.string;

public class StrToInt {
    public static void main(String[] args){
        StrToInt o = new StrToInt();
        String str = "123";
        System.out.println(o.myStrToInt(str));
    }
    public int myStrToInt(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        int res = 0;
        boolean flag = true;
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            res = str.charAt(0) - '0';
        } else if (str.charAt(0) == '+'){
            flag = true;
        } else if (str.charAt(0) == '-'){
            flag = false;
        } else {
            return 0;
        }
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9' ){
                res = res * 10 + str.charAt(i) - '0';
            } else {
                return 0;
            }
        }
        return flag ? res : -res;
    }
}
