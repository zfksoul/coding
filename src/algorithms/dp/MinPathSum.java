package algorithms.dp;

public class MinPathSum {
    public static void main(String[] args){
        MinPathSum o = new MinPathSum();
        int[][] arr = {{1,3,5,9},
                       {8,1,3,4},
                       {5,0,6,1}};
        System.out.print(o.myMinPathSum1(arr));
    }
    public int myMinPathSum(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return 0;
        }
        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);
        boolean rowmore = more == m.length;
        int[] dp = new int[less];
        for (int i = 1; i < less; i++){
            dp[i] = dp[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++){
            dp[0] = dp[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++){
                dp[j] = Math.min(dp[j - 1], dp[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return dp[less - 1];
    }

    public int myMinPathSum2(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0){
            return 0;
        }
        int[] dp = new int[arr[0].length];
        for (int x = 0; x < arr.length; x++){
            for (int y = 0; y < arr[x].length; y++){
                if (x == 0){
                    dp[y] = (y == 0) ? arr[x][y] : arr[x][y] + dp[y - 1];
                } else if (y == 0) {
                    dp[y] = dp[y] + arr[x][y];
                } else {
                    dp[y] = Math.min(dp[y - 1], dp[y]) + arr[x][y];
                }
            }
        }
        return dp[dp.length - 1];
    }
    public int myMinPathSum1(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0){
            return 0;
        }
        int m = Math.max(arr.length, arr[0].length);
        int n = Math.min(arr.length, arr[0].length);
        int x;
        int y;
        int[] dp = new int[n];
        for (int a = 0; a < m; a++){
            for (int b = 0; b < n; b++){
                x = arr.length == m ? a : b;
                y = arr.length == m ? b : a;
                if (a == 0){
                    dp[b] = (b == 0) ? arr[x][y] : arr[x][y] + dp[b - 1];
                } else if (b == 0) {
                    dp[b] = dp[b] + arr[x][y];
                } else {
                    dp[b] = Math.min(dp[b - 1], dp[b]) + arr[x][y];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
