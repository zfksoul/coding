package Sort;

/**
* 
*
* @author zfk
* @date 2019年10月30日 下午8:58:12 
* 
*/
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,5,4,6,6,4,2,1};
        CountingSort o = new CountingSort();
        arr = o.myCountingSort(arr,6);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public int[] myCountingSort(int[] arr, int k) {
        int[] c = new int[k+1];//存放0~k
        int[] res = new int[arr.length];
        for(int i = 0; i<arr.length; i++)
            c[arr[i]]++;
        for(int i = 1; i<=k; i++)
            c[i] += c[i-1];
        for(int i = arr.length-1; i >= 0; i--){
            c[arr[i]]--;
            res[c[arr[i]]] = arr[i];
        }
        return res;
    }
}
