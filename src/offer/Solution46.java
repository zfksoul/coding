package offer;

/**
 * 0...m-1报数
 * 小朋友的编号是从0到n-1
 * 报数A转编号B：B = A % n
 * 旧编号O转新编号N：O = (N + S) % n
 * S为被删除的编号
 * O = (N + m) % n
 */
public class Solution46 {
    public static void main(String[] args){
        Solution46 o = new Solution46();
        System.out.println(o.LastRemaining_Solution(4,1));
    }
    public int LastRemaining_Solution(int n, int m) {

        if (n == 0){
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m + 1) % (n + 1);
    }
}
