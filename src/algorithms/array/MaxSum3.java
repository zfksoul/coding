package algorithms.array;

/**
 * 子矩阵最大累加和
 */
public class MaxSum3 {
    public static void main(String[] args){
        MaxSum3 o = new MaxSum3();
        /*int[][] m = {{-90,48,78},
                     {64,-40,64},
                     {-81,-7,66}};*/
        int[][] m = {{-1,-1,-1},
                     {-1,2,2},
                     {-1,-1,-1}};
        System.out.println(o.myMaxSum(m));
        System.out.println(o.myMaxSum1(m));
    }
    private int myMaxSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s;
        for (int i = 0; i < m.length; i++){
            s = new int[m[0].length];
            for (int j = i; j < m.length; j++){
                cur = 0;
                for (int k = 0; k < s.length; k++){
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

    private int myMaxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length ==0){
            return 0;
        }
        int lengs = m.length < m[0].length ? m[0].length : m.length;
        int shorts = m.length < m[0].length ? m.length : m[0].length;
        boolean rowmore = m.length < m[0].length ? false : true;
        int[] help = new int[shorts];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < lengs; k++){
            for (int j = 0; j < shorts; j++){
                help[j] = 0;
            }
            for (int i = k; i < lengs; i++){
                help[0] += rowmore ? m[i][0] : m[0][i];
                sum = help[0] < 0 ? 0 : help[0];
                max = Math.max(sum, max);
                for (int j = 1; j < shorts; j++){
                    help[j] += rowmore ? m[i][j] : m[j][i];
                    sum += help[j];
                    sum = sum < 0 ? 0 : sum;
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
}
