package pack;

import java.util.Arrays;

public class CompletePack {
    public static void main(String[] args){
        int[] v = {1,4,4,10};//价值
        int[] c = {1,2,3,4};//体积
        System.out.println(CompletePack.find(v, c, 15));
    }
    //时间复杂度O(N*capacity)
    //空间复杂度O(capacity)
    /**
     * 对于某个j，如果最优解中包含k个c[i]，
     * f[j - k * c[i]]
     * f[j - (k - 1) * c[i] - c[i]] + v[i]，包含1个c[i]
     * ...
     * f[j - c[i]] + v[i]，包含k-1个c[i]
     * f[j]，包含k个c[i]
     */
    public static int find(int[] v, int[] c, int capacity){
        int N = v.length;
        int[] f = new int[capacity + 1];
        for (int i = 0; i < N; i++){
            for (int j = c[i]; j <= capacity; j++){
                f[j] = Math.max(f[j], f[j - c[i]] + v[i]);
            }
        }
        int res = 0;
        System.out.println(Arrays.toString(f));
        return f[capacity];
    }
}
