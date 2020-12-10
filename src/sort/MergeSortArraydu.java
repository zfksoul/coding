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
        for (int l = 1; l < arr.length; l *= 2) {//l表示每次迭代的段长度
            int k = 0;
            for (int begin = 0; begin < arr.length; begin += l * 2) {//begin表示当前l长度下每一组排序的开始位置
                // 不能用begin + l < arr.length判断，否则最后部分会丢掉
                int f = begin;//记录该组第一段内的绝对位置
                int s = f + l;//记录该组第二段内的绝对位置
                int fc = 0;//记录该组第一段内的相对位置
                int sc = 0;//记录该组第二段内的相对位置
                while (fc < l && sc < l && s < arr.length) {
                    if (arr[f] <= arr[s]) {
                        tmp[k++] = arr[f++];
                        fc++;
                    } else {
                        tmp[k++] = arr[s++];
                        sc++;
                    }
                }
                while (fc < l && f < arr.length) {// 因为第一段系数有可能超过数组长度，要判断数组越界
                    tmp[k++] = arr[f++];
                    fc++;
                }
                while (sc < l && s < arr.length) {
                    tmp[k++] = arr[s++];
                    sc++;
                }
            }
            for (int m = 0; m < arr.length; m++) {
                arr[m] = tmp[m];
            }
        }
        return arr;
    }
    public int[] myMergeSortArraydu1(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }
        int[] tmp = new int[arr.length];
        int f;
        int s;
        int fc;
        int sc;
        int k;
        for (int l = 1; l < arr.length; l *= 2){
            k = 0;
            for (int begin = 0; begin < arr.length; begin += l * 2){
                f = begin;
                s = begin + l;
                fc = 0;
                sc = 0;
                while (fc < l && sc < l && s < arr.length){
                    if (arr[f] <= arr[s]){
                        tmp[k++] = arr[f++];
                        fc++;
                    } else {
                        tmp[k++] = arr[s++];
                        sc++;
                    }
                }
                while (fc < l && f < arr.length){
                    tmp[k++] = arr[f++];
                    fc++;
                }
                while (sc < l && s < arr.length){
                    tmp[k++] = arr[s++];
                    sc++;
                }
            }
            for (int i = 0; i < arr.length; i++){
                arr[i] = tmp[i];
            }
        }
        return arr;
    }

}
