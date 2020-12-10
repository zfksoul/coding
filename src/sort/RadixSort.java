package sort;

/**
* 
*
* @author zfk
* @date 2019年10月30日 下午11:42:24 
* 基数排序
 * 时间复杂度O(d*(n+k))
 * 空间复杂度O(n+k)
 * d为最大位数
 * n为元素数
 * k为桶数量
*/
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,5,41,11,23,63,21,54,6,4,2,1};
        RadixSort o = new RadixSort();
        arr = o.myRadixSort1(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public int[] myRadixSort(int[] arr) {
        if (arr == null || arr.length <= 1){
            return arr;
        }
        int[] c = new int[10];
        int[] tmp = new int[arr.length];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int d = 0;
        while (max > 0){
            max /= 10;
            d++;
        }
        for (int div = 1; div <= Math.pow(10, d - 1); div *= 10) {
            //计数排序
            for (int i = 0; i < arr.length; i++) {
                c[(arr[i]/div)%10]++;
            }
            for (int i = 1; i < c.length; i++) {
                c[i] += c[i-1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                tmp[--c[(arr[i]/div)%10]] = arr[i];
            }
            //更新数组顺序
            for (int i = 0; i < arr.length; i++) {
                arr[i] = tmp[i];
            }
            //计数归零
            for (int i = 0; i < c.length; i++) {
                c[i] = 0;
            }
        }
        return arr;
    }

    public int[] myRadixSort1(int[] arr) {
        if (arr == null || arr.length <= 1){
            return arr;
        }
        int[] tmp = new int[arr.length];
        int[] cnt = new int[10];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            max = arr[i] > max ? arr[i] : max;
        }
        int d = 0;
        while (max > 0){
            max /= 10;
            d++;
        }
        for (int div = 1; div <= Math.pow(10, d - 1); div *= 10){
            for (int i = 0; i < arr.length; i++){
                cnt[arr[i] / div % 10]++;
            }
            for (int i = 1; i < cnt.length; i++){
                cnt[i] += cnt[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--){
                tmp[--cnt[arr[i] / div % 10]] = arr[i];
            }
            for (int i = 0; i < arr.length; i++){
                arr[i] = tmp[i];
            }
            for (int i = 0; i < cnt.length; i++){
                cnt[i] = 0;
            }
        }
        return arr;
    }



   /* public int get(int x, int i) {
        while (i > 0) {
            x /= 10;
            i--;
        }
        return x % 10;
    }*/

}
