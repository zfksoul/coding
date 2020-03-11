package algorithms.others;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {
    public int myCutRope(int target) {
        if (target < 2){
            return 0;
        } else if (target == 2){
            return 1;
        } else if (target == 3) {
            return 2;
        }
        return process(target);
    }
    public int process(int num){
        if (num <= 4) return num;//绳子长度大于4时，分割会产生更大值，绳子长度小于等于4，不用分割
        int max = 0;
        for (int i = 1; i <= num / 2; i++){
            max = Math.max(process(i) * process(num - i), max);
        }
        return max;
    }
    public int myCutRopeDP(int target) {
        if (target < 2){
            return 0;
        } else if (target == 2){
            return 1;
        } else if (target == 3){
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= target; i++){
            int max = 0;
            for (int k = 1; k <= i / 2; k++){
                max = Math.max(dp[k] * dp[i - k], max);
            }
            dp[i] = max;
        }
        return dp[target];
    }
}
