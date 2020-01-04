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
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        MergeSortArrayud o = new MergeSortArrayud();
       
        o.myMergeSortArrayud1(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); 
        }
         
        
    }
    //自顶向下+数组
    //时间复杂度O（nlogn）
    //空间复杂度O(n+logn)：n是合并有序序列辅助数组，logn是递归栈深度
    public void myMergeSortArrayud(int[] arr, int start, int end) {
        if (start < end) {// 当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;// 划分子序列
            myMergeSortArrayud(arr, start, mid);// 对左侧子序列进行递归排序
            myMergeSortArrayud(arr, mid + 1, end);// 对右侧子序列进行递归排序
            int[] tmp = new int[arr.length];
            int p1 = start;
            int p2 = mid + 1;
            int k = start;
            while (p1 <= mid && p2 <= end) {
                if (arr[p1] <= arr[p2]) {// "<="确保排序稳定
                    tmp[k++] = arr[p1++];
                }else {
                    tmp[k++] = arr[p2++];
                }
            }
            while (p1 <= mid) {
                tmp[k++] = arr[p1++];// 如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
            }
            while (p2 <= end) {
                tmp[k++] = arr[p2++];
            }
            // 复制回原数组
            for (int i = start; i <= end; i++) {
                arr[i] = tmp[i];
            }
        }
        return;
    }

    public void myMergeSortArrayud1(int[] arr, int start, int end) {
        if (start < end){
            int mid = (start + end) >> 1;
            myMergeSortArrayud1(arr, start, mid);
            myMergeSortArrayud1(arr, mid+1, end);
            int[] tmp = new int[arr.length];
            int p1 = start;
            int p2 = mid + 1;
            int k = start;
            while (p1 <= mid && p2 <= end){
                if (arr[p1] <= arr[p2]){
                    tmp[k++] = arr[p1++];
                } else {
                    tmp[k++] = arr[p2++];
                }
            }
            while (p1 <= mid){
                tmp[k++] = arr[p1++];
            }
            while (p2 <= end) {
                tmp[k++] = arr[p2++];
            }
            for (int i = start; i <= end; i++){
                arr[i] = tmp[i];
            }
        }
    }
}
