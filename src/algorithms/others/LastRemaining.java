package algorithms.others;

/**
 * 0...m-1报数
 * 小朋友的编号是从0到n-1
 * 报数A转编号B：B = A % n
 * 旧编号O转新编号N：O = (N + S + 1) % n
 * S为被删除的编号,S = (m - 1) % n
 * O = (N + m) % n
 */
public class LastRemaining {
    public static void main(String[] args){
        LastRemaining o = new LastRemaining();
        System.out.println(o.LastRemaining_Solution(4,1));
    }
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 0){
            return -1;
        }
        if (n == 1){
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m ) % n;
    }
}
