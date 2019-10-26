package binarysearch;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午3:35:58
 * 给定数组nums，其中nums[i]!=nums[i+1]，找到峰值元素并返回其索引，数组可能包含多个峰值，返回任何一个即可
 * 假设nums[-1]=nums[n]=-∞
 */
public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        int[] arr = new int[] { 5, 6, 7, 8, 1, 2, 3, 4 };
        System.out.println(f.myFindPeakElement(arr));
    }

    public int myFindPeakElement(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] > arr[mid + 1]) {//while循环不允许l==r，mid向下取整，不会取到n-1，mid+1不会数组越界
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return arr[l];
    }
}
