package algorithms.dp;

public class MinPathSum {
    public static void main(String[] args){
        MinPathSum o = new MinPathSum();
        int[][] arr = {{1,3,5,9},
                       {8,1,3,4},
                       {5,0,6,1},
                       {8,8,4,0}};
        System.out.print(o.myMinPathSum(arr));
    }

    private int myMinPathSum(int[][] arr) {
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
}
