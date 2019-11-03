package Sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class MergeSort2 {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1, 6, 7, 8, 30, 2, 3, 4 };
        MergeSort2 o = new MergeSort2();
        arr = o.myMergeSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // 自底向上+数组
    // 时间复杂度O（nlogn）
    // 空间复杂度O(n)：用迭代不用递归，省掉系统栈的额外空间，但是合并有序序列时还是需要O(n)的辅助空间
    public int[] myMergeSort2(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 1; i < arr.length; i *= 2) {
            int begin = 0;
            int k = 0;
            for (int j = 0; j < arr.length; j += i * 2) {
                // 不能用j + i < arr.length判断，否则最后部分会丢掉
                int first = begin;
                int second = first + i;
                int f = 0;
                int s = 0;
                while (f < i && s < i && second < arr.length) {
                    if (arr[first] <= arr[second]) {
                        tmp[k++] = arr[first++];
                        f++;
                    } else {
                        tmp[k++] = arr[second++];
                        s++;
                    }
                }

                while (f < i && first < arr.length) {// 因为第一段系数有可能超过数组长度，要判断数组越界
                    tmp[k++] = arr[first++];
                    f++;
                }
                while (s < i && second < arr.length) {
                    tmp[k++] = arr[second++];
                    s++;
                }
                begin = second;
            }
            for (int m = 0; m < arr.length; m++) {
                arr[m] = tmp[m];
            }
        }
        return arr;
    }
}
