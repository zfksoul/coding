package pack;

import java.util.ArrayList;
import java.util.Arrays;

//多重背包，有数量限制
public class MultiPack1 {
    public static void main(String[] args){
        int[] v = {2,4,4,5,2};//价值
        int[] c = {1,2,3,4,4};//体积
        int[] s = {3,1,3,2,5};//数量
        System.out.println(MultiPack1.find(v, c, s, 10));
        System.out.println(MultiPack1.find1(v, c, s, 10));
        System.out.println(MultiPack1.find2(v, c, s, 10));
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
        int N = c.length;
        int[] f = new int[capacity + 1];
        int[] g;
        int[] q = new int[capacity + 1];
        for (int i = 0; i < N; i++){
            g = Arrays.copyOf(f, f.length);
            for (int j = 0; j < c[i]; j++){
                int h = 0;
                int t = -1;
                for (int k = j; k <= capacity; k += c[i]){
                    if (h <= t && k - c[i] * s[i] > q[h]) h++;
                    if (h <= t) f[k] = Math.max(f[k], g[q[h]] + (k - q[h]) / c[i] * v[i]);
                    while (h <= t && g[q[t]] - (q[t] - j) / c[i] * v[i] <= g[k] - (k - j) / c[i] * v[i]) t--;
                    q[++t] = k;
                }
            }
        }
        return f[capacity];
    }
}
