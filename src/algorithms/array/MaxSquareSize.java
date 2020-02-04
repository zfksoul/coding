package algorithms.array;

import java.util.Arrays;

/**
 * 边界都是1的最大正方形大小
 * 时间复杂度O(n^3)+O(n^2)=O(n^3)
 */
public class MaxSquareSize {
    public static void main(String[] args){
        MaxSquareSize o = new MaxSquareSize();
        int[][] m = {{0,1,1,1,1},
                     {0,1,0,0,1},
                     {0,1,0,0,1},
                     {0,1,1,1,1},
                     {0,1,0,1,1}};
        System.out.println(o.maxSize(m));
    }

    private int maxSize(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return 0;
        }
        //构造辅助矩阵，时间复杂度O(n^2)
        int[][] down = new int[m.length][m[0].length];
        int[][] right = new int[m.length][m[0].length];
        down[m.length - 1][m[0].length - 1] = m[m.length - 1][m[0].length - 1] == 0 ? 0 : 1;
        right[m.length - 1][m[0].length - 1] = m[m.length - 1][m[0].length - 1] == 0 ? 0 : 1;
        for (int j = m[0].length - 2; j >= 0; j--){
            down[m.length - 1][j] = m[m.length - 1][j] == 0 ? 0 : 1;
            right[m.length - 1][j] = m[m.length - 1][j] == 0 ? 0 : right[m.length - 1][j + 1] + 1;
        }
        for (int i = m.length - 2; i >= 0; i--){
            down[i][m[0].length - 1] = m[i][m[0].length - 1] == 0 ? 0 : down[i + 1][m[0].length - 1] + 1;
            right[i][m[0].length - 1] = m[i][m[0].length - 1] == 0 ? 0 : 1;
        }
        for (int i = m.length - 2; i >= 0; i--){
            for (int j = m[0].length - 2; j >= 0; j--){
                down[i][j] = m[i][j] == 0 ? 0 : down[i + 1][j] + 1;
                right[i][j] = m[i][j] == 0 ? 0 : right[i][j + 1] + 1;
            }
        }
        //查找，时间复杂度O(n^3)
        int len = 0;
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                for (int n = 1; n <= m.length; n++){
                    if (isSquare(m, down, right, i, j, n)){
                        len = Math.max(len, n);
                    }
                }
            }
        }
        return len;
    }
    public boolean isSquare(int[][] m, int[][] down, int[][] right, int i, int j, int n){
        if (i + n > m.length || j + n > m[0].length){
            return false;
        }
        if (down[i][j] >= n && down[i][j + n - 1] >= n && right[i][j] >= n && right[i + n - 1][j] >= n ){
            return true;
        }
        return false;
    }
}
