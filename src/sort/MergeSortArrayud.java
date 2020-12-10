package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class MergeSortArrayud {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1, 10, 21, 19,31, 0, 8 };
        MergeSortArrayud o = new MergeSortArrayud();
        int[] tmp = new int[arr.length];
        o.myMergeSortArrayud1(arr, tmp, 0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); 
        }
         
        
    }

    //自顶向下+数组
    //时间复杂度O（nlogn）
    //空间复杂度O(n+logn)：n是合并有序序列辅助数组，logn是递归栈深度
    public void myMergeSortArrayud(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {// 当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;// 划分子序列
            myMergeSortArrayud(arr, tmp,  start, mid);// 对左侧子序列进行递归排序
            myMergeSortArrayud(arr, tmp, mid + 1, end);// 对右侧子序列进行递归排序
            int f = start;
            int s = mid + 1;
            int k = start;
            while (f <= mid && s <= end) {
                if (arr[f] <= arr[s]) {// "<="确保排序稳定
                    tmp[k++] = arr[f++];
                }else {
                    tmp[k++] = arr[s++];
                }
            }
            while (f <= mid) {
                tmp[k++] = arr[f++];// 如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
            }
            while (s <= end) {
                tmp[k++] = arr[s++];
            }
            // 复制回原数组
            for (int i = start; i <= end; i++) {
                arr[i] = tmp[i];
            }
        }
    }

    public void myMergeSortArrayud1(int[] arr, int[] tmp, int start, int end) {
        if (start < end){
            int mid = start + end >> 1;
            myMergeSortArrayud1(arr, tmp, start, mid);
            myMergeSortArrayud1(arr, tmp, mid + 1, end);
            int f = start;
            int s = mid + 1;
            int k = start;
            while (f <= mid && s <= end){
                if (arr[f] <= arr[s]){
                    tmp[k++] = arr[f++];
                } else {
                    tmp[k++] = arr[s++];
                }
            }
            while (f <= mid){
                tmp[k++] = arr[f++];
            }
            while (s <= end){
                tmp[k++] = arr[s++];
            }
            for (int i = start; i <= end; i++){
                arr[i] = tmp[i];
            }
        }
    }
}
