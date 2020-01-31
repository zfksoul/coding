package algorithms.array;

/**
 * 找到数组中未出现的最小正整数
 */
public class MissNum {
    public static void main(String[] args){
        MissNum o = new MissNum();
        int[] arr = {1,3,4,5,6,2,6,8,3};
        System.out.print(o.myMissNum(arr));
    }
    public int myMissNum(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r){
            if (arr[l] == l + 1){
                l++;
            } else if (arr[l] <= l || arr[l] > r || arr[l] == arr[arr[l] - 1]){
                arr[l] = arr[--r];
            } else if (arr[l] > l + 1 && arr[l] <= r){
                swap(arr, l, arr[l] - 1);
            }
        }
        return l + 1;
    }
    public int myMissNum1(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r){
            if (arr[l] == l + 1){
                l++;
            } else if (arr[l] <= l || arr[l] > r){
                swap(arr, l, --r);
            } else if (arr[l] > l + 1 && arr[l] <= r){
                if (arr[l] == arr[arr[l] - 1]){
                    swap(arr, l, --r);
                } else {
                    swap(arr, l, arr[l] - 1);
                }
            }
        }
        return r + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
