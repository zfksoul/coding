package algorithms.array;

/**
 * 给定数组，求2个数围成的面积最大值
 */
public class MaxArea {
    public static void main(String[] args){
        MaxArea o = new MaxArea();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(o.getMaxArea(arr));
    }

    public int getMaxArea(int[] arr) {
        if (arr == null || arr.length < 3){
            return 0;
        }
        int l = 0;
        int r = arr.length - 1;
        int res = Integer.MIN_VALUE;
        while (l < r){
            if (arr[l] < arr[r]){
                res = Math.max(res, (r - l - 1) * arr[l++]);
            } else {
                res = Math.max(res, (r - l - 1) * arr[r--]);
            }
        }
        return res;
    }
}
