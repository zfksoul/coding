package binarysearch;

/**
* 
*
* @author zfk
* @date 2019年10月26日 下午4:37:42 
* h系数，最多有h篇论文被引用了至少h次
* 给定一位研究者论文被引用次数的数组（非负整数），数组已按升序排列
*/
public class HIndex1 {

    public static void main(String[] args) {
        HIndex1 f = new HIndex1();
        int[] arr = new int[] { 0, 3, 5, 6 };
        System.out.println(f.myHIndex1(arr));
        System.out.println(f.myHIndex2(arr));
    }
    //排好序
    public int myHIndex1(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (arr[arr.length - mid] >= mid) {  //arr.length - 1 - mid + 1, mid范围：[1,arr.length]
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int myHIndex2(int[] arr) {
        if (arr == null || arr.length == 0){
            return -1;
        }
        int l = 0;
        int r = arr.length;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (arr[arr.length - mid] >= mid){
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    //不排序
    public int myHIndex3(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= mid) {
                    cnt++;
                }
            }
            if (cnt >= mid) {
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
    //不排序
    public int myHIndex4(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= mid) {
                    cnt++;
                }
            }
            if (cnt >= mid) {
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }

}
