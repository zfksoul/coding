package algorithms.others;

/**
 * 给定数，判断是否回文
 */
public class PalindromeNumber {
    public static void main(String[] args){
        PalindromeNumber o = new PalindromeNumber();
        System.out.println(o.isPalindrome(1234321));
        System.out.println(o.isPalindrome1(1234321));
    }
    public boolean isPalindrome1(int n) {
        if (n == Integer.MIN_VALUE){
            return false;
        }
        n = Math.abs(n);
        int help = 1;
        while (n / help >= 10){//防止help溢出
            help *= 10;
        }
        while (n != 0){
            if (n / help != n % 10){
                return false;
            }
            n = (n % help) / 10;
            help /= 100;
        }
        return true;
    }
    public boolean isPalindrome(int n) {
        if (n == Integer.MIN_VALUE){
            return false;
        }
        n = Math.abs(n);
        int i = 1;
        while (i < n){//i可能溢出
            i *= 10;
        }
        i /= 10;
        while (n > 0){
            if (n / i != n % 10){
                return false;
            }
            n %= i;
            n /= 10;
            i /= 100;
        }
        return true;
    }
}
