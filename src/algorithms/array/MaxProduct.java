package algorithms.array;

/**
 * 数组中子数组最大累乘积
 * 子数组或子串：以i-1结尾，求以i结尾
 * 子序列：0~i-1,求0~i
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class MaxProduct {
    public static void main(String[] args){
        MaxProduct o = new MaxProduct();
        double[] arr = {-2.5, 4, 0, 3, 0.5, 8, -1};
        System.out.print(o.myMaxProduct(arr));
    }

    public double myMaxProduct(double[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        for (int i = 1; i < arr.length; i++){
            max = Math.max(arr[i] * max, Math.max(arr[i] * min, arr[i]));
            min = Math.min(arr[i] * max, Math.min(arr[i] * min, arr[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
