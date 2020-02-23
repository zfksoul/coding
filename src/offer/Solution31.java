package offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次
 */
public class Solution31 {
    public int myNumberOf1Between1AndN1(int n) {
        if (n < 1){
            return 0;
        }
        int len = getLenOfNum(n);
        if (len == 1){
            return 1;
        }
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp;
        int firstOneNum = first == 1 ? n % tmp + 1 : tmp;
        int otherOneNum = first * (len - 1) * (tmp / 10);
        return firstOneNum + otherOneNum + myNumberOf1Between1AndN1(n % tmp);
    }
    public int myNumberOf1Between1AndN(int n) {
        if (n < 10){
            return n > 0 ? 1 : 0;
        }
        int cnt = 0;
        int k = getLenOfNum(n);
        int tmp = (int) Math.pow(10, k - 1);
        int firstOneNum = 0;
        int otherOneNum = (n / tmp) * (k - 1) * (tmp / 10);
        if (n / tmp == 1){
            firstOneNum = n % tmp + 1;
        } else {
            firstOneNum = tmp;
        }
        cnt += firstOneNum + otherOneNum + myNumberOf1Between1AndN(n % tmp);
        return cnt;
    }

    private int getLenOfNum(int n) {
        int k = 0;
        while (n > 0){
            n /= 10;
            k++;
        }
        return k;
    }
}
