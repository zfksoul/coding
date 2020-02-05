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
        System.out.println(o.getMaxSize(m));
    }
    public int getMaxSize(int[][] m){
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m, right, down);
        for (int size = Math.min(m.length, m[0].length); size > 0; size--){
            if (hasSizeOfBorder(size, right, down)){
                return size;
            }
        }
        return 0;
    }
    public boolean hasSizeOfBorder(int size, int[][] right, int[][] down){
        for (int i = 0; i < right.length - size + 1; i++){
            for (int j = 0; j < right[0].length - size + 1; j++){
                if (right[i][j] >= size && down[i][j] >= size && right[i + size - 1][j] >= size && down[i][j + size - 1] >= size){
                    return true;
                }
            }
        }
        return false;
    }
    public void setBorderMap(int[][] m, int[][] right, int[][] down){
        int r = m.length;
        int c = m[0].length;
        if (m[r - 1][c - 1] == 1){
            right[r - 1][c - 1] = 1;
            down[r - 1][c - 1] = 1;
        }
        for (int i = r - 2; i >= 0; i--){
            if (m[i][c - 1] == 1){
                right[i][c - 1] = 1;
                down[i][c - 1] = down[i + 1][c - 1] + 1;
            }
        }
        for (int i = c - 2; i >= 0; i--){
            if (m[r - 1][i] == 1){
                right[r - 1][i] = right[r - 1][i + 1] + 1;
                down[r - 1][i] = 1;

            }
        }
        for (int i = r - 2; i >= 0; i--){
            for (int j = c - 2; j >= 0; j--){
                if (m[i][j] == 1){
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
    }

    public int maxSize(int[][] m) {
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
                    if (isSquare(down, right, i, j, n)){
                        len = Math.max(len, n);
                    }
                }
            }
        }
        return len;
    }
    public boolean isSquare(int[][] down, int[][] right, int i, int j, int n){
        if (i + n > down.length || j + n > down[0].length){
            return false;
        }
        if (down[i][j] >= n && down[i][j + n - 1] >= n && right[i][j] >= n && right[i + n - 1][j] >= n ){
            return true;
        }
        return false;
    }
}
