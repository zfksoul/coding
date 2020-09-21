package binarysearch;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午1:48:55
 * 编写一个高效的算法来判断矩阵中是否存在一个目标值，该矩阵有如下特性：
 * 每行中的整数从左到右按升序排列
 * 每行的第一个整数大于前一行的最后一个整数
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0,1,2,3},
                                      {4,5,6,7},
                                      {8,9,10,11},
                                      {12,13,14,15}};
        SearchMatrix s = new SearchMatrix();
        System.out.println(s.mySearchMatrix(matrix,9));
        System.out.println(s.mySearchMatrix1(matrix,9));
    }

    public boolean mySearchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (matrix[mid / m][mid % m] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if(matrix[l/m][l%m]!=target) {
            return false;
        }else {
            return true;
        }
    }

    public boolean mySearchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (matrix[mid / n][mid % n] >= target){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (matrix[l / n][l % n] != target){
            return false;
        }
        return true;
    }

}
