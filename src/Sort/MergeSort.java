package Sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6, 5, 9, 8, 7, 10, 11 };
        MergeSort o = new MergeSort();
        arr = o.myMergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myMergeSort(int[] arr, int start, int end) {
        if (start < end) {// 当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;// 划分子序列
            myMergeSort(arr, start, mid);// 对左侧子序列进行递归排序
            myMergeSort(arr, mid + 1, end);// 对右侧子序列进行递归排序
            merge(arr, start, mid, end);// 合并
        }
        return arr;
    }

    public void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];// 辅助数组
        int p1 = left, p2 = mid + 1, k = left;// p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
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
