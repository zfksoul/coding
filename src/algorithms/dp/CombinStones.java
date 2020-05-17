package algorithms.dp;

import java.util.Scanner;

/**
 * 石子合并
 * 只能合并相邻石子
 * 合并的代价为石子质量之和
 * 求合并的最小代价
 */
/*
input:
4
1 3 5 2
output:
22
*/

public class CombinStones {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n + 1];//前缀和
        int[][] f = new int[n + 1][n + 1];//状态数组
        for (int i = 1; i <= n; i++){
            s[i] = in.nextInt();
            s[i] += s[i - 1];
        }
        for (int len = 2; len <= n; len++){//区间问题，先枚举区间长度
            for (int i = 1; i + len - 1 <= n; i++){//区间问题，再枚举区间左端点
                int j = i + len - 1;//右端点
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){//枚举所有k里面的最小值
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
                }

            }
        }
        System.out.println(f[1][n]);
    }
}
