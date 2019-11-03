package binarysearch;

/**
 * @author zfk
 * @date 2019年10月26日 下午2:56:40
 * 假设升序排序的数组在未知的某个点上进行了旋转，搜索一个给定目标值，若存在则返回它的索引，不存在返回-1 
 * 如【1, 2, 3, 4, 5, 6, 7, 8】变为 【5, 6, 7, 8, 1, 2, 3, 4】
 */
public class Search {

    public static void main(String[] args) {
        Search s = new Search();
        int[] arr = new int[] { 5, 6, 7, 8, 1, 2, 3, 4 };
        System.out.println(s.mySearch(arr, 4));
    }

    public int mySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] <= arr[arr.length - 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[arr.length - 1] >= target) {
            r = arr.length - 1;
        } else {
            l = 0;
            r--;
        }
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == target) {// 这里只能用l，上面r--可能使r=-1,造成数组越界
            return l;
        } else {
            return -1;
        }

    }
}
