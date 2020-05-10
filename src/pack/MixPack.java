package pack;

import java.util.ArrayList;

/**
 * 混合背包
 * si=-1表示第i种物品只能用1次
 * si=0表示第i种物品可以用无限次
 * si>0表示第i种物品可以用si次
 */
public class MixPack {
    public static void main(String[] args){
        int[] c = {1,2,3,4};
        int[] v = {2,4,4,5};
        int[] s = {-1,1,0,2};
        System.out.println(MixPack.find(c, v, s, 5));
    }
    public static int find(int[] c, int[] v, int[]s, int capacity){
        int N = v.length;
        ArrayList<Things> things = new ArrayList<>();
        for (int i = 0; i < N; i++){
            if (s[i] < 0){
                things.add(new Things(-1, c[i], v[i]));
            } else if (s[i] == 0){
                things.add(new Things(0, c[i], v[i]));
            } else {
                int n = s[i];
                for (int k = 1; k <= n; k <<= 1){
                    things.add(new Things(-1, c[i] * k, v[i] * k));
                    n -= k;
                }
                if (n > 0){
                    things.add(new Things(-1, c[i] * n, v[i] * n));
                }
            }
        }
        int[] f = new int[capacity + 1];
        for (Things t : things){
            if (t.type == -1){
                for (int i = capacity; i >= t.c; i--){
                    f[i] = Math.max(f[i], f[i - t.c] + t.v);
                }
            } else {
                for (int i = t.c; i <= capacity; i++){
                    f[i] = Math.max(f[i], f[i - t.c] + t.v);
                }
            }
        }
        return f[capacity];
    }
}

class Things{
    public int type;
    public int c;
    public int v;
    public Things(int type, int c, int v){
        this.type = type;
        this.c = c;
        this.v = v;
    }
}