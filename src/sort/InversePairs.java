package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class InversePairs {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1, 20, 1, 9, 23, 12, 0 };
        int[] tmp = new int[arr.length];
        InversePairs o = new InversePairs();
        System.out.println(o.inversePairs(arr, tmp, 0, arr.length - 1));
        arr = new int[] { 5, 4, 3, 2, 1, 20, 1, 9, 23, 12, 0 };
        System.out.println(o.inversePairs1(arr, tmp, 0, arr.length - 1));

    }

    /*一个横坐标，向右为正方向，有n个车，每个车速度不同，初始位置不同
     * 车速为v
     * v>0,V<0,V=0
     * 经过无限长时间，小车相遇多少次
     * 求速度的逆序对个数为答案 
     */
    // 用归并排序查找逆序对
    public int inversePairs(int[] arr, int[] tmp, int l, int r) {
        int res = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            res += inversePairs(arr, tmp, l, mid);
            res += inversePairs(arr, tmp, mid + 1, r);
            int f = l;
            int s = mid + 1;
            int k = l;
            while (f <= mid && s <= r) {
                if (arr[f] <= arr[s]) {
                    tmp[k++] = arr[f++];
                } else {
                    tmp[k++] = arr[s++];
                    res += mid - f + 1;
                }
            }
            while (f <= mid) {
                tmp[k++] = arr[f++];
            }
            while (s <= r) {
                tmp[k++] = arr[s++];
            }
            for (int i = l; i <= r; i++) {
                arr[i] = tmp[i];
            }
        }
        return res;
    }
    public int inversePairs1(int[] arr, int[] tmp, int l, int r) {
        int res = 0;
        if (l < r){
            int mid = l + r >> 1;
            res += inversePairs1(arr, tmp, l, mid);
            res += inversePairs1(arr, tmp, mid + 1, r);
            int f = l;
            int s = mid + 1;
            int k = l;
            while (f <= mid && s <= r){
                if (arr[f] <= arr[s]){
                    tmp[k++] = arr[f++];
                } else {
                    res += mid - f + 1;
                    tmp[k++] = arr[s++];
                }
            }
            while (f <= mid){
                tmp[k++] = arr[f++];
            }
            while (s <= r){
                tmp[k++] = arr[s++];
            }
            for (int i = l; i <= r; i++){
                arr[i] = tmp[i];
            }
        }
        return res;
    }
}