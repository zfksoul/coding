package offer;

import java.util.Arrays;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月10日 下午8:09:19
 * 
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int [][] arr1 = null;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        Solution1 sol = new Solution1();
        boolean b = sol.Find(0, arr);
        System.out.println(b);
    }

    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean FindStd(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        // 右上
        int row = 0; // 注意
        int col = cols - 1; // 注意
        while (row < rows && col >= 0) { // 注意
            if (array[row][col] < target) {
                row++; // 注意
            } else if (array[row][col] > target) {
                col--; // 注意
            } else {
                return true;
            }
        }
        return false;
    }
}
