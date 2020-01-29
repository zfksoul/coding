package algorithms.array;

/**
 * 螺旋打印数组
 */
public class SpiralOrderPrintMatrix {
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16}};
        SpiralOrderPrintMatrix o = new SpiralOrderPrintMatrix();
        o.mySpiralOrderPrintMatrix(arr);
    }
    public void mySpiralOrderPrintMatrix(int[][] arr){
        if (arr == null || arr.length == 0 || arr[0].length == 0) return;
        int i1 = 0, j1 = 0;
        int i2 = arr.length - 1, j2 = arr[0].length - 1;
        while (i1 <= i2 && j1 <= j2){
            printEdge(arr, i1, j1, i2, j2);
            i1++;
            j1++;
            i2--;
            j2--;
        }
    }
    public void printEdge(int[][] arr, int i1, int j1, int i2, int j2){
        if (i1 == i2){
            for (int j = j1; j <= j2; j++){
                System.out.print(arr[i1][j]+" ");
            }
        } else if (j1 == j2){
            for (int i = i1; i <= i2; i++){
                System.out.print(arr[i][j1]+" ");
            }
        } else {
            for (int j = j1; j < j2; j++) {
                System.out.print(arr[i1][j] + " ");
            }
            for (int i = i1; i < i2; i++) {
                System.out.print(arr[i][j2] + " ");
            }
            for (int j = j2; j > j1; j--) {
                System.out.print(arr[i2][j] + " ");
            }
            for (int i = i2; i > i1; i--) {
                System.out.print(arr[i][j1] + " ");
            }
        }
    }
}
