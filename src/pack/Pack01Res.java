package pack;

import java.util.ArrayList;
import java.util.Arrays;

//输出字典序最小的结果 123 < 32
//f[n][m] == f[n - 1][m] 不选n
//f[n][m] == f[n - 1][m - c[n]] + v[n], 选n
/*input:
4 5
1 2
2 4
3 4
4 6
output:
1 4*/
public class Pack01Res {
    public static void main(String[] args){
        int[] c = {1,2,3,4};
        int[] v = {2,4,4,6};
        System.out.println(Arrays.toString(Pack01Res.find(c, v, 5)));
    }

    private static Integer[] find(int[] c, int[] v, int capacity) {
        int N = c.length;
        int[][] f = new int[N + 1][capacity + 1];//二维空间对体积循环没限制，优化后的体系循环会有限制
        for (int i = N - 1; i >= 0; i--){//求最小字典序，则要从小到大反推结果，所以从大到小创建dp数组
            for (int j = 0; j <= capacity; j++){
                if (j >= c[i]){
                    f[i][j] = Math.max(f[i + 1][j], f[i + 1][j - c[i]] + v[i]);
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int vol = capacity;
        ArrayList list = new ArrayList();
        for (int i = 0; i < N; i++){
            if (f[i][vol] == f[i + 1][vol - c[i]] + v[i]){//判断是否使用该物品
                list.add(i + 1);
                vol -= c[i];
            }
        }
        return (Integer[])list.toArray(new Integer[0]);
    }

}
