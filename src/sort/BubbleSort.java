package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月27日 下午9:07:11
 * 
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6 };
        BubbleSort o = new BubbleSort();
        arr = o.myBubbleSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myBubbleSort1(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = false; // 优化
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
        return arr;
    }

    public int[] myBubbleSort2(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        for (int i = arr.length - 1; i > 0; i--){
            boolean flag = false;
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return arr;
    }

}
