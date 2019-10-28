package Sort;

/**
* 
*
* @author zfk
* @date 2019年10月27日 下午9:07:11 
* 
*/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,5,4,6};
        BubbleSort o = new BubbleSort();
        arr = o.myBubbleSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public int[] myBubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
    

}
