package algorithms.array;

/**
 * 给定数组，如果存在一个数在数组中的数量超过一半，打印这个数，否则提示不存在
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class PrintHalfMajor {
    public static void main(String[] args) {
        PrintHalfMajor o = new PrintHalfMajor();
        int[] arr = {1,1,2,1,3};
        o.myPrintHalfMajor(arr);
    }

    private void myPrintHalfMajor(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.print("no such number");
            return;
        }
        int cand = 0;
        int times = 0;
        for (int i = 0; i < arr.length; i++){
            if (times == 0) {
                cand = arr[i];
                times++;
            } else if (arr[i] == cand) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == cand) times++;
        }
        if (times > arr.length / 2) System.out.print(cand);
        else System.out.print("no such number");

    }
    private int myPrintHalfMajor1(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int cnt = 1;
        int res = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (res == arr[i]){
                cnt++;
            } else if (cnt == 0){
                res = arr[i];
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == res){
                cnt++;
            }
        }
        if (cnt > arr.length / 2){
            return res;
        } else {
            return 0;
        }
    }
}
