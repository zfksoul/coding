package sort;

import java.util.List;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月29日 下午8:52:27
 * 
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1,22, 3, 2, 5, 4, 6, 5, 9, 8, 7, 10, 11 };
        HeapSort o = new HeapSort();
        o.myHeapSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myHeapSort1(int[] arr) {
       /* 自底向上建堆
        * 时间复杂度O(n)
        * s=∑2^(i-1)*(k-i)堆高度为k，第i层有2^(i-1)个节点，每个节点判断(k-i)次,i从k-1层到1层
        * S=2^(k-2)*1+2^(k-3)*2+2^(k-4)*3+...+2^(1)*(k-2)+2^(0)*(k-1)
        * 2S=2^(k-1)*1+2^(k-2)*2+2^(k-3)*3...+2^(2)*(k-2)+2^(1)*(k-1)
        * 2S-S=S=2^(k-1)*1+2^(k-2)+...+2^2+2^1-(k-1)=2^k-k-1
        * 等比数列求和：Sn=a1*(1-q^n)/(1-q)=2*(1-2^(k-1))/(1-2)=2^k-2
        * 有2^k个节点，设为N
        * S=N-logn-1
        * 时间复杂度为O(N)
        */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            pushDown(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {//排序，将最大的节点放在堆尾，然后从根节点重新调整
            swap(arr, 0, i);
            pushDown(arr, 0, i);
        }
        return arr;
    }
    public void pushDown(int[] arr, int i, int len) {//大顶堆
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < len && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < len && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, largest, i);
            pushDown(arr, largest, len);
        }
    }
   /* public void heapify(int[] arr, int i, int len) {//堆调整，建立大根堆
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < len && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < len && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }
*/
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /* 自顶向下建堆
     * 时间复杂度O(nlogn)
     * 证明：
     * 第k层有2^(k-1)个节点，交换k次，共n层
     * S = 1+2*(2^1)+3*(2^2)+4*(2^3)+5*(2^4)+...+n*(2^(n-1))
     * 2S= 0+1*(2^1)+2*(2^2)+3*(2^3)+4*(2^4)+...+(n-1)*(2^(n-1))+n*(2^(n))
     * 2S-S=-1-2-2^2-2^3-...-2^(n-1)+n*(2^(n))
     * -1-2-2^2-2^3-...-2^(n-1)=-（1*（1-2^（n））/(1-2)=-(2^n-1)≈-2^n
     * s=(n-1)*（2^n），堆共有2^n个节点，设为N
     * S和N的关系：NlogN
     */
    public void myHeapSort2(int[] heap) {
        for (int i = 0; i < heap.length; i++) {
            pushUp(heap, i);
        }
        for (int i = heap.length - 1; i > 0; i--) {
            swap(heap,0,i);
            pushDown(heap,0,i);
        }
    }

    
    public void pushUp(int[] arr, int i) {//大顶堆
        int father = (i - 1) / 2;
        if (father >= 0 && arr[father] < arr[i]) {
            swap(arr,father,i);
            pushUp(arr,father);
        }
    }
    

    
    //插入堆
    /*public void insert(List<Integer> heap, int len, int x) {
        heap.add(x);
        pushUp(heap, len+1);
    }*/
    
    //删除堆顶元素
    /*public void removeTop(List<Integer> heap, int size) {
        heap.set(0,heap.get(size));
        heap.remove(size);
        pushDown(heap,heap.size(),0);
    }*/
    
    //改变堆中一个数，重新调整堆
    //pushUp(x)
    //pushDown(x)

}
