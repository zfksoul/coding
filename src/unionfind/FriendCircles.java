package unionfind;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 *  学生0和1是朋友，自己和自己是朋友
 *  给定朋友关系矩阵，求朋友圈个数
 */
public class FriendCircles {
    public static void main(String[] args){
        int[][] m = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(FriendCircles.findCircleNum(m));
    }
    public static int findCircleNum(int[][] m){
        int N = m.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (m[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++){
            if (uf.findRecur(i) == i){//看有多少人自己是自己的根节点
                res++;
            }
        }
        return res;
    }
}
