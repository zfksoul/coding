package algorithms.others;

/**
 * 给定整数求二进制数中1的个数，复数用补码表示
 */
public class NumberOf1 {
    public static void main(String[] args){
        NumberOf1 o = new NumberOf1();
        System.out.println(o.myNumOf1(-12));
    }
    public int myNumOf1(int num){
        int cnt = 0;
        while (num != 0){
            num &= (num - 1);
            cnt++;
        }
        return cnt;
    }
}
