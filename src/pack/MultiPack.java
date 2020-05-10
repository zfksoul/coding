package pack;

import java.util.ArrayList;
import java.util.Arrays;

//多重背包，有数量限制
public class MultiPack {
    public static void main(String[] args){
        int[] v = {2,4,4,5,2};//价值
        int[] c = {1,2,3,4,4};//体积
        int[] s = {3,1,3,2,5};//数量
        System.out.println(MultiPack.find(v, c, s, 10));
        System.out.println(MultiPack.find1(v, c, s, 10));
        System.out.println(MultiPack.find2(v, c, s, 10));
    }

    public static int find(int[] v, int[] c, int[] s, int capacity){
        int N = v.length;
        int[] f = new int[capacity + 1];
        for (int i = 0; i < N; i++){
            for (int j = capacity; j >= 0; j--){
                for (int k = 1; k <= s[i] && k * c[i] <= j; k++){
                    f[j] = Math.max(f[j], f[j - k * c[i]] + k * v[i]);
                }
            }
        }
        System.out.println(Arrays.toString(f));
        return f[capacity];
    }

    //二进制优化
    //时间复杂度O(N*log(s)*capacity)
    public static int find1(int[] v, int[] c, int[] s, int capacity){
        ArrayList<Integer> arrC = new ArrayList<>();
        ArrayList<Integer> arrV = new ArrayList<>();
        int N = v.length;
        int[] f = new int[capacity + 1];
        for (int i = 0; i < N; i++){
            int n = s[i];
            for (int k = 1; k <= n; k *= 2){
                n -= k;
                arrC.add(c[i] * k);
                arrV.add(v[i] * k);
            }
            if (n > 0){
                arrC.add(c[i] * n);
                arrV.add(v[i] * n);
            }
        }
        for (int i = 0; i < arrC.size(); i++){
            for (int j = capacity; j >= arrC.get(i); j--){
                f[j] = Math.max(f[j], f[j - arrC.get(i)] + arrV.get(i));
            }
        }
        return f[capacity];
    }

    /**
     * 单调队列优化
     * 时间复杂度O(N*capacity)
     * f[j] = f[j-c]+v,f[j-2c]+2v,...,f[j-k*c]+k*v
     * f[0] + 2v = (f[0])       + 2v
     * f[c] + v  = (f[c] - v)   + 2v
     * f[2c]     = (f[2c] - 2v) + 2v
     *
     * 等价于比较下面的大小
     * f[0]
     * f[c] - v
     * f[2c] - 2v
     *
     */
    public static int find2(int[] v, int[] c, int[] s, int capacity){
        int[] f = new int[capacity + 1];
        int[] g;
        int[] q = new int[capacity + 1];
        int N = c.length;
        for (int i = 0; i < N; i++){
            g = Arrays.copyOf(f, f.length);//当计算第i个物品时，g[]记录第i-1个物品的结果
            for (int j = 0; j < c[i]; j++){
                int h = 0;
                int t = -1;
                for (int k = j; k <= capacity; k += c[i]){//从左往右遍历，左边结果被更新，需要g[]记录第i-1次结果
                    //??
                    //f[k] = g[k];
                    //队头的坐标超过s[i] * c[i]限制，去掉
                    if (h <= t && k - s[i] * c[i] > q[h]) h++;
                    //用最大数更新当前数
                    if (h <= t) f[k] = Math.max(f[k], g[q[h]] + (k - q[h]) / c[i] * v[i]);
                    //用坐标k更新队列，用
                    while (h <= t && g[q[t]] - (q[t] - j) / c[i] * v[i] <= g[k] - (k - j) / c[i] * v[i]) t--;
                    q[++t] = k;//q[]记录第i物品时价值从大到小的坐标
                }
            }
        }
        return f[capacity];
    }
}
