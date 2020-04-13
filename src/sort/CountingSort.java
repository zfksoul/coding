package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月30日 下午8:58:12
 * 
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6, 6, 4, 2, 1 };
        CountingSort o = new CountingSort();
        arr = o.myCountingSort2(arr, 6);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myCountingSort1(int[] arr, int k) {
        int[] c = new int[k + 1];           // 存放0~k，空间复杂度O(k)
        int[] res = new int[arr.length];    //空间复杂度O(n)
        for (int i = 0; i < arr.length; i++)//时间复杂度O(n)
            c[arr[i]]++;
        for (int i = 1; i <= k; i++)        //时间复杂度O(k)
            c[i] += c[i - 1];               //c[i]中记录i在res数组中的下标
        for (int i = arr.length - 1; i >= 0; i--) {
            c[arr[i]]--;
            res[c[arr[i]]] = arr[i];
        }
        return res;
    }

    public int[] myCountingSort2(int[] arr, int k) {
        int[] cnt = new int[k + 1];
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            cnt[arr[i]]++;
        }
        for (int i = 1; i < cnt.length; i++){
            cnt[i] += cnt[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--){
            //cnt[arr[i]]--;
            res[--cnt[arr[i]]] = arr[i];
        }
        return res;
    }
}
