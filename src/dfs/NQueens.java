package dfs;

public class NQueens {
    int n;
    int res = 0;
    boolean[] col,d,ud;
    public static void main(String[] args){
        NQueens o = new NQueens();
        System.out.println(o.totalNQueens(4));
    }
    int totalNQueens(int n){
        this.n = n;
        col = new boolean[n];//每列一个皇后
        d = new boolean[n * 2];//每条斜线一个皇后，有2n-1个对角线，x+y表示在第几条斜线上
        ud = new boolean[n * 2];//每条斜线一个皇后，有2n-1个对角线，x-y+n表示在第几条斜线上
        dfs(0);//枚举每一行
        return res;
    }

    private void dfs(int k) {
        if (k == n){
            res++;
            return;
        }
        for (int i = 0; i < n; i++){//枚举每一列
            if (!col[i] && !d[k+i] && !ud[k-i+n]){
                col[i] = d[k+i] = ud[k-i+n] = true;
                dfs(k+1);
                col[i] = d[k+i] = ud[k-i+n] = false;
            }
        }
    }
}
