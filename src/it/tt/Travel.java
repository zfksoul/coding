package it.tt;

import java.util.Scanner;

/**
 * 小明目前在做一份毕业旅行的规划。

 打算从北京出发，分别去若干个城市，然后再回到北京，每个城市之间均乘坐高铁，且每个城市只去一次。

 由于经费有限，希望能够通过合理的路线安排尽可能的省些路上的花销。

 给定一组城市和每对城市之间的火车票的价钱，找到每个城市只访问一次并返回起点的最小车费花销。

 注意：北京为1号城市。

 输入格式
 城市个数n。

 城市间的车票价钱n行n列的矩阵 m[n][n]

 输出格式
 输出一个整数，表示最小车费花销。

 数据范围
 1<n≤20,包括北京
 车票价格均不超过1000元。

 输入样例：
 4
 0 2 6 5
 2 0 4 4
 6 4 0 2
 5 4 2 0
 输出样例：
 13
 说明
 共4个城市，城市1和城市1的车费为0，城市1和城市2之间的车费为2，城市1和城市3之间的车费为6，城市1和城市4之间的车费为5，以此类推。

 假设任意两个城市之间均有单程票可买，且价格均在1000元以内，无需考虑极端情况。

 i是N位二进制数，每一位代表一个城市，j是当前所在城市
 f(i,j)表示当前状态的最小成本，各种子集以最后一段路程划分，0到j,1到j,...,N-1到j
 f(i,j)=f(i - (1 << j), k) + w[k][j]，删掉第j个城市，加上k到j的成本，取最小值
 时间复杂度：状态数*计算，(N^N)*N*N
 状态数：i：N^N  j：N
 计算：决策枚举k：N
 */
public class Travel {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] f = new int[1 << n][n];
        int[][] w = new int[n][n];
        int max = 1000 * 20;//f[][]可能的最大值
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                w[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < 1 << n; i++){
            for (int j = 0; j < n; j++){
                f[i][j] = max;
            }
        }
        f[1][0] = 0;//初始状态，i为当前状态，j表示当前在0号位置
        for (int i = 0; i < (1 << n); i++){//有N^N种i
            for (int j = 0; j < n; j++){
                if (((i >> j) & 1) == 1){//如果j在i范围内
                    for (int k = 0; k < n; k++){
                        if (((i - (1 << j) >> k) & 1) == 1){//如果k在i范围内
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }
        //以上得到了到达终点的最小值，接下来返回原点
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) res = Math.min(res, f[(1 << n) - 1][i] + w[i][0]);
        System.out.println(res);
    }
}
