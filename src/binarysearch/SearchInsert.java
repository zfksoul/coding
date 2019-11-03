package binarysearch;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 上午11:27:23
 * 给定排序数组和目标值，在数组中找到目标值并返回索引，如果不存在，返回它将会按顺序插入的位置
 */
public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        int[] arr = new int[] {1,2,2,3,5,6,6,7};
        System.out.println(s.mySearchInsert(arr, 4));
    }
    public int mySearchInsert(int[] arr, int target) {
        if (arr == null || arr.length == 0 || arr[arr.length - 1] < target) {
            return arr.length;
        }
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if(arr[mid] >= target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}