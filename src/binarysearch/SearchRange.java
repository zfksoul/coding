package binarysearch;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午1:11:57
 * 给定升序排列数组和目标值，找到目标值在数组中的开始位置和结束位置，如果不存在，返回[-1,-1]
 */
public class SearchRange {
    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        int[] arr = new int[] {1,2,3,3,5,6};
        int[] res = s.mySearchRange(arr,4 );
        System.out.println(res[0]+"--"+res[1]);
    }

    public int[] mySearchRange(int[] arr, int target) {
        if (arr == null) {
            return new int[] { -1, -1 };
        }
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] != target) {
            return new int[] { -1, -1 };
        }
        int start = l;
        l = 0;
        r = arr.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (arr[mid] <= target) {
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        int end = l;
        return new int [] {start, end};
    }
}
