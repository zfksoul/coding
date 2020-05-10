package pack;

import java.util.Arrays;

public class Pack01 {
    public static void main(String[] args){
        int[] v = {1,4,4,10};//价值
        int[] c = {1,2,3,4};//体积
        System.out.println(Pack01.find(v, c, 15));
        System.out.println(Pack01.find1(v, c, 15));
    }
    //时间复杂度O(N*capacity)
    //空间复杂度O(N*capacity)
    public static int find(int[] v, int[] c, int capacity){
        int N = v.length;
        int[][] f = new int[N + 1][capacity + 1];
        for (int i = 1; i <= N; i++){
            for (int j = 0; j <= capacity; j++){
                f[i][j] = f[i - 1][j];
                if (j >= c[i - 1]){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - c[i - 1]] + v[i - 1]);
                }
            }
        }
        int res = 0;
        System.out.println(Arrays.toString(f[N]));
        /**
         * 如果只初始化f[0][0]=0,则可能在f[N][capacity]之前就得到了结果，
         * f[N][capacity]表示体积==capacity时的最大价值，需要找到max(f[N][i])
         * 如果最大价值的体积是k，k<capacity,f[N][k]=max_w，它是从f[0][0]推导的
         *
         * 如果f[0][i]都初始化为0，则f[N][capacity]为最终结果，f[N][capacity]表示体积<=capacity时的最大价值
         * f[N][capacity]可以由f[0][capacity-k]推导，相比上一种情况存在capacity-k的偏移量
         */
        /*for (int i = 0; i <= capacity; i++){
            res = Math.max(res, f[N][i]);
        }
        return res;*/
        return f[N][capacity];
    }

    //时间复杂度O(N*capacity)
    //空间复杂度O(capacity)
    public static int find1(int[] v, int[] c, int capacity){
        int N = v.length;
        int[] f = new int[capacity + 1];
        for (int i = 0; i < N; i++){
            for (int j = capacity; j >= c[i]; j--){
                f[j] = Math.max(f[j], f[j - c[i]] + v[i]);
            }
        }
        int res = 0;
        System.out.println(Arrays.toString(f));
        return f[capacity];
    }
}
