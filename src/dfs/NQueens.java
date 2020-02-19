package dfs;

public class NQueens {
    int n;
    int res = 0;
    boolean[] col,d,ud;
    public static void main(String[] args){
        NQueens o = new NQueens();
        System.out.println(o.totalNQueens(8));
        System.out.println(o.totalNQueens1(8));
        System.out.println(o.totalNQueens2(8));
    }
    public int totalNQueens2(int n) {
        if (n < 1){
            return 0;
        }
        boolean[] col = new boolean[n];
        boolean[] d = new boolean[2 * n];
        boolean[] ud = new boolean[2 * n];
        int res = process(col, d, ud, 0);
        return res;
    }

    private int process(boolean[] col, boolean[] d, boolean[] ud, int x) {
        if (x == col.length){
            return 1;
        }
        int res = 0;
        for (int y = 0; y < col.length; y++){
            if (!col[y] && !d[x + y] && !ud[x - y + col.length]){
                col[y] = d[x + y] = ud[x - y + col.length] = true;
                res += process(col, d, ud, x +1);
                col[y] = d[x + y] = ud[x - y + col.length] = false;
            }
        }
        return res;
    }

    public int totalNQueens1(int n) {
        if (n < 1){
            return 0;
        }
        boolean[] col = new boolean[n];
        boolean[] d = new boolean[2 * n];
        boolean[] ud = new boolean[2 * n];
        int[] res = new int[1];
        process(col, d, ud, res, 0);
        return res[0];
    }

    private void process(boolean[] col, boolean[] d, boolean[] ud, int[] res, int x) {
        if (x == col.length){
            res[0]++;
            return;
        }
        for (int y = 0; y < col.length; y++){
            if (!col[y] && !d[x + y] && !ud[x - y + col.length]){
                col[y] = d[x + y] = ud[x - y + col.length] = true;
                process(col, d, ud, res, x +1);
                col[y] = d[x + y] = ud[x - y + col.length] = false;
            }
        }
    }

    int totalNQueens(int n){
        this.n = n;
        col = new boolean[n];//每列一个皇后
        //每条斜线一个皇后，有2n-1个对角线，x+y表示在第几条斜线上，x+y取值范围[0,2n-2]
        d = new boolean[n * 2];
        //每条斜线一个皇后，有2n-1个对角线，x-y+n表示在第几条斜线上，x-y+n取值范围[1,2n-1]
        ud = new boolean[n * 2];
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
