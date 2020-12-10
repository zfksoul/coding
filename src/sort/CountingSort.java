package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月30日 下午8:58:12
 * 时间复杂度O(n+k)
 * 空间复杂度O(n+k)
 * n为元素数量，k为元素范围
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6, 6, 4, 2, 1 };
        CountingSort o = new CountingSort();
        arr = o.myCountingSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myCountingSort1(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }
        int k = max - min + 1;
        int[] cnt = new int[k];                //存放0~k，空间复杂度O(k)
        int[] res = new int[arr.length];       //空间复杂度O(n)
        for (int i = 0; i < arr.length; i++){  //时间复杂度O(n)
            cnt[arr[i] - min]++;
        }
        for (int i = 1; i < cnt.length; i++){  //时间复杂度O(k)
            cnt[i] += cnt[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--){
            res[--cnt[arr[i] - min]] = arr[i];
        }
        return res;
    }

    public int[] myCountingSort2(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }
        int k = max - min + 1;
        int[] res = new int[arr.length];
        int[] cnt = new int[k];
        for (int i = 0; i < arr.length; i++){
            cnt[arr[i] - min]++;
        }
        for (int i = 1; i < cnt.length; i++){
            cnt[i] += cnt[i - 1];
        }
        for (int i = 0; i < arr.length; i++){
            res[--cnt[arr[i] - min]] = arr[i];
        }
        return res;
    }
}
