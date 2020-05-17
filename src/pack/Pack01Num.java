package pack;

import java.util.Arrays;

//求01背包的最大值方案数
/*input:
4 5
1 2
2 4
3 4
4 6
output:
2*/
public class Pack01Num {
    public static void main(String[] args){
        int[] c = {1,2,3,4};
        int[] v = {2,4,4,6};
        System.out.println(Pack01Num.find(c, v, 12));
    }

    public static int find(int[] c, int[] v, int capacity){
        int N = c.length;
        int[] f = new int[capacity + 1];
        int[] g = new int[capacity + 1];//记录每种容量的最大值方案数
        for (int i = 1; i <= capacity; i++){//只初始化f[0],使得最优解一定是从f[0]推导的，即f[i]代表背包容量==i时的最大价值
            f[i] = Integer.MIN_VALUE;
        }
        g[0] = 1;//只初始化g[0]，不考虑任何物品之前，体积是0的方案数是1种
        int mod = 1000000007;
        for (int i = 0; i < N; i++){
            for (int j = capacity; j >= c[i]; j--){
                int tmp = Math.max(f[j], f[j - c[i]] + v[i]);
                int cnt = 0;
                if (tmp == f[j]){//如果使用f[j]，则计算g[j]决策的方案数
                    cnt += g[j];
                }
                if (tmp == f[j - c[i]] + v[i]){//如果使用f[j-c[i]]+v[i],则计算g[j-c[i]]决策的方案数
                    cnt += g[j - c[i]];
                }
                if (cnt >= mod) cnt -= mod;
                f[j] = tmp;
                g[j] = cnt;
            }
        }
        int max = 0;
        System.out.println(Arrays.toString(f));
        System.out.println(Arrays.toString(g));
        for (int i = 0; i <= capacity; i++){//不一定用满容量才可以得到最优解
            max = Math.max(max, f[i]);
        }
        int res = 0;
        for (int i = 0; i <= capacity; i++){
            if (f[i] == max){
                res += g[i];
            }
            if (res >= mod) res -= mod;
        }
        return res;
    }
}
