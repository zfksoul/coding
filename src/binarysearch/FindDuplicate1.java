package binarysearch;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午4:08:25 
 * 给定一个包含n+1个整数的数组nums，数字在1到n之间（包括1和n），可知至少存在一个重复的整数，
 * 假设只有一个重复整数，找到这个重复的数
 * 每次统计O(n)，共O(logn)次，时间复杂度O(nlogn)
 */
public class FindDuplicate1 {

    public static void main(String[] args) {
        FindDuplicate1 f = new FindDuplicate1();
        int[] arr = new int[] { 5, 6, 7, 8, 1, 2, 2, 3, 4 };
        System.out.println(f.myFindDuplicate1(arr));
    }

    public int myFindDuplicate(int[] arr) {
        int r = arr.length - 1;
        int l = 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 1 && arr[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid - l + 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    public int myFindDuplicate1(int[] arr) {
        if (arr == null || arr.length == 0){
            return -1;
        }
        int l = 1;
        int r = arr.length - 1;
        while (l < r){
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++){
                if (arr[i] >= l && arr[i] <= mid){
                    cnt++;
                }
            }
            if (cnt > mid - l + 1){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
