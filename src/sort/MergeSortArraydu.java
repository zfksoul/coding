package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class MergeSortArraydu {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1, 6, 7, 8, 30, 2, 3, 4 };
        MergeSortArraydu o = new MergeSortArraydu();
        arr = o.myMergeSortArraydu1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // 自底向上+数组
    // 时间复杂度O（nlogn）
    // 空间复杂度O(n)：用迭代不用递归，省掉系统栈的额外空间，但是合并有序序列时还是需要O(n)的辅助空间
    public int[] myMergeSortArraydu(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 1; i < arr.length; i *= 2) {//i表示每次迭代的段长度
            int k = 0;
            for (int begin = 0; begin < arr.length; begin += i * 2) {//begin表示当前i长度下每一组排序的开始位置
                // 不能用begin + i < arr.length判断，否则最后部分会丢掉
                int first = begin;//记录该组第一段内的绝对位置
                int second = first + i;//记录该组第二段内的绝对位置
                int f = 0;//记录该组第一段内的相对位置
                int s = 0;//记录该组第二段内的相对位置
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
            }
            for (int m = 0; m < arr.length; m++) {
                arr[m] = tmp[m];
            }
        }
        return arr;
    }
    public int[] myMergeSortArraydu1(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 1; i < arr.length; i *= 2){
            int k = 0;
            for (int begin = 0; begin < arr.length; begin += i * 2){
                int first = begin;
                int second = begin + i;
                int f = 0;
                int s = 0;
                while (f < i && s < i && second < arr.length){
                    if (arr[first] <= arr[second]){
                        tmp[k++] = arr[first++];
                        f++;
                    } else {
                        tmp[k++] = arr[second++];
                        s++;
                    }
                }
                while (f < i && first < arr.length){
                    tmp[k++] = arr[first++];
                    f++;
                }
                while (s < i && second < arr.length){
                    tmp[k++] = arr[second++];
                    s++;
                }
            }
            for (int j = 0; j < arr.length; j++){
                arr[j] = tmp[j];
            }
        }
        return arr;
    }

}
