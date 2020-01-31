package algorithms.array;

public class GetSmallSum {
    public static void main(String[] args){
        GetSmallSum o = new GetSmallSum();
        int[] arr = {1,3,5,2,4,6};
        System.out.print(o.myGetSmallSum(arr));
    }

    public int myGetSmallSum(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return func(arr, 0, arr.length - 1);
    }

    private int func(int[] arr, int l, int r) {
        if (l == r){
            return 0;
        }
        int mid = (l + r) / 2;
        return func(arr, l ,mid) + func(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private int merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int k = 0;
        int i = l;
        int j = mid + 1;
        int sum = 0;
        while (i <= mid && j <= r){
            if (arr[i] <= arr[j]){
                sum += arr[i] * (r - j + 1);
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        for (; (i <= mid) || (j <= r); j++, i++){
            tmp[k++] = i > mid ? arr[j] : arr[i];
        }
        for (k = 0; k < tmp.length; k++){
            arr[l++] = tmp[k];
        }
        return sum;
    }

    public int myGetSmallSum1(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        return merge1(arr, 0, arr.length - 1);
    }

    private int merge1(int[] arr, int l, int r) {
        if (l < r){
            int mid = (l + r) >> 1;
            int lsum = merge1(arr, l, mid);
            int rsum = merge1(arr, mid + 1, r);
            int[] tmp = new int[r - l + 1];
            int i = l;
            int j = mid + 1;
            int k = 0;
            int sum = 0;
            while (i <= mid && j <= r){
                if (arr[i] < arr[j]){
                    sum += arr[i] * (r - j + 1);
                    tmp[k++] = arr[i++];
                } else {
                    tmp[k++] = arr[j++];
                }
            }
            while (i <= mid){
                tmp[k++] = arr[i++];
            }
            while (j <= r){
                tmp[k++] = arr[j++];
            }
            k = 0;
            i = l;
            while (i <= r){
                arr[i++] = tmp[k++];
            }
            return sum + lsum + rsum;
        }
        return 0;
    }
}
