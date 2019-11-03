package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class MergeSort1 {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        MergeSort1 o = new MergeSort1();
       
        arr = o.myMergeSort1(arr,0,arr.length-1); 
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); 
        }
         
        
    }
    //自顶向下+数组
    //时间复杂度O（nlogn）
    //空间复杂度O(n+logn)：n是合并有序序列辅助数组，logn是递归栈深度
    public int[] myMergeSort1(int[] arr, int start, int end) {
        if (start < end) {// 当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;// 划分子序列
            myMergeSort1(arr, start, mid);// 对左侧子序列进行递归排序
            myMergeSort1(arr, mid + 1, end);// 对右侧子序列进行递归排序
            int[] tmp = new int[arr.length];
            int p1 = start;
            int p2 = mid + 1;
            int k = start;
            while (p1 <= mid && p2 <= end) {
                if (arr[p1] <= arr[p2]) {
                    tmp[k++] = arr[p1++];
                }else {
                    tmp[k++] = arr[p2++];
                }
            }
            while (p1 <= mid) {
                tmp[k++] = arr[p1++];
            }
            while (p2 <= end) {
                tmp[k++] = arr[p2++];
            }
            for (int i = start; i <= end; i++) {
                arr[i] = tmp[i];
            }
        }
        return arr;
    }

    public void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];// 辅助数组
        int p1 = left, p2 = mid + 1, k = left;// p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])// "<="确保排序稳定
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }

        while (p1 <= mid)
            tmp[k++] = a[p1++];// 如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right)
            tmp[k++] = a[p2++];// 同上

        // 复制回原素组
        for (int i = left; i <= right; i++)
            a[i] = tmp[i];
    }

}
