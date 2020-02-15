package algorithms.array;

import java.util.ArrayList;

/**
 * 螺旋打印数组
 */
public class SpiralOrderPrintMatrix1 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};
        SpiralOrderPrintMatrix1 o = new SpiralOrderPrintMatrix1();
        System.out.println(o.printMatrix(arr));
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return res;
        }
        int i1 = 0;
        int j1 = 0;
        int i2 = matrix.length - 1;
        int j2 = matrix[0].length - 1;
        while (i1 <= i2 && j1 <= j2){
            print(matrix, i1, j1, i2, j2, res);
            i1++;
            j1++;
            i2--;
            j2--;
        }
        return res;
    }

    public void print(int[][] arr, int i1, int j1, int i2, int j2, ArrayList<Integer> res) {
        if (i1 == i2){
            for (int j = j1; j <= j2; j++){
                res.add(arr[i1][j]);
            }
        } else if (j1 == j2){
            for (int i = j1; i <= i2; i++){
                res.add(arr[i][j2]);
            }
        } else {
            for (int j = j1; j < j2; j++){
                res.add(arr[i1][j]);
            }
            for (int i = i1; i < i2; i++){
                res.add(arr[i][j2]);
            }
            for (int j = j2; j > j1; j--){
                res.add(arr[i2][j]);
            }
            for (int i = i2; i > i1; i--){
                res.add(arr[i][j1]);
            }
        }
    }
}
