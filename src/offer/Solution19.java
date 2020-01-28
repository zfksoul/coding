package offer;

import java.util.ArrayList;

/**
* 
*
* @author zfk
* @date 2019年10月20日 下午7:11:40 
* 
*/
public class Solution19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int i1 = 0, j1 = 0;
        int i2 = matrix.length-1, j2 = matrix[0].length-1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(i1 <= i2 && j1 <= j2) {
            fun(i1, j1, i2, j2, matrix, res);
            i1++;
            j1++;
            i2--;
            j2--;
        }
        return res;
    }
    public void fun(int i1, int j1, int i2, int j2, int[][] matrix, ArrayList<Integer> res) {
        for (int y = j1; y <= j2; y++) {
            res.add(matrix[i1][y]);
        }
        for (int x = i1+1; x <= i2; x++) {
            res.add(matrix[x][j2]);
        }
        if(i1 != i2) {
            for (int y = j2-1; y >= j1; y--) {
                res.add(matrix[i2][y]);
            }
        }
        if(j1 != j2) {
            for (int x = i2-1; x > i1; x--) {
                res.add(matrix[x][j1]);
            }  
        }
    }
}
