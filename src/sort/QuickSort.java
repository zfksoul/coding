package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午11:00:34
 * 
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6, 5, 9, 8, 7, 10, 11 };
        QuickSort o = new QuickSort();
        o.quickSort2(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*public int[] myQuickSort2(int[] arr, int l, int r) {
        if (l < r) {
            int i = l - 1;
            int j = r + 1;
            int mid = (l + r) >> 1;
            while (i < j) {
                do {
                    j--;
                } while (arr[j] > arr[mid]);
                do {
                    i++;
                } while (arr[i] < arr[mid]);
                if (i < j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } else {
                    myQuickSort2(arr, l, j);
                    myQuickSort2(arr, j + 1, r);
                }
            }
        }
        return arr;
    }*/

    public int[] myQuickSort1(int[] arr, int l, int r) {
        if (l < r) {
            int partionIndex = partition1(arr, l, r);
            myQuickSort1(arr, l, partionIndex - 1);
            myQuickSort1(arr, partionIndex + 1, r);
        }
        return arr;
    }


    public int partition1(int[] arr, int l, int r) {
        int pivot = l;
        int p = l + 1;//p始终指向第一个比arr[pivot]大的数
        for (int i = p; i <= r; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, pivot, p - 1);
        return p - 1;
    }
    //随机快排
    public int partitionRandom1(int[] arr, int l, int r) {
        int ran = l + (int)(Math.random()*(r - l + 1));//l~r范围内产生随机数,Math.random()产生[0,1)的随机数
        swap(arr,l,ran);
        int pivot = l;
        int p = l + 1;//p始终指向第一个比arr[pivot]大的数
        for (int i = p; i <= r; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, pivot, p - 1);
        return p - 1;
    }

    public void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public void quickSort2(int[] arr, int l, int r){
        if (l < r){
            int[] p = partitionRandom2(arr, l, r);
            quickSort2(arr, l, p[0]-1);
            quickSort2(arr, p[1]+1, r);
        }
    }
    /*public int[] partition2(int[] arr, int l, int r){
        int less = l - 1;//less表示最后一个小于arr[r]的位置
        int more = r;//more在交换之前表示第一个大于arr[r]的位置，和arr[r]交换之后表示最后一个等于arr[r]的位置
        while (l < more){
            if (arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if (arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }*/
    public int[] partition2(int[] arr, int l, int r){
        int pivot = l;
        int p = l + 1;//p-1表示第一个等于arr[pivot]的位置
        int q = r;//q表示最后一个等于arr[pivot]的位置
        int i = p;
        while (i <= q){
            if (arr[i] < arr[pivot]){
                swap(arr,i++,p++);
            }else if (arr[i] > arr[pivot]){
                swap(arr,i,q--);
            }else{
                i++;
            }
        }
        swap(arr,pivot,p-1);
        return new int[]{p-1,q};
    }
    //随机快排
    public int[] partitionRandom2(int[] arr, int l, int r){
        int ran = l + (int)(Math.random()*(r - l + 1));//l~r范围内产生随机数,Math.random()产生[0,1)的随机数
        swap(arr,l,ran);
        int pivot = l;
        int p = l + 1;//p-1表示第一个等于arr[pivot]的位置
        int q = r;//q表示最后一个等于arr[pivot]的位置
        int i = p;
        while (i <= q){
            if (arr[i] < arr[pivot]){
                swap(arr,i++,p++);
            }else if (arr[i] > arr[pivot]){
                swap(arr,i,q--);
            }else{
                i++;
            }
        }
        swap(arr,pivot,p-1);
        return new int[]{p-1,q};
    }
}
