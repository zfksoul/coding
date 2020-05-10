package pack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 有依赖关系的背包问题
 * N V
 * ci vi pi
 * pi表示依赖的物品编号，pi=-1表示根节点
 * */
 /*input:
 5 7
 2 3 -1
 2 2 1
 3 5 1
 4 7 2
 3 6 2
 output:
 11
 */
public class DependPack {
    public static int[][] f;
    public static ArrayList<Integer>[] g;
    public static int[] c;
    public static int[] v;
    public static int N;
    public static int capacity;
    public static int root;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        capacity = in.nextInt();
        c = new int[N + 1];
        v = new int[N + 1];
        f = new int[N + 1][capacity + 1];
        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++){
            c[i] = in.nextInt();
            v[i] = in.nextInt();
            int p = in.nextInt();
            if (p == -1){
                root = i;
            } else {
                g[p].add(i);
            }
        }
        dfs(root);
        System.out.println(f[root][capacity]);
    }
    public static void dfs(int x){
        for (int i = capacity; i >= c[x]; i--){//f[x][i]至少放入x节点，初始化为v[i]，容量小于c[x]初始化为0
            f[x][i] = v[x];
        }
        for (int i = 0; i < g[x].size(); i++){//遍历x节点下的所有子节点
            int y = g[x].get(i);
            dfs(y);//递归获得子节点的结果f[y][i]
            for (int j = capacity; j >= c[x]; j--){//分组背包，从大到小循环体积
                for (int k = 0; k <= j - c[x]; k++){//循环策略，背包体积为j时，有j-c[k]种策略
                    f[x][j] = Math.max(f[x][j], f[x][j - k] + f[y][k]);
                }
            }
        }
    }
}
