package binarysearch;

/**
 * @author zfk
 * @date 2019年10月26日 上午9:33:22
 */
public class BinarySearch {
    /*
     * 当我们将区间[l, r]划分成[l, mid]和[mid + 1, r]时，
     * 其更新操作是r = mid或者l = mid + 1，
     * 计算mid时不需要加1。
     *
     * 找第一个大于target的数
     */
    public int binarySearch1(int l, int r, int target, int[] arr) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /*
     * 当我们将区间[l, r]划分成[l, mid - 1]和[mid, r]时，
     * 其更新操作是r = mid - 1或者l = mid，
     * 此时为了防止死循环，计算mid时需要加1。
     *
     * 找第一个小于等于target的数
     */
    public int binarySearch2(int l, int r, int target, int[] arr) {
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (arr[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
