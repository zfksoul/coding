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
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        InversePairs o = new InversePairs();
        System.out.println(o.inversePairs(arr, 0, arr.length - 1));
        
    }

    /*一个横坐标，向右为正方向，有n个车，每个车速度不同，初始位置不同
     * 车速为v
     * v>0,V<0,V=0
     * 经过无限长时间，小车相遇多少次
     * 求速度的逆序对个数为答案 
     */
    // 用归并排序查找逆序对
    public int inversePairs(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            int tmp[] = new int[arr.length];
            int mid = (l + r) / 2;
            res += inversePairs(arr, l, mid);
            res += inversePairs(arr, mid + 1, r);
            int p1 = l;
            int p2 = mid + 1;
            int k = l;
            while (p1 <= mid && p2 <= r) {
                if (arr[p1] <= arr[p2]) {
                    tmp[k++] = arr[p1++];
                } else {
                    tmp[k++] = arr[p2++];
                    res += mid - p1 + 1;
                }
            }
            while (p1 <= mid) {
                tmp[k++] = arr[p1++];
            }
            while (p2 <= r) {
                tmp[k++] = arr[p2++];
            }
            for (int i = l; i <= r; i++) {
                arr[i] = tmp[i];
            }
        }
        return res;
    }

}