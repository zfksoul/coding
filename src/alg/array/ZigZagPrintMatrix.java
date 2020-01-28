package alg.array;


/**
 * 之子打印矩阵
 */
public class ZigZagPrintMatrix {
    public static void main(String[] args){
        int[][] arr = {{ 1, 2, 3, 4},
                       { 5, 6, 7, 8},
                       { 9,10,11,12},
                       {13,14,15,16}};
        ZigZagPrintMatrix o = new ZigZagPrintMatrix();
        o.myZigZagPrintMatrix(arr);
    }

    private void myZigZagPrintMatrix(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) return;
        int i1 = 0, j1 = 0;
        int i2 = 0, j2 = 0;
        boolean flag = false;
        while (j1 < arr[0].length && i2 < arr.length){
            myprint(arr, i1, j1, i2, j2, flag);
            flag = !flag;
            if (i1 != arr.length - 1){
                i1++;
            } else {
                j1++;
            }
            if (j2 != arr[0].length - 1){
                j2++;
            } else {
                i2++;
            }
        }
    }

    private void myprint(int[][] arr, int i1, int j1, int i2, int j2, boolean flag) {
        if (flag){
            for (int i = i2, j = j2; i <= i1; i++, j--){
                System.out.print(arr[i][j] + " ");
            }
        } else {
            for (int i = i1, j = j1; i >= i2; i--, j++){
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
