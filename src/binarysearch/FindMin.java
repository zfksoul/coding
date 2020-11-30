package binarysearch;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午2:37:38
 * 假设升序排序的数组在未知的某个点上进行了旋转，找到其中最小元素
 * 如【1, 2, 3, 4, 5, 6, 7, 8】变为 【5, 6, 7, 8, 1, 2, 3, 4】
 */
public class FindMin {

    public static void main(String[] args) {
        FindMin f = new FindMin();
        int[] arr = new int[] { 5, 6, 7, 8, 1, 2, 3, 4 };
        System.out.println(f.myFindMin(arr));
        System.out.println(f.myFindMin1(arr));
    }

    public int myFindMin(int[] arr) {
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
        return arr[l];
    }

    public int myFindMin1(int[] arr) {
        if (arr == null || arr.length == 0){
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (arr[mid] < arr[arr.length - 1]){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l];
    }

}
