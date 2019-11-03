package binarysearch;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午4:08:25 
 * 给定一个包含n+1个整数的数组nums，数字在1到n之间（包括1和n），可知至少存在一个重复的整数，
 * 假设只有一个重复整数，找到这个重复的数
 */
public class AFindDuplicate {

    public static void main(String[] args) {
        AFindDuplicate f = new AFindDuplicate();
        int[] arr = new int[] { 5, 6, 7, 8, 1, 2, 2, 3, 4 };
        System.out.println(f.myFindDuplicate(arr));
    }

    public int myFindDuplicate(int[] arr) {
        int n = arr.length - 1;
        int l = 1, r = n;
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
}
