package algorithms.dp;

/**
 * 给定整形数组arr，A和B依次从左或右拿走纸牌，返回获胜者分数
 */
public class WinCard {
    public static void main(String[] args){
        WinCard o = new WinCard();
        int[] arr = {1,2,100,4};
        System.out.println(o.win(arr));
        System.out.println(o.win1(arr));
        System.out.println(o.win2(arr));
    }
    public int win2(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++){
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--){
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }
    public int win1(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++){
            f[i][i] = arr[i];
        }
        for (int i = arr.length; i >= 0; i--){
            for (int j = i + 1; j < arr.length; j++){
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }
    public int win(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }
    public int f(int[] arr, int l, int r){
        if (l == r){
            return arr[l];
        } else {
            return Math.max(arr[l] + s(arr, l + 1, r), arr[r] + s(arr, l, r - 1));
        }
    }
    public int s(int[] arr, int l, int r){
        if (l == r){
            return 0;
        } else {
            return Math.min(f(arr, l + 1, r), f(arr, l, r - 1));
        }
    }

}
