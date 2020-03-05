package offer;

public class Solution65 {
    public static void main(String[] args){
        Solution65 o = new Solution65();
        char[] m = {'a','b','c','e','s','f','c','8','a','d','e','e'};
        char[] s = {'c','c','e','e'};
        System.out.println(o.hasPath(m, 3, 4, s));
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        boolean[] record = new boolean[matrix.length];
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (dfs(matrix, i, j, rows, cols, str, 0, x, y)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[] matrix, int i, int j, int rows, int cols, char[] str, int index, int[] x, int[] y){
        if (matrix[i * cols + j] != str[index]){
            return false;
        }
        if (index == str.length - 1){
            return true;
        }
        matrix[i * cols + j] = '.';
        for (int k = 0; k < 4; k++){
            int a = i + x[k];
            int b = j + y[k];
            if (a >= 0 && a < rows && b >= 0 && b < cols){
                if (dfs(matrix, i + x[k], j + y[k], rows, cols, str, index + 1, x, y)){
                    return true;
                }
            }
        }
        matrix[i * cols + j] = str[index];
        return false;
    }
}
