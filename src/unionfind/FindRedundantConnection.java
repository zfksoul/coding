package unionfind;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * input:[[1,2],[1,3],[2,3]]
 * output:[2,3]
 * 没加2,3之前，它们就已经连通
 * 返回最后一个冗余连接
 * 定点下标1-N，数组大小等于N个数
 */
public class FindRedundantConnection {
    public static void main(String[] args){
        FindRedundantConnection o = new FindRedundantConnection();
        int[][] edges = {{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(o.find(edges)));
    }
    public int[] find(int[][] edges){
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) return new int[]{};
        int N = edges.length;
        UnionFind uf = new UnionFind(N + 1);
        int[] res = new int[2];
        for (int i = 0; i < N; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if (uf.union(u, v)){//冗余
                res[0] = u;
                res[1] = v;
            }
        }
        return res;
    }
}
