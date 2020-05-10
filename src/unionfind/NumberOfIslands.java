package unionfind;

/**
 * 1表示陆地，0表示水，给定矩阵，求岛屿数量
 */
public class NumberOfIslands {
    public static void main(String[] args){
        NumberOfIslands o = new NumberOfIslands();
        int[][] m = {{1,1,1,1,0},
                     {1,1,0,1,0},
                     {1,1,0,0,0},
                     {0,0,0,0,1}};
        System.out.println(o.numIslands(m));
    }
    public int encode(int i, int j, int n){
        return i * n + j;
    }
    public int numIslands(int[][] m){
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) return 0;
        int M = m.length;
        int N = m[0].length;
        UnionFind uf = new UnionFind(M * N);
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (m[i][j] == 1){
                    for (int d = 0; d < 4; d++){
                        int di = directions[d][0];
                        int dj = directions[d][1];
                        if (i + di >= 0 && i + di < M && j + dj >= 0 && j + dj < N
                                && m[i + di][j + dj] == 1){
                            uf.union(encode(i, j, N), encode(i + di, j + dj, N));
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (m[i][j] == 1){
                    int id = encode(i, j, N);
                    if (uf.findRecur(id) == id){//看有多少是自己的根节点
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
